package program.elements.panels;

import program.elements.buttons.MenuButton;
import program.elements.checkboxes.UnderscoreCheckbox;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private static final float WIDTH_IN_PERCENT = 100 - MainPanel.WIDTH_IN_PERCENT;
    //public static final int WIDTH = 150;
    public static final int WIDTH = Math.round(Content.WIDTH * WIDTH_IN_PERCENT/100);;
    public static final int HEIGHT = Content.HEIGHT;
    public static final int X = Content.WIDTH-WIDTH;
    public static final int Y = Content.Y;
    public static final int UP_GAP = 30;
    public static final int GAP_BETWEEN_BTNS = 10;
    public static final int BTN_X = (WIDTH - MenuButton.WIDTH)/2;
    public static MenuButton statBtn;
    public static MenuButton addRemoveBtn;
    public static MenuButton endBtn;
    public static UnderscoreCheckbox checkbox;
    public static JTextArea checkboxLabel;

    public MenuPanel() {
        setBounds(X,Y, WIDTH, HEIGHT);
        setBackground(null);
        //setBackground(Color.RED);
        setLayout(null);

        // Button 1:
        statBtn = new MenuButton("STATYSTYKI");
        statBtn.setActionCommand("stats");
        statBtn.setLocation(BTN_X, UP_GAP);

        // Button 2:
        addRemoveBtn = new MenuButton("MEMOBOX");
        addRemoveBtn.setActionCommand("addRemove");
        addRemoveBtn.setLocation(BTN_X, UP_GAP+MenuButton.HEIGHT+GAP_BETWEEN_BTNS);

        // Button 3:
        endBtn = new MenuButton("ZAKO�CZ");
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
        checkboxLabel.setText("Poka�/Ukryj podpowied�");
        checkboxLabel.setLineWrap(true);
        checkboxLabel.setWrapStyleWord(true);

        add(statBtn);
        add(addRemoveBtn);
        add(endBtn);
        add(checkbox);
        add(checkboxLabel);
    }
}
