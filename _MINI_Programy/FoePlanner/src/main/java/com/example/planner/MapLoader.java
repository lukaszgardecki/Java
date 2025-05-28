package com.example.planner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

class MapLoader {

    FoeMap load(File file) {
        int[][] map;
        try (Stream<String> lines = Files.lines(file.toPath())) {
            map = lines
                    .map(line -> line.chars()
                            .map(Character::getNumericValue)
                            .toArray())
                    .toArray(int[][]::new);
        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas wczytywania mapy", e);
        }
        return new FoeMap(map);
    }
}
