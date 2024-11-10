package com.talhanation.smallships.utils;

import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;
import org.joml.Vector3f;

public class VectorMath {
    public static Vector3f castToVector3f(Vector3d v) {
        return new Vector3f((float) v.x,(float)  v.y,(float)  v.z);
    }

    public static Vec3 toVec3(Vector3d v) {
        return new Vec3(v.x, v.y, v.z);
    }

    public static Vec3 toVec3(Vector3f v) {
        return new Vec3(v.x, v.y, v.z);
    }

    public static Vector3d projectOntoPlane(Vector3d v, Vector3d normal) {
        Vector3d n = new Vector3d(normal).normalize();
        v = new Vector3d(v);
        double dotProduct = v.dot(n);
        v.sub(n.mul(dotProduct));
        return v;
    }

    public static Vector3f projectOntoPlane(Vector3f v, Vector3f normal) {
        Vector3f n = new Vector3f(normal).normalize();
        v = new Vector3f(v);
        float dotProduct = v.dot(n);
        v.sub(n.mul(dotProduct));
        return v;
    }
}
