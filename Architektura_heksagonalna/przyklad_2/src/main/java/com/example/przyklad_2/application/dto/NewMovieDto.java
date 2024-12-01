package com.example.przyklad_2.application.dto;

import java.time.LocalDate;

public record NewMovieDto(
        String title,
        String description,
        LocalDate releaseDate,
        String director
) {
}
