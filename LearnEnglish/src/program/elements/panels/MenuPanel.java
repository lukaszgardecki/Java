package program.elements.panels;

import program.elements.buttons.Button;
import program.elements.buttons.MenuButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    public static final int WIDTH = 150;
    public static final int HEIGHT = Content.HEIGHT;
    public static final int X = Content.WIDTH-WIDTH;
    public static final int Y = Content.Y;
    public static final int UP_GAP = 30;
    public static final int GAP_BETWEEN_BTNS = 10;
    public static final int BTN_X = (int) ((MenuPanel.WIDTH - MenuButton.WIDTH) * 0.5);
    MenuButton statBtn;
    MenuButton addRemoveBtn;

    public MenuPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        //setBounds(X,Y, WIDTH, 380);
        setBackground(null);
        //setBackground(Color.red);

        setLayout(null);

        // Button 1:
        statBtn = new MenuButton("STATYSTYKI");
        statBtn.setActionCommand("stats");
        statBtn.setLocation(BTN_X, UP_GAP);

        // Button 2:
        addRemoveBtn = new MenuButton("DODAJ/USUÑ");
        addRemoveBtn.setActionCommand("addRemove");
        addRemoveBtn.setLocation(BTN_X, UP_GAP+MenuButton.HEIGHT+GAP_BETWEEN_BTNS);
        //addRemoveBtn.setLocation(0, 0);

        add(statBtn);
        add(addRemoveBtn);

        //setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        if(a.equals("stats")) {
           if (statBtn.getText().equals("STATYSTKI")) {
               MainPanel.mainView.setVisible(false);
               MainPanel.statsView.setVisible(true);
               statBtn.setText("WRÓÆ");
           } else if (statBtn.getText().equals("WRÓÆ")) {
               MainPanel.statsView.setVisible(false);
               MainPanel.mainView.setVisible(true);
               statBtn.setText("STATYSTKI");
           }

        }
    }
}
