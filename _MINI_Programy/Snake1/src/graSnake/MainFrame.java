package graSnake;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static JLabel score;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake");

        //stworzenie etykiety, kt�ra si� wy�wietli po zako�czeniu gry. SwingConstants.CENTER ustawia napis na �rodku
        score = new JLabel("Score: ", SwingConstants.CENTER);

        //zmiana czcionki:
        score.setFont(new Font(score.getFont().getName(), Font.BOLD, 30));

        //dodanie etykiety do ramki ORAZ zlokalizowanie jej 'na p�noc' czyli w g�rnej cz�� ramki:
        add(score,BorderLayout.NORTH);

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
