package org.example.api.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateUtils {
    private DateUtils() {}

    private static final DateTimeFormatter SWAPI_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(ZoneId.of("UTC"));

    public static String format(Instant instant) {
        return instant == null ? null : SWAPI_FORMAT.format(instant);
    }
}
