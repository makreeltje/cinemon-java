package com.cinemon.domain.utils;

public class APIUtils {
    private APIUtils() {

    }

    public enum SHOW_TYPES {
        MOVIE,
        TV,
    }

    public static final String TV_NOT_FOUND = "TV show not found";

    public static enum API_CODES {
        NOT_FOUND,
        DUPLICATE
    }

    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }
}
