package org.bot.reminder;

public abstract class RegexpHelper {
    public static boolean checkStartWithSlash(String message) {
        return false;
    }

    public static boolean checkEndWithSlash(String message) {
        return false;
    }

    public static String replacePrefixSlash(String message) {
        return null;
    }

    public static String replacePostFixSlash(String message) {
        return null;
    }

    public static String trimMessage(String message) {
        return message.trim();
    }
}
