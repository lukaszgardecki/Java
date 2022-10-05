package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSaper extends JMenuBar implements ActionListener {
    JMenu fileMenu, helpMenu;
    JMenuItem endGameItem, easyItem, intermediateItem, expertItem;
    private int menuWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10);
    private int menuHeight = 30;

    MenuSaper() {
        setBounds(0, 0, menuWidth, menuHeight);

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

        fileMenu.add(easyItem);
        fileMenu.add(intermediateItem);
        fileMenu.add(expertItem);
        fileMenu.addSeparator();
        fileMenu.add(endGameItem);

        add(fileMenu);
        add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        boolean isClickedExit = endGameItem.equals(source);
        boolean isChangedLevToEasy = easyItem.equals(source) && !Main.game.getLevel().equals("easy");
        boolean isChangedLevToInteMediate = intermediateItem.equals(source) && !Main.game.getLevel().equals("intermediate");
        boolean icChangedLevToExpert = expertItem.equals(source) && !Main.game.getLevel().equals("expert");

        if (isClickedExit) {
            System.exit(0);
        } else if (isChangedLevToEasy) {
            Game.playEasy();
        } else if (isChangedLevToInteMediate) {
            Game.playIntermediate();
        } else if (icChangedLevToExpert) {
            Game.playExpert();
        } else {
            MainPanel.resetElements();
        }
    }

    void changeSize() {
        MainContainer.menu.setMenuWidth(FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10));
        setBounds(0, 0, menuWidth, menuHeight);
    }

    public void setMenuWidth(int width) {
        menuWidth = width;
    }

    public int getMenuHeight() {
        return menuHeight;
    }
}
