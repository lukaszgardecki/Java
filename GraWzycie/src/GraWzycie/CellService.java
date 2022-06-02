package GraWzycie;

import java.util.ArrayList;
import java.util.List;

public class CellService {
    private List<Cell> cells = new ArrayList<>();

    public CellService() {
        for (int i = 0; i < Config.ROWS; i++) {
            for (int j = 0; j < Config.COLS; j++) {
                cells.add(new Cell(j, i));
            }
        }

        getByCords(3,3).setLife(true);
        getByCords(3,4).setLife(true);
        getByCords(3,5).setLife(true);
    }

    public Cell getByCords(int x, int y) {
         return cells.stream().filter(cell -> cell.getX() == x && cell.getY() == y).findFirst().orElse(null);
    }

    public List<Cell> getAllCells() {
        return cells;
    }
}
