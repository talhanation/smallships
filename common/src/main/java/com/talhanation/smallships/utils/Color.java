package com.talhanation.smallships.utils;

import org.apache.commons.lang3.StringUtils;
import org.joml.Math;
import org.joml.Vector3f;

import java.util.Objects;

/**
 * @author Chryfi
 */
public class Color {
    private float r;
    private float g;
    private float b;
    private float a = 1;

    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(float r, float g, float b, float a) {
        this(r, g, b);

        this.a = a;
    }

    public Color(int color) {
        this(color, true);
    }

    public Color(int color, boolean alpha) {
        this.set(color, alpha);
    }

    public Color set(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        return this;
    }

    public float getR() {
        return this.r;
    }

    public float getB() {
        return this.b;
    }

    public float getG() {
        return this.g;
    }

    public float getA() {
        return this.a;
    }

    public Vector3f getAsVector3f() {
        return new Vector3f(this.r, this.g, this.b);
    }

    public Color set(float value, int component) {
        switch (component) {
            case 1:
                this.r = value;
                break;

            case 2:
                this.g = value;
                break;

            case 3:
                this.b = value;
                break;

            default:
                this.a = value;
                break;
        }

        return this;
    }

    public Color set(int color) {
        return this.set(color, true);
    }

    public Color set(int color, boolean alpha) {
        this.set((color >> 16 & 0xff) / 255F, (color >> 8 & 0xff) / 255F, (color & 0xff) / 255F, alpha ? (color >> 24 & 0xff) / 255F : 1F);

        return this;
    }

    public int getRGBAColor() {
        float r = Math.clamp(0, 1, this.r);
        float g = Math.clamp(0, 1, this.g);
        float b = Math.clamp(0, 1, this.b);
        float a = Math.clamp(0, 1, this.a);

        return ((int) (a * 255) << 24) | ((int) (r * 255) << 16) | ((int) (g * 255) << 8) | (int) (b * 255);
    }

    public int getRGBColor() {
        return this.getRGBAColor() & 0xffffff;
    }

    public String stringify() {
        return this.stringify(false);
    }

    public String stringify(boolean alpha) {
        if (alpha) {
            return "#" + StringUtils.leftPad(Integer.toHexString(this.getRGBAColor()), 8, '0');
        }

        return "#" + StringUtils.leftPad(Integer.toHexString(this.getRGBColor()), 6, '0');
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Color) {
            Color color = (Color) obj;

            return color.getRGBAColor() == this.getRGBAColor();
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.r, this.g, this.b, this.a);
    }
}
