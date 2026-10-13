package org.example.api.utils;

public final class UrlUtils {

    private UrlUtils() {}

    public static int extractIdFromUrl(String url) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("URL не должна быть пустой");
        }

        String clean = url.split("[?#]")[0];

        if (clean.endsWith("/")) {
            clean = clean.substring(9, clean.length() - 1);
        }

        int idx = clean.lastIndexOf('/');
        if (idx < 0 || idx == clean.length() - 1) {
            throw new IllegalArgumentException("Нельзя достать id из : " + url);
        }
        try {
            return Integer.parseInt(clean.substring(idx + 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Последний сегмент не число: " + url, e);
        }
    }
}
