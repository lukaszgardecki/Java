package GraWzycie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CellService {
    private List<Cell> cells = new ArrayList<>();

    private static final CellService INSTANCE = new CellService();

    public static CellService getInstance() {
        return INSTANCE;
    }

    public CellService() {
        for (int i = 0; i < Config.ROWS; i++) {
            for (int j = 0; j < Config.COLS; j++) {
                cells.add(new Cell(j, i));
            }
        }
        try {
            populate();
        } catch (IOException e) {
            System.out.println("Problem with reading from file");
        }

    }

    private void populate() throws IOException {
        String filename = "dart.cell";

        int y = 85;
        for (String line : Files.readAllLines(Paths.get(filename))) {
            for (int x = 0; x < line.length(); x++) {
                if (line.charAt(x) == 'O') {
                    getByCords(x, y).setLife(true);

                }
            }
            y++;
        }

    }

    public Cell getByCords(int x, int y) {
         return cells.stream().filter(cell -> cell.getX() == x && cell.getY() == y).findFirst().orElse(null);
    }

    public List<Cell> getAllCells() {
        return cells;
    }

    public void update() {
        List<Cell> newCells = new ArrayList<>();
        List<Cell> deathCells = new ArrayList<>();

        for (Cell cell : cells) {
            //liczba ¿ywych s¹siadów dla ka¿dej komórki:
            long lifeNeighbors = cells.stream()
                    .filter(cell::isNeighbor)
                    .filter(Cell::isLife)
                    .count();

            //je¿eli komórka jest ¿ywa to zrób to:
            if (cell.isLife()) {
                if (lifeNeighbors < 2 || lifeNeighbors > 3) {
                    deathCells.add(cell);
                }
                //w przeciwnym razie wykonaj to:
            } else {
                if (lifeNeighbors == 3) {
                    newCells.add(cell);
                }
            }

        }

        for (Cell cell : deathCells) {
            cell.setLife(false);
        }

        for (Cell cell : newCells) {
            cell.setLife(true);

        }
    }
}
