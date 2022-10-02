package game;

import javax.swing.*;

public class MenuSaper extends JMenuBar {

    JMenu fileMenu;
    JMenu helpMenu;
    private int menuWidth = MainPanel.mainPanelWidth;
    static int menuHeight = 30;

    MenuSaper() {
        fileMenu = new JMenu("Plik");
        helpMenu = new JMenu("Pomoc");

        setBounds(0, 0, menuWidth, menuHeight);


        add(fileMenu);
        add(helpMenu);

    }
}
