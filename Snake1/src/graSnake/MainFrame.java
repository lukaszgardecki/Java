package graSnake;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");

        //Do ramki nalezy dodaæ panel:
        add(new MainPanel());

        //metoda pack() dostosowuje odpowiedni¹ minimaln¹ wielkoœæ ramki ¿eby siê wszystko pomieœci³o
        pack();

        //¿eby ramka nie otwiera³a siê w lewym górnym rogu ekranu, tylko na œrodku nale¿y wstawiæ metodê setLocationRelativeTo() i w nawiasie ustawiæ wartoœæ na "null":
        setLocationRelativeTo(null);

        //zablokowanie mo¿liwoœci zmiany wielkoœci ramki przez u¿ytkownika
        setResizable(false);

    }
}
