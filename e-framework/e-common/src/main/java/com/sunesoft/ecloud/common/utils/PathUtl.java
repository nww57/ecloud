package com.sunesoft.ecloud.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PathUtl {
    public PathUtl() {
    }

    public static String removeBeginBackSlant(String path) {
        return path == null ? "" : path.replaceFirst("^/*", "").trim();
    }

    public static String getPath(String path) {
        return path.replace(getName(path), "");
    }

    public static String getsuffix(String path) {
        return getSuffix(getName(path));
    }

    private static String getName(String path) {
        if (path == null) {
            return "";
        } else {
            String ret = "";
            String regex = "[^/\\\\]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(path);
            if (matcher.find()) {
                ret = matcher.group(0);
            }

            return ret.trim();
        }
    }

    private static String getSuffix(String urlName) {
        if (urlName == null) {
            return "";
        } else {
            String ret = "";
            String regex = "\\.([^\\.]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(urlName);
            if (matcher.find()) {
                ret = matcher.group(1);
            }

            return ret.trim();
        }
    }

    public static String getUrlName(String path) {
        if (path == null) {
            return "";
        } else {
            String ret = "";
            String regex = "[^/]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(path);
            if (matcher.find()) {
                ret = matcher.group(0);
            }

            return ret.trim();
        }
    }

    public static String getUrlSuffix(String urlName) {
        if (urlName == null) {
            return "";
        } else {
            String ret = "";
            String regex = "\\.([^\\.]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(urlName);
            if (matcher.find()) {
                ret = matcher.group(1);
            }

            return ret.trim();
        }
    }

    public static String getNoSuffix(String path) {
        if (path == null) {
            return "";
        } else {
            String ret = path;
            if (path.lastIndexOf(".") != -1 && (path.lastIndexOf("/") == -1 || path.lastIndexOf("/") != -1 && path.lastIndexOf("/") < path.lastIndexOf("."))) {
                ret = path.substring(0, path.lastIndexOf("."));
            }

            return ret.trim();
        }
    }
}