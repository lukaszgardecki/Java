package program.elements.panels;

import program.elements.buttons.MenuButton;

import javax.swing.*;

public class MenuPanel extends JPanel {

    public static final int WIDTH = 150;
    public static final int HEIGHT = Content.HEIGHT;
    public static final int X = Content.WIDTH-WIDTH;
    public static final int Y = Content.Y;
    public static final int UP_GAP = 30;
    public static final int GAP_BETWEEN_BTNS = 10;
    public static final int BTN_X = (int) ((MenuPanel.WIDTH - MenuButton.WIDTH) * 0.5);
    public static MenuButton statBtn;
    public static MenuButton addRemoveBtn;

    public MenuPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        setBackground(null);
        setLayout(null);

        // Button 1:
        statBtn = new MenuButton("STATYSTYKI");
        statBtn.setActionCommand("stats");
        statBtn.setLocation(BTN_X, UP_GAP);

        // Button 2:
        addRemoveBtn = new MenuButton("DODAJ/USUÑ");
        addRemoveBtn.setActionCommand("addRemove");
        addRemoveBtn.setLocation(BTN_X, UP_GAP+MenuButton.HEIGHT+GAP_BETWEEN_BTNS);

        add(statBtn);
        add(addRemoveBtn);
    }
}
