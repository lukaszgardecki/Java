package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSaper extends JMenuBar implements ActionListener {
    JMenu fileMenu, helpMenu;
    JMenuItem endGameItem, easyItem, intermediateItem, expertItem;
    private int menuWidth = MainPanel.mainPanelWidth;
    static int menuHeight = 30;

    MenuSaper() {
        easyItem = new JMenuItem("Pocz¹tkuj¹cy");
        intermediateItem = new JMenuItem("Œredniozaawansowany");
        expertItem = new JMenuItem("Ekspert");
        endGameItem = new JMenuItem("Zakoñcz");

        fileMenu = new JMenu("Plik");
        helpMenu = new JMenu("Pomoc");

        easyItem.addActionListener(this);
        intermediateItem.addActionListener(this);
        expertItem.addActionListener(this);
        endGameItem.addActionListener(this);

        setBounds(0, 0, menuWidth, menuHeight);

        fileMenu.add(easyItem);
        fileMenu.add(intermediateItem);
        fileMenu.add(expertItem);
        fileMenu.add(endGameItem);

        add(fileMenu);
        add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (easyItem.equals(source)) {
            Game.playEasyLevel();
        } else if (intermediateItem.equals(source)) {
            Game.playIntermediateLevel();
        } else if (expertItem.equals(source)) {
            Game.playExpertLevel();
        } else if (endGameItem.equals(source)) {
            System.exit(0);
        }

    }

    public void setMenuWidth(int width) {
        menuWidth = width;
    }
}
