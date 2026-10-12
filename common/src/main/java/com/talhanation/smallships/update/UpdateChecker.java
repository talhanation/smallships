package com.talhanation.smallships.update;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.talhanation.smallships.SmallShipsMod;
import com.talhanation.smallships.config.SmallShipsConfig;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.SharedConstants;
import org.jetbrains.annotations.Nullable;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The update check of the mod: reads one small json file from the repository
 * and compares the version it names with the one that is installed.
 *
 * Deliberately NOT the update checker of a loader. Forge has one and Fabric has
 * none, and the one Forge has only ever fills its own mod list - this one is
 * the same code on every platform. All a platform contributes is the installed
 * version ({@link #getModVersion()}) and the moment the server has started.
 *
 * Every Minecraft version has a branch of its own, named after that version,
 * and every branch carries its own update.json in its root:
 *
 * <pre>
 * {
 *   "version": "2.1.0",
 *   "homepage": "https://modrinth.com/mod/small-ships"
 * }
 * </pre>
 *
 * A build only ever looks at the branch of the Minecraft version it runs on,
 * so 1.20.1 and 1.21.1 are released independently of each other: raising the
 * version in the file of one branch reaches the players of that Minecraft
 * version and nobody else. The homepage is optional.
 *
 * The file is fetched once per game start, on a thread of its own: a slow or
 * missing connection must never hold up a world that is loading. Whoever wants
 * the result gets a future and is called back when it is there.
 */
public class UpdateChecker {

    /** %s is the branch, which is named after the Minecraft version */
    private static final String UPDATE_URL = "https://raw.githubusercontent.com/talhanation/smallships/%s/update.json";
    /** where the player is sent if the file names no homepage of its own */
    private static final String DEFAULT_HOMEPAGE = "https://modrinth.com/mod/small-ships";
    private static final int TIMEOUT_MILLIS = 10_000;

    public enum Status {
        UP_TO_DATE,
        OUTDATED,
        /** the file could not be read - no connection, a broken file, a timeout */
        FAILED
    }

    /**
     * @param currentVersion the installed version
     * @param latestVersion  the version the file of this branch names, null if
     *                       it names none or could not be read
     * @param homepage       where the update can be downloaded
     */
    public record Result(Status status, String currentVersion, @Nullable String latestVersion, String homepage) {
    }

    /** the one check of this game start, shared by the client and the server side */
    @Nullable
    private static CompletableFuture<Result> result;

    /**
     * @return the installed version of the mod, as the loader knows it. The
     * only platform specific piece of the whole check.
     */
    @ExpectPlatform
    public static String getModVersion() {
        throw new AssertionError();
    }

    /**
     * Starts the check on first use and hands out the same result from then
     * on. Never blocks: the future completes on the fetch thread, so a caller
     * that touches the game has to get back onto its own thread first.
     */
    public static synchronized CompletableFuture<Result> check() {
        if (result == null) {
            CompletableFuture<Result> future = new CompletableFuture<>();
            Thread thread = new Thread(() -> future.complete(fetch()), "SmallShips Update Checker");
            // a hanging connection must not keep the game from closing
            thread.setDaemon(true);
            thread.start();
            result = future;
        }
        return result;
    }

    /**
     * Server side: writes the result to the log once the server is up. Called
     * by the platforms from their server started event - not earlier, the
     * server config is not loaded before that.
     */
    public static void onServerStarted() {
        if (!SmallShipsConfig.Server.updateCheckerEnable.get()) return;
        check().thenAccept(checked -> {
            switch (checked.status()) {
                case OUTDATED -> {
                    SmallShipsMod.LOGGER.warn("A new version of Small Ships is available: {} (installed: {})", checked.latestVersion(), checked.currentVersion());
                    SmallShipsMod.LOGGER.warn("Download the new update here: {}", checked.homepage());
                }
                case FAILED -> SmallShipsMod.LOGGER.error("Small Ships could not check for updates!");
                default -> {}
            }
        });
    }

    private static Result fetch() {
        String currentVersion = getModVersion();
        String minecraftVersion = SharedConstants.getCurrentVersion().getName();
        String url = String.format(UPDATE_URL, minecraftVersion);
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(TIMEOUT_MILLIS);
            connection.setReadTimeout(TIMEOUT_MILLIS);
            try (Reader reader = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8)) {
                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
                String homepage = json.has("homepage") ? json.get("homepage").getAsString() : DEFAULT_HOMEPAGE;
                String latestVersion = readVersion(json, minecraftVersion);
                // a file that names no version announces nothing
                if (latestVersion == null) return new Result(Status.UP_TO_DATE, currentVersion, null, homepage);

                Status status = compareVersions(latestVersion, currentVersion) > 0 ? Status.OUTDATED : Status.UP_TO_DATE;
                return new Result(status, currentVersion, latestVersion, homepage);
            } finally {
                connection.disconnect();
            }
        } catch (Exception exception) {
            // debug only: being offline is not worth a stack trace in every log.
            // The one line that says the check failed comes from whoever asked
            SmallShipsMod.LOGGER.debug("Could not read {}: {}", url, exception.toString());
            return new Result(Status.FAILED, currentVersion, null, DEFAULT_HOMEPAGE);
        }
    }

    /**
     * @return the version the file names. "version" is the field to maintain.
     * A file still written the Forge way - "promos" with one entry per
     * Minecraft version - is read as well, so a branch that keeps the old file
     * for the Forge mod list does not need a second one.
     */
    @Nullable
    private static String readVersion(JsonObject json, String minecraftVersion) {
        if (json.has("version")) return json.get("version").getAsString();
        if (!json.has("promos")) return null;
        JsonObject promos = json.getAsJsonObject("promos");
        if (promos.has(minecraftVersion + "-recommended")) return promos.get(minecraftVersion + "-recommended").getAsString();
        if (promos.has(minecraftVersion + "-latest")) return promos.get(minecraftVersion + "-latest").getAsString();
        return null;
    }

    /**
     * Compares two version strings the way they are written in this mod:
     * "2.0.0", "2.0.1", "2.0.0-b1.4", "2.0.0a2.0".
     *
     * A version is read as a row of numbers and words, whatever separates
     * them. Numbers compare as numbers, so 2.0.10 is newer than 2.0.9, and
     * words by the alphabet, so a beta is newer than an alpha. Where one
     * version simply goes on while the other has ended, it depends on HOW it
     * goes on: with a number it is the newer one (2.0.0.1 after 2.0.0), with a
     * word it is a pre-release of the shorter one and therefore older
     * (2.0.0-b1.4 before 2.0.0).
     *
     * @return positive if the first version is newer, negative if it is older,
     * 0 if both are the same
     */
    public static int compareVersions(String first, String second) {
        List<String> firstParts = splitVersion(first);
        List<String> secondParts = splitVersion(second);
        int shared = Math.min(firstParts.size(), secondParts.size());
        for (int i = 0; i < shared; i++) {
            String firstPart = firstParts.get(i);
            String secondPart = secondParts.get(i);
            boolean firstNumber = isNumber(firstPart);
            boolean secondNumber = isNumber(secondPart);

            int order;
            if (firstNumber && secondNumber) order = compareNumbers(firstPart, secondPart);
            // a number against a word: the word marks a pre-release, 2.0.0.1 is newer than 2.0.0-b1
            else if (firstNumber != secondNumber) order = firstNumber ? 1 : -1;
            else order = firstPart.compareTo(secondPart);
            if (order != 0) return order;
        }
        if (firstParts.size() == secondParts.size()) return 0;

        boolean firstIsLonger = firstParts.size() > secondParts.size();
        String next = (firstIsLonger ? firstParts : secondParts).get(shared);
        int longerIsNewer = isNumber(next) ? 1 : -1;
        return firstIsLonger ? longerIsNewer : -longerIsNewer;
    }

    /** "2.0.0-b1.4" -> [2, 0, 0, b, 1, 4] */
    private static List<String> splitVersion(String version) {
        List<String> parts = new ArrayList<>();
        StringBuilder part = new StringBuilder();
        boolean partIsNumber = false;
        for (char character : version.toLowerCase().toCharArray()) {
            boolean digit = Character.isDigit(character);
            boolean letter = Character.isLetter(character);
            // a separator, or a switch between digits and letters, ends the part
            if (part.length() > 0 && ((!digit && !letter) || digit != partIsNumber)) {
                parts.add(part.toString());
                part.setLength(0);
            }
            if (digit || letter) {
                part.append(character);
                partIsNumber = digit;
            }
        }
        if (part.length() > 0) parts.add(part.toString());
        return parts;
    }

    private static boolean isNumber(String part) {
        return Character.isDigit(part.charAt(0));
    }

    /** Without parsing, so a number of any length cannot overflow. */
    private static int compareNumbers(String first, String second) {
        String firstTrimmed = first.replaceFirst("^0+(?=\\d)", "");
        String secondTrimmed = second.replaceFirst("^0+(?=\\d)", "");
        if (firstTrimmed.length() != secondTrimmed.length()) return Integer.compare(firstTrimmed.length(), secondTrimmed.length());
        return firstTrimmed.compareTo(secondTrimmed);
    }
}
