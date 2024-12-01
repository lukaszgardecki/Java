package com.example.przyklad_2.domain;

import java.time.LocalDate;

public record Movie(
        Long id,
        String title,
        String description,
        LocalDate releaseDate,
        String director
) {
}
