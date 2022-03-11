package com.tmb.automation.util;

public class TextColor {
    public static String redColor(String text) {
        return "<font color=\"red\">" + text + "</font>";
    }

    public static String greenColor(String text) {
        return "<font color=\"Lime\">" + text + "</font>";
    }

    public static String resultColor(boolean isTrue, String text) {
        if (isTrue) {
            return "<font color=\"Lime\">" + text + "</font>";
        } else {
            return "<font color=\"red\">" + text + "</font>";
        }
    }

    public static String blueColor(String text) {
        return "<font color=\"aqua\">" + text + "</font>";
    }

}
