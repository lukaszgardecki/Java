package program.elements.panels;

import program.elements.buttons.MenuButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {

    public static final int WIDTH = 150;
    public static final int HEIGHT = Content.HEIGHT;
    public static final int X = Content.HEIGHT-WIDTH;
    public static final int Y = Content.Y;
    public static final int UP_GAP = 30;
    public static final int GAP_BETWEEN_BTNS = 10;
    public static final int BTN_X = (int) (MainPanel.WIDTH + (MenuPanel.WIDTH - MenuButton.WIDTH) * 0.5);

    public MenuPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        //setBackground(MyColor.BLUE);
        setLayout(null);

        MenuButton statBtn = new MenuButton("STATYSTYKI");
        statBtn.setActionCommand("stats");
        statBtn.setLocation(BTN_X, UP_GAP);

        MenuButton addRemoveBtn = new MenuButton("DODAJ/USUÑ");
        addRemoveBtn.setActionCommand("addRemove");
        addRemoveBtn.setLocation(BTN_X, UP_GAP+MenuButton.HEIGHT+GAP_BETWEEN_BTNS);

        add(statBtn);
        add(addRemoveBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
