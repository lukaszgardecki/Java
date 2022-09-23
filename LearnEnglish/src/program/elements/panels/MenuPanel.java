package program.elements.panels;

import program.elements.buttons.MenuButton;
import program.elements.checkboxes.UnderscoreCheckbox;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

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
    public static MenuButton endBtn;
    public static UnderscoreCheckbox checkbox;
    public static JTextArea checkboxLabel;

    public MenuPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        setBackground(null);
        setLayout(null);

        // Button 1:
        statBtn = new MenuButton("STATYSTYKI");
        statBtn.setActionCommand("stats");
        statBtn.setLocation(BTN_X, UP_GAP);

        // Button 2:
        addRemoveBtn = new MenuButton("DODAJ/USU—");
        addRemoveBtn.setActionCommand("addRemove");
        addRemoveBtn.setLocation(BTN_X, UP_GAP+MenuButton.HEIGHT+GAP_BETWEEN_BTNS);

        // Button 3:
        endBtn = new MenuButton("ZAKO—CZ");
        endBtn.setActionCommand("end");
        endBtn.setLocation(BTN_X, UP_GAP+2*MenuButton.HEIGHT+2*GAP_BETWEEN_BTNS);

        // Checkbox show/hide underscores:
        checkbox = new UnderscoreCheckbox();
        checkbox.setLocation(10, 230);
        checkbox.setSelected(true);

        // Checkbox Label:
        checkboxLabel = new JTextArea();
        checkboxLabel.setLocation(40, 220);
        checkboxLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        checkboxLabel.setBackground(MyColor.BLUE);
        checkboxLabel.setSize(80, 40);
        checkboxLabel.setText("Pokaø/Ukryj podpowiedü");
        checkboxLabel.setLineWrap(true);
        checkboxLabel.setWrapStyleWord(true);



        add(statBtn);
        add(addRemoveBtn);
        add(endBtn);
        add(checkbox);
        add(checkboxLabel);
    }
}
