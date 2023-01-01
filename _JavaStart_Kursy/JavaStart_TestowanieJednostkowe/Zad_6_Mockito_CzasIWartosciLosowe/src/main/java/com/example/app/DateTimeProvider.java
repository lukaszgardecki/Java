package com.example.app;

import java.time.ZonedDateTime;

public class DateTimeProvider {
    public ZonedDateTime currentZonedDateTime() {
        return ZonedDateTime.now();
    }
}
