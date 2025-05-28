package com.example.planner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MapPlanner {
    private final FoeMap map;

    public MapPlanner(FoeMap map) {
        this.map = map;
    }

    public void addAll(List<Building> buildings) {
        List<List<Building>> permutations = getPermutations(buildings);
        int[][] bestMap = null;
        int minSum = Integer.MAX_VALUE;

        // Iterujemy po permutacjach budynków
        for (List<Building> permuted : permutations) {
            FoeMap tempMap = new FoeMap(deepCopy(map.fields)); // Kopiujemy mapę bazową
            boolean allBuildingsPlaced = true; // Flaga do sprawdzania, czy wszystkie budynki zostały poprawnie umieszczone

            // Iterujemy przez permutowane budynki
            for (int i = 0; i < permuted.size(); i++) {
                Building b = permuted.get(i);
                boolean isFirst = (i == 0); // Pierwszy budynek to zawsze ratusz

                // Próbujemy umieścić budynek w mapie
                if (!tryPlaceBuilding(tempMap, b, isFirst)) {
                    allBuildingsPlaced = false; // Jeśli nie udało się umieścić budynku, ustawiamy flagę na false
                    break; // Jeśli jakikolwiek budynek nie może zostać umieszczony, kończymy próbę
                }

                // Jeśli budynek ma być drogą, sprawdzamy, czy w pobliżu już jest droga
                if (b.isRoad()) {
                    // W przypadku drogi sprawdzamy, czy wokół budynku już jest droga
                    boolean hasRoad = false;
                    for (int y = 0; y <= tempMap.fields.length - b.getHeight(); y++) {
                        for (int x = 0; x <= tempMap.fields[0].length - b.getWidth(); x++) {
                            if (canPlaceBuilding(b, x, y)) {
                                // Sprawdzamy, czy w okolicy budynku jest droga
                                if (hasAdjacentRoad(tempMap, x, y, b)) {
                                    hasRoad = true;
                                    break;
                                }
                            }
                        }
                        if (hasRoad) break;
                    }

                    // Jeśli nie ma drogi w pobliżu, dodajemy ją
                    if (!hasRoad) {
                        addRoadNearBuilding(tempMap, b);
                    }
                }
            }

            // Jeśli wszystkie budynki zostały umieszczone poprawnie, liczymy sumę mapy
            if (allBuildingsPlaced) {
                int currentSum = tempMap.sumPoints();
                if (currentSum < minSum) {
                    minSum = currentSum;
                    bestMap = deepCopy(tempMap.fields); // Zapamiętujemy najlepszą mapę
                }
            }
        }

        // Jeśli znaleźliśmy najlepszą mapę, nadpisujemy ją w oryginalnej mapie
        if (bestMap != null) {
            for (int i = 0; i < map.fields.length; i++) {
                System.arraycopy(bestMap[i], 0, map.fields[i], 0, bestMap[i].length);
            }
        }
    }




    public boolean tryPlaceBuilding(FoeMap tempMap, Building building, boolean allowNewRoad) {
        int rows = tempMap.fields.length;
        int cols = tempMap.fields[0].length;

        for (int y = 0; y <= rows - building.getHeight(); y++) {
            for (int x = 0; x <= cols - building.getWidth(); x++) {
                if (canPlaceBuilding(tempMap, x, y, building)) {
                    // Tworzymy kopię mapy przed wstawieniem budynku
                    FoeMap backup = new FoeMap(deepCopy(tempMap.fields));
                    placeBuilding(tempMap, x, y, building); // Wstawiamy budynek

                    // Jeśli budynek ma drogę, sprawdzamy, czy nie potrzeba jej dodać
                    if (building.isRoad()) {
                        if (!hasAdjacentRoad(tempMap, x, y, building)) {
                            if (allowNewRoad) {
                                addRoadNearBuilding(tempMap, x, y, building); // Dodajemy drogę
                            } else {
                                restoreFrom(backup, tempMap);  // Cofamy zmiany, jeśli nie można dodać drogi
                                continue;
                            }
                        }
                    }
                    return true;  // Budynek został pomyślnie wstawiony
                }
            }
        }
        return false;
    }


    private boolean canPlaceBuilding(FoeMap tempMap, int x, int y, Building building) {
        int width = building.getWidth();
        int height = building.getHeight();

        // Sprawdzamy, czy można wstawić budynek
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tempMap.fields[y + i][x + j] != 1) {  // Jeśli pole nie jest puste
                    return false;
                }
            }
        }
        return true;
    }

    private void placeBuilding(FoeMap tempMap, int x, int y, Building building) {
        int width = building.getWidth();
        int height = building.getHeight();

        // Wstawiamy budynek na mapę
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tempMap.fields[y + i][x + j] = 2;  // Wartość '2' oznacza budynek
            }
        }
    }

    public boolean hasAdjacentRoad(FoeMap tempMap, int startX, int startY, Building building) {
        int rows = tempMap.fields.length;
        int cols = tempMap.fields[0].length;
        for (int y = startY; y < startY + building.getHeight(); y++) {
            for (int x = startX; x < startX + building.getWidth(); x++) {
                // Sprawdzamy pola sąsiednie wokół budynku
                if (y > 0 && tempMap.fields[y - 1][x] == 3) return true; // Sprawdzenie powyżej
                if (y < rows - 1 && tempMap.fields[y + 1][x] == 3) return true; // Sprawdzenie poniżej
                if (x > 0 && tempMap.fields[y][x - 1] == 3) return true; // Sprawdzenie z lewej
                if (x < cols - 1 && tempMap.fields[y][x + 1] == 3) return true; // Sprawdzenie z prawej
            }
        }
        return false;
    }

    private void addRoadNearBuilding(FoeMap tempMap, int x, int y, Building building) {
        int width = building.getWidth();
        int height = building.getHeight();

        // Dodajemy drogę wokół budynku (wokół krawędzi)
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    if (tempMap.fields[y + i][x + j] == 1) {
                        tempMap.fields[y + i][x + j] = 3;  // Zmieniamy na drogę
                    }
                }
            }
        }
    }

    private void restoreFrom(FoeMap backup, FoeMap tempMap) {
        for (int i = 0; i < tempMap.fields.length; i++) {
            System.arraycopy(backup.fields[i], 0, tempMap.fields[i], 0, backup.fields[i].length);
        }
    }

    // Permutacje budynków
    public List<List<Building>> getPermutations(List<Building> buildings) {
        List<List<Building>> result = new ArrayList<>();
        permute(buildings, 0, result);
        return result;
    }

    private void permute(List<Building> list, int start, List<List<Building>> result) {
        if (start == list.size()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, i, start);
            permute(list, start + 1, result);
            Collections.swap(list, i, start);
        }
    }

    // Kopiowanie mapy
    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }















