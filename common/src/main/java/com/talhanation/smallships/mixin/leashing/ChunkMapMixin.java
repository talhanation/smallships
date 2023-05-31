package com.talhanation.smallships.mixin.leashing;

import com.talhanation.smallships.duck.BoatLeashAccess;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.chunk.LevelChunk;
import org.apache.commons.lang3.mutable.MutableObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.List;

@Mixin(ChunkMap.class)
public class ChunkMapMixin {
    private List<Entity> list;
    private ServerPlayer serverPlayer;

    @Inject(method = "playerLoadedChunk", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/Lists;newArrayList()Ljava/util/ArrayList;", ordinal = 1), locals = LocalCapture.CAPTURE_FAILHARD)
    private void playerLoadedChunkLeashShipCaptureListAndPlayer(ServerPlayer serverPlayer, MutableObject<ClientboundLevelChunkWithLightPacket> mutableObject, LevelChunk levelChunk, CallbackInfo ci, List<Entity> list) {
        this.list = list;
        this.serverPlayer = serverPlayer;
    }

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @ModifyConstant(method = "playerLoadedChunk", constant = @Constant(classValue = Mob.class, ordinal = 0))
    private Class<?> playerLoadedChunkLeashShipAddBoatsToList(Object object, Class<Mob> constant) {
        if (object instanceof BoatLeashAccess boat && boat.getLeashHolder() != null) {
            this.list.add((Entity)object);
        }
        return constant;
    }

    private Entity peekedEntity = null;

    @Redirect(method = "playerLoadedChunk", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;hasNext()Z", ordinal = 1))
    private boolean playerLoadedChunkLeashShipSendLinkPacket(Iterator<Entity> instance) {
        while(instance.hasNext()) {
            if (this.peekedEntity == null) {
                this.peekedEntity = instance.next();
            }
            if (this.peekedEntity instanceof BoatLeashAccess boat) {
                this.serverPlayer.connection.send(new ClientboundSetEntityLinkPacket(this.peekedEntity, boat.getLeashHolder()));
                this.peekedEntity = null;
            } else {
                return instance.hasNext() || this.peekedEntity != null;
            }
        }
        return false;
    }

    @Redirect(method = "playerLoadedChunk", at = @At(value = "INVOKE", target = "Ljava/util/Iterator;next()Ljava/lang/Object;", ordinal = 1))
    private Object playerLoadedChunkLeashShipIteratorPeekImpl(Iterator<Entity> instance) {
        if (this.peekedEntity != null) {
            Entity next = this.peekedEntity;
            this.peekedEntity = null;
            return next;
        } else {
            return instance.next();
        }
    }
}
