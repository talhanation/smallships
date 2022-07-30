package com.talhanation.smallships.entities;

public class PassengerPos {

    float posX;
    float posY;
    float posZ;

    public PassengerPos(float posX, float posY, float posZ) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    public PassengerPos(float posX, float posZ) {
        this(posX, 0F, posZ);
    }

    public float getX() {
        return posX;
    }

    public float getY() {
        return posY;
    }

    public float getZ() {
        return posZ;
    }
}
