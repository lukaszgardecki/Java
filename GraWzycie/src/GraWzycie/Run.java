package GraWzycie;

import javax.swing.*;
import java.awt.*;

public class Run {
    public static void main(String[] args) {
        //w¹tek instrybucji zdarzeñ
        EventQueue.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);

            MainTimer mainTimer = new MainTimer();
            mainTimer.start();
        });









    }
}
