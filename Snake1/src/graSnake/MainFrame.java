package graSnake;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");

        //Do ramki nalezy doda� panel:
        add(new MainPanel());

        //metoda pack() dostosowuje odpowiedni� minimaln� wielko�� ramki �eby si� wszystko pomie�ci�o
        pack();

        //�eby ramka nie otwiera�a si� w lewym g�rnym rogu ekranu, tylko na �rodku nale�y wstawi� metod� setLocationRelativeTo() i w nawiasie ustawi� warto�� na "null":
        setLocationRelativeTo(null);

        //zablokowanie mo�liwo�ci zmiany wielko�ci ramki przez u�ytkownika
        setResizable(false);

    }
}