//    public void addAll(List<Building> buildings) {
//        List<List<Building>> permutations = getPermutations(buildings);  // Uzyskujemy permutacje budynków
//        int[][] bestMap = null;
//        int minSum = Integer.MAX_VALUE;
//
//        // Iteracja po każdej permutacji
//        for (List<Building> permuted : permutations) {
//            FoeMap tempMap = new FoeMap(deepCopy(map.fields));  // Kopiujemy mapę
//
//            // Dodajemy budynki jeden po drugim
//            for (int i = 0; i < permuted.size(); i++) {
//                Building building = permuted.get(i);
//                boolean isFirst = (i == 0);  // Pierwszy budynek to np. ratusz
//                tryPlaceBuilding(tempMap, building, isFirst);
//            }
//
//            int currentSum = tempMap.sumPoints(); // Liczymy sumę punktów mapy
//            if (currentSum < minSum) {
//                minSum = currentSum;
//                bestMap = deepCopy(tempMap.fields);  // Zapisujemy najlepszą mapę
//            }
//        }
//
//        // Nadpisujemy mapę najlepszym układem
//        if (bestMap != null) {
//            for (int i = 0; i < map.fields.length; i++) {
//                System.arraycopy(bestMap[i], 0, map.fields[i], 0, bestMap[i].length);
//            }
//        }
//    }




    //    public void addAll(List<Building> buildings) {
