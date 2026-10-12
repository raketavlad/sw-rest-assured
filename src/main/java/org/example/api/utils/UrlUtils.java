package org.example.api.utils;

public final class UrlUtils {

    private UrlUtils() {}

    public static int extractIdFromUrl(String url) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("URL не должна быть пустой");
        }
        int idx = url.lastIndexOf('/');
        if (idx < 0 || idx == url.length() - 1) {
            throw new IllegalArgumentException("Нельзя достать id из : " + url);
        }
        try {
            return Integer.parseInt(url.substring(idx + 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Last segment is not a number: " + url, e);
        }
    }
}
