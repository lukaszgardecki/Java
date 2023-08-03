package GraWzycie;

import javax.swing.*;

public class MainTimer {
    private final CellService cellService = CellService.getInstance();
    private final MainCanvas mainCanvas = MainCanvas.getInstance();

    private Timer timer;

    public MainTimer() {
        timer = new Timer(100, e -> {
            //od�wie� kom�rki
            cellService.update();

            //od�wie� mainCanvas
            mainCanvas.repaint();
        });
    }

    public void start() {
        timer.start();
    }
}