//        List<List<Building>> permutations = getPermutations(buildings);
//        int[][] bestMap = null;
//        int minSum = Integer.MAX_VALUE;
//
//        for (List<Building> permuted : permutations) {
//            FoeMap tempMap = new FoeMap(deepCopy(map.fields)); // <- kopiujemy mapę bazową
//
//            for (int i = 0; i < permuted.size(); i++) {
//                Building b = permuted.get(i);
//                boolean isFirst = (i == 0);
//
//                // ważne: działamy na tempMap
//                tempMap.tryPlaceBuilding(b, isFirst);
//            }
//
//            int currentSum = tempMap.sumPoints();
//            if (currentSum < minSum) {
//                minSum = currentSum;
//                bestMap = deepCopy(tempMap.fields); // <- kopiujemy najlepszą wersję
//            }
//        }
//
//        // Jeśli znaleźliśmy najlepszą mapę, nadpisujemy oryginalną
//        if (bestMap != null) {
//            for (int i = 0; i < map.fields.length; i++) {
//                System.arraycopy(bestMap[i], 0, map.fields[i], 0, bestMap[i].length);
//            }
//        }
//    }
//    private void tryPlaceBuilding(FoeMap tempMap, Building building, boolean allowNewRoad) {
//        int rows = tempMap.fields.length;
//        int cols = tempMap.fields[0].length;
//
//        // Przechodzimy po całej mapie i próbujemy umieścić budynek
//        for (int y = 0; y <= rows - building.getHeight(); y++) {
//            for (int x = 0; x <= cols - building.getWidth(); x++) {
//                if (canPlaceBuilding(tempMap, x, y, building)) {
//                    FoeMap backup = new FoeMap(deepCopy(tempMap.fields)); // Zapisujemy mapę przed wstawieniem budynku
//                    placeBuilding(tempMap, x, y, building); // Wstawiamy budynek
//
//                    if (building.isRoad()) {  // Jeśli budynek ma drogę
//                        if (!hasAdjacentRoad(tempMap, x, y, building)) {
//                            if (allowNewRoad) {
//                                addRoadNearBuilding(tempMap, x, y, building); // Dodajemy drogę, jeśli to konieczne
//                            } else {
//                                restoreFrom(backup, tempMap);  // Cofamy zmiany, jeśli nie można dodać drogi
//                                continue;
//                            }
//                        }
//                    }
//                    return; // Jeśli budynek został wstawiony, wychodzimy
//                }
//            }
//        }
//    }

//
//    public void tryPlaceBuilding(Building building, boolean allowNewRoad) {
//        int rows = map.fields.length;
//        int cols = map.fields[0].length;
//
//        for (int y = 0; y <= rows - building.getHeight(); y++) {
//            for (int x = 0; x <= cols - building.getWidth(); x++) {
//                if (canPlaceBuilding(x, y, building)) {
//                    FoeMap backup = new FoeMap(deepCopy(map.fields));
//                    placeBuilding(x, y, building);
//
//                    if (building.isRoad()) {
//                        if (!hasAdjacentRoad(x, y, building)) {
//                            if (allowNewRoad) {
//                                addRoadNearBuilding(x, y, building);
//                            } else {
//                                restoreFrom(backup);
//                                continue;
//                            }
//                        }
//                    }
//                    return;
//                }
//            }
//        }
//    }


