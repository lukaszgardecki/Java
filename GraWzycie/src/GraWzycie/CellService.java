package GraWzycie;

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

        getByCords(3,3).setLife(true);
        getByCords(3,4).setLife(true);
        getByCords(3,5).setLife(true);

        getByCords(10,4).setLife(true);
        getByCords(11,4).setLife(true);
        getByCords(12,4).setLife(true);

        getByCords(10,10).setLife(true);
        getByCords(10,11).setLife(true);
        getByCords(11,10).setLife(true);
        getByCords(11,11).setLife(true);
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
