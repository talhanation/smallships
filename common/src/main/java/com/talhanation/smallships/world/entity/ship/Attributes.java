package com.talhanation.smallships.world.entity.ship;

import net.minecraft.nbt.CompoundTag;

public class Attributes {
    public float maxHealth;
    public float maxSpeed;
    public float maxReverseSpeed;
    public float maxRotationSpeed;
    public float acceleration;
    public float rotationAcceleration;
    public float friction;

    public void addSaveData(CompoundTag tag) {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putFloat("maxHealth", this.maxHealth);
        compoundtag.putFloat("maxSpeed", this.maxSpeed);
        compoundtag.putFloat("maxReverseSpeed", this.maxReverseSpeed);
        compoundtag.putFloat("acceleration", this.acceleration);
        compoundtag.putFloat("rotationAcceleration", this.rotationAcceleration);
        compoundtag.putFloat("maxRotationSpeed", this.maxRotationSpeed);
        compoundtag.putFloat("friction", this.friction);
        tag.put("Attributes", compoundtag);
    }

    public CompoundTag getSaveData() {
        CompoundTag compoundtag = new CompoundTag();
        this.addSaveData(compoundtag);
        return compoundtag;
    }

    public void loadSaveData(CompoundTag tag) {
        if (tag.contains("Attributes")) {
            CompoundTag compoundtag = tag.getCompound("Attributes").orElseThrow();
            this.maxHealth = compoundtag.getFloat("maxHealth").orElseThrow();
            this.maxSpeed = compoundtag.getFloat("maxSpeed").orElseThrow();
            this.maxReverseSpeed = compoundtag.getFloat("maxReverseSpeed").orElseThrow();
            this.acceleration = compoundtag.getFloat("acceleration").orElseThrow();
            this.rotationAcceleration = compoundtag.getFloat("rotationAcceleration").orElseThrow();
            this.maxRotationSpeed = compoundtag.getFloat("maxRotationSpeed").orElseThrow();
            this.friction = compoundtag.getFloat("friction").orElseThrow();
        }
    }

    public void loadSaveData(CompoundTag tag, Ship shipEntity) { // Workaround because defineSynchedData doesn't work properly (or as I would like it to work: Use the provided 2nd argument as a "default" variable)
        if (tag.contains("Attributes")) {
            this.loadSaveData(tag);
        } else {
            this.loadSaveData(shipEntity.createDefaultAttributes());
        }
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "maxHealth=" + maxHealth +
                ", maxSpeed=" + maxSpeed +
                ", maxReverseSpeed=" + maxReverseSpeed +
                ", acceleration=" + acceleration +
                ", maxRotationSpeed=" + maxRotationSpeed +
                ", friction=" + friction +
                '}';
    }
}