//    private boolean canPlaceBuilding(FoeMap tempMap, int x, int y, Building building) {
//        int width = building.getWidth();
//        int height = building.getHeight();
//
//        // Sprawdzamy, czy można wstawić budynek
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (tempMap.fields[y + i][x + j] != 1) {  // Jeśli pole nie jest puste
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    private void placeBuilding(FoeMap tempMap, int x, int y, Building building) {
//        int width = building.getWidth();
//        int height = building.getHeight();
//
//        // Wstawiamy budynek na mapę
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                tempMap.fields[y + i][x + j] = 2;  // Wartość '2' oznacza budynek
//            }
//        }
//    }

//    private boolean hasAdjacentRoad(FoeMap tempMap, int x, int y, Building building) {
//        int width = building.getWidth();
//        int height = building.getHeight();
//
//        // Sprawdzamy, czy w okolicy budynku znajduje się droga
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
//                    if (tempMap.fields[y + i][x + j] == 3) {  // Wartość '3' to droga
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }

//    private void addRoadNearBuilding(FoeMap tempMap, int x, int y, Building building) {
//        int width = building.getWidth();
//        int height = building.getHeight();
//
//        // Szukamy pierwszego wolnego miejsca (1) i zamieniamy je na drogę (3)
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (tempMap.fields[y + i][x + j] == 1) {
//                    tempMap.fields[y + i][x + j] = 3;
//                    return;
//                }
//            }
//        }
//    }

//    private void restoreFrom(FoeMap backup, FoeMap tempMap) {
//        for (int i = 0; i < tempMap.fields.length; i++) {
//            System.arraycopy(backup.fields[i], 0, tempMap.fields[i], 0, backup.fields[i].length);
//        }
//    }




//    private boolean canPlaceBuilding(int startX, int startY, Building b) {
//        for (int y = 0; y < b.getHeight(); y++) {
//            for (int x = 0; x < b.getWidth(); x++) {
//                if (map.fields[startY + y][startX + x] != 1) return false;
//            }
//        }
//        return true;
//    }
//
//    private void placeBuilding(int startX, int startY, Building b) {
//        int code = getNextBuildingCode();
//        for (int y = 0; y < b.getHeight(); y++) {
//            for (int x = 0; x < b.getWidth(); x++) {
//                map.fields[startY + y][startX + x] = code;
//            }
//        }
//    }
//
//    private boolean hasAdjacentRoad(int startX, int startY, Building b) {
//        for (int y = startY - 1; y <= startY + b.getHeight(); y++) {
//            for (int x = startX - 1; x <= startX + b.getWidth(); x++) {
//                if (y >= 0 && y < map.fields.length && x >= 0 && x < map.fields[0].length) {
//                    if (map.fields[y][x] == 3) return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private void addRoadNearBuilding(int startX, int startY, Building b) {
//        for (int y = startY - 1; y <= startY + b.getHeight(); y++) {
//            for (int x = startX - 1; x <= startX + b.getWidth(); x++) {
//                if (y >= 0 && y < map.fields.length && x >= 0 && x < map.fields[0].length) {
//                    if (map.fields[y][x] == 1) {
//                        map.fields[y][x] = 3;
//                        return;
//                    }
//                }
//            }
//        }
//    }
//
//    private void restoreFrom(FoeMap backup) {
//        for (int i = 0; i < map.fields.length; i++) {
//            System.arraycopy(backup.fields[i], 0, map.fields[i], 0, map.fields[i].length);
//        }
//    }

//    private int getNextBuildingCode() {
//        int max = 3;
//        for (int[] row : map.fields) {
//            for (int val : row) {
//                if (val > max) max = val;
//            }
//        }
//        return max + 1;
//    }

//    public List<List<Building>> getPermutations(List<Building> buildings) {
//        List<List<Building>> result = new ArrayList<>();
//        permute(buildings, 0, result);
//        return result;
//    }

//    private void permute(List<Building> list, int start, List<List<Building>> result) {
//        if (start == list.size()) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i < list.size(); i++) {
//            Collections.swap(list, i, start);
//            permute(list, start + 1, result);
//            Collections.swap(list, i, start);
//        }
//    }

    // Kopiowanie mapy
//    public static int[][] deepCopy(int[][] original) {
//        int[][] copy = new int[original.length][];
//        for (int i = 0; i < original.length; i++) {
//            copy[i] = Arrays.copyOf(original[i], original[i].length);
//        }
//        return copy;
//    }

//    private int[][] deepCopy(int[][] original) {
//        return Arrays.stream(original)
//                .map(int[]::clone)
//                .toArray(int[][]::new);
//    }
//
//    private List<List<Building>> getPermutations(List<Building> buildings) {
//        List<List<Building>> result = new ArrayList<>();
//        permute(buildings, 0, result);
//        return result;
//    }
//
//    private void permute(List<Building> list, int start, List<List<Building>> result) {
//        if (start == list.size()) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i < list.size(); i++) {
//            Collections.swap(list, i, start);
//            permute(list, start + 1, result);
//            Collections.swap(list, i, start);
//        }
//    }


















//    public void addAll(List<Building> buildings) {
//        List<List<Building>> permutations = getPermutations(buildings);
//        int[][] bestMap = null;
//        int bestSum = Integer.MAX_VALUE;
//
//        for (List<Building> permutation : permutations) {
//            int[][] mapCopy = deepCopy(map.fields);
//            if (tryPlacingAll(mapCopy, permutation)) {
//                int sum = sumPoints(mapCopy);
//                if (sum < bestSum) {
//                    bestSum = sum;
//                    bestMap = mapCopy;
//                }
//            }
//        }
//
//        if (bestMap != null) {
//            map.fields = bestMap;
//        }
//    }
//
//    private boolean tryPlacingAll(int[][] map, List<Building> buildings) {
//        for (Building b : buildings) {
//            if (!tryPlaceBuildingAnywhere(map, b)) return false;
//        }
//        return true;
//    }
//
//    private boolean tryPlaceBuildingAnywhere(int[][] map, Building building) {
//        for (int x = 0; x <= map.length - building.getHeight(); x++) {
//            for (int y = 0; y <= map[0].length - building.getWidth(); y++) {
//                if (canPlace(map, building, x, y)) {
//                    place(map, building, x, y);
//
//                    if (building.isRoad() && !hasAdjacentRoad(map, x, y, building)) {
//                        if (!addAdjacentRoad(map, x, y, building)) return false;
//                    }
//
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean canPlace(int[][] map, Building b, int x, int y) {
//        for (int i = 0; i < b.getHeight(); i++) {
//            for (int j = 0; j < b.getWidth(); j++) {
//                if (map[x + i][y + j] != 1) return false;
//            }
//        }
//        return true;
//    }
//
//    private void place(int[][] map, Building b, int x, int y) {
//        for (int i = 0; i < b.getHeight(); i++) {
//            for (int j = 0; j < b.getWidth(); j++) {
//                map[x + i][y + j] = 2; // budynek
//            }
//        }
//    }
//
//    private boolean hasAdjacentRoad(int[][] map, int x, int y, Building b) {
//        for (int i = -1; i <= b.getHeight(); i++) {
//            for (int j = -1; j <= b.getWidth(); j++) {
//                int nx = x + i;
//                int ny = y + j;
//                if (i >= 0 && i < b.getHeight() && j >= 0 && j < b.getWidth()) continue;
//                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
//                    if (map[nx][ny] == 3) return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean addAdjacentRoad(int[][] map, int x, int y, Building b) {
//        for (int i = -1; i <= b.getHeight(); i++) {
//            for (int j = -1; j <= b.getWidth(); j++) {
//                int nx = x + i;
//                int ny = y + j;
//                if (i >= 0 && i < b.getHeight() && j >= 0 && j < b.getWidth()) continue;
//                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
//                    if (map[nx][ny] == 1) {
//                        map[nx][ny] = 3; // droga
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public int sumPoints(int[][] map) {
//        return Arrays.stream(map)
//                .flatMapToInt(Arrays::stream)
//                .sum();
//    }
//
//    private int[][] deepCopy(int[][] original) {
//        return Arrays.stream(original)
//                .map(int[]::clone)
//                .toArray(int[][]::new);
//    }
//
//    private List<List<Building>> getPermutations(List<Building> buildings) {
//        List<List<Building>> result = new ArrayList<>();
//        permute(buildings, 0, result);
//        return result;
//    }
//
//    private void permute(List<Building> list, int start, List<List<Building>> result) {
//        if (start == list.size()) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = start; i < list.size(); i++) {
//            Collections.swap(list, i, start);
//            permute(list, start + 1, result);
//            Collections.swap(list, i, start);
//        }
//    }























    // Metoda do dodawania budynku
    public boolean add(Building building) {
        int bestX = -1;
        int bestY = -1;
        int minSum = Integer.MAX_VALUE;

        // Iterujemy po całej mapie, próbując umieścić budynek
        for (int i = 0; i < map.fields.length - building.getWidth() + 1; i++) {
            for (int j = 0; j < map.fields[0].length - building.getHeight() + 1; j++) {
                // Sprawdzamy, czy możemy umieścić budynek w tej pozycji
                if (canPlaceBuilding(building, i, j)) {
                    // Obliczamy sumę punktów na mapie po postawieniu budynku
                    int currentSum = calculateMapSum(i, j, building.getWidth(), building.getHeight());

                    // Jeśli suma punktów jest mniejsza niż obecnie najmniejsza, zapisujemy nową lokalizację
                    if (currentSum < minSum) {
                        minSum = currentSum;
                        bestX = i;
                        bestY = j;
                    }
                }
            }
        }

        // Jeśli znaleziono odpowiednie miejsce, wstawiamy budynek
        if (bestX != -1 && bestY != -1) {
            placeBuilding(building, bestX, bestY);

            // Jeśli budynek wymaga drogi, dodajemy drogę wokół
            if (building.isRoad()) {
                addRoadAroundBuilding(bestX, bestY, building.getWidth(), building.getHeight());
            }
            return true;
        }

        return false; // Nie znaleziono miejsca
    }

    // Sprawdza, czy można postawić budynek w danym miejscu
    private boolean canPlaceBuilding(Building building, int startX, int startY) {
        for (int i = 0; i < building.getWidth(); i++) {
            for (int j = 0; j < building.getHeight(); j++) {
                if (map.fields[startX + i][startY + j] != 1) {
                    return false; // Znaleziono miejsce, które nie jest wolne
                }
            }
        }
        return true;
    }

    // Oblicza sumę punktów dla danego obszaru mapy, gdzie ma być postawiony budynek
    private int calculateMapSum(int startX, int startY, int width, int height) {
        int sum = 0;
        for (int i = startX; i < startX + width; i++) {
            for (int j = startY; j < startY + height; j++) {
                sum += map.fields[i][j];
            }
        }
        return sum;
    }

    // Umieszczamy budynek na mapie
    private void placeBuilding(Building building, int startX, int startY) {
        for (int i = 0; i < building.getWidth(); i++) {
            for (int j = 0; j < building.getHeight(); j++) {
                map.fields[startX + i][startY + j] = 2; // Symbolizuje budynek
            }
        }
    }

    // Dodaje drogę wokół budynku, jeśli budynek wymaga drogi
    private void addRoadAroundBuilding(int startX, int startY, int width, int height) {
        for (int i = startX - 1; i <= startX + width; i++) {
            for (int j = startY - 1; j <= startY + height; j++) {
                if (i >= 0 && i < map.fields.length && j >= 0 && j < map.fields[0].length && map.fields[i][j] == 1) {
                    map.fields[i][j] = 3; // Droga
                    return; // Dodajemy tylko jedną drogę
                }
            }
        }
    }
}
