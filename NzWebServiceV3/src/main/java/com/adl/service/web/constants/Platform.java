package com.adl.service.web.constants;

import androidx.annotation.Nullable;

public final class Platform {
    private static final String PLATFORM_K12 = "k12";
    private static final String PLATFORM_GX = "gx";
    private static final String PLATFORM_V3 = "v3";

    public static final Platform K12 = new Platform();
    public static final Platform GX = new Platform();
    public static final Platform V3 = new Platform();

    private Platform() {}

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Platform)) {
            throw new IllegalArgumentException("Invalid argument equals : " + obj);
        }
        return super.equals(obj);
    }

    public static String toString(Platform platform) throws IllegalArgumentException {
        if (platform == K12) {
            return PLATFORM_K12;
        } else if (platform == GX) {
            return PLATFORM_GX;
        } else if (platform == V3) {
            return PLATFORM_V3;
        } else {
            throw new IllegalArgumentException("Invalid platform toString : " + platform);
        }
    }

    public static Platform fromString(String platform) {
        if (PLATFORM_K12.equalsIgnoreCase(platform)) {
            return K12;
        } else if (PLATFORM_GX.equalsIgnoreCase(platform)) {
            return GX;
        } else if (PLATFORM_V3.equalsIgnoreCase(platform)) {
            return V3;
        } else {
            throw new IllegalArgumentException("Invalid platform fromString : " + platform);
        }
    }


}
