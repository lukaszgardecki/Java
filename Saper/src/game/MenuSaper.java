package game;

import javax.swing.*;
import java.awt.*;
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

        if (easyItem.equals(source)) {
            if (!Main.game.getLevel().equals("easy")) {
                Main.playEasyLevel();

                MainFrameSaper.container.refresh();
                refresh();
                MainContainer.mainPanel.refresh();
                MainPanel.scoreTimePanel.refresh();
                MainPanel.boardLabelPanel.refresh();
                MainPanel.boardButtonsPanel.refresh();
                Main.frame.refresh();
            } else {
                //za³aduj now¹ planszê!
                System.out.println("£adujê now¹ planszê EASY");

                MainPanel.scoreTimePanel.timerLabel.setText(String.format("%02d:%02d", 0, 0));
                ScoreTimePanel.timer.stop();
                MainPanel.scoreTimePanel.bombCounter.setText(String.valueOf(Main.game.getBombs()));
                ScoreTimePanel.remainingBombs = Main.game.getBombs();

                MainPanel.boardLabelPanel.removeAll();
                MainPanel.boardLabelPanel.fillBoard();
                BoardLabelPanel.insertBombs(Main.game.getBombs());

                MainPanel.boardButtonsPanel.removeAll();
                MainPanel.boardButtonsPanel.fillBoard();

                BoardButtonsPanel.amountOfDiscoveredFields = 0;
                BoardButtonsPanel.amountOfAllFields = Main.game.getGameWidth() * Main.game.getGameHeight();
            }

        } else if (intermediateItem.equals(source)) {
            if (!Main.game.getLevel().equals("intermediate")) {
                Main.playIntermediateLevel();

                MainFrameSaper.container.refresh();
                refresh();
                MainContainer.mainPanel.refresh();
                MainPanel.scoreTimePanel.refresh();
                MainPanel.boardLabelPanel.refresh();
                MainPanel.boardButtonsPanel.refresh();
                Main.frame.refresh();
            } else {
                //za³aduj now¹ planszê!
                System.out.println("£adujê now¹ planszê INTERMEDIATE");

                MainPanel.scoreTimePanel.timerLabel.setText(String.format("%02d:%02d", 0, 0));
                ScoreTimePanel.timer.stop();
                MainPanel.scoreTimePanel.bombCounter.setText(String.valueOf(Main.game.getBombs()));
                ScoreTimePanel.remainingBombs = Main.game.getBombs();

                MainPanel.boardLabelPanel.removeAll();
                MainPanel.boardLabelPanel.fillBoard();
                BoardLabelPanel.insertBombs(Main.game.getBombs());

                MainPanel.boardButtonsPanel.removeAll();
                MainPanel.boardButtonsPanel.fillBoard();

                BoardButtonsPanel.amountOfDiscoveredFields = 0;
                BoardButtonsPanel.amountOfAllFields = Main.game.getGameWidth() * Main.game.getGameHeight();
            }
        } else if (expertItem.equals(source)) {
            if (!Main.game.getLevel().equals("expert")) {
                Main.playExpertLevel();

                MainFrameSaper.container.refresh();
                refresh();
                MainContainer.mainPanel.refresh();
                MainPanel.scoreTimePanel.refresh();
                MainPanel.boardLabelPanel.refresh();
                MainPanel.boardButtonsPanel.refresh();
                Main.frame.refresh();
            } else {
                //za³aduj now¹ planszê!
                System.out.println("£adujê now¹ planszê EXPERT");

                MainPanel.scoreTimePanel.timerLabel.setText(String.format("%02d:%02d", 0, 0));
                ScoreTimePanel.timer.stop();
                MainPanel.scoreTimePanel.bombCounter.setText(String.valueOf(Main.game.getBombs()));
                ScoreTimePanel.remainingBombs = Main.game.getBombs();

                MainPanel.boardLabelPanel.removeAll();
                MainPanel.boardLabelPanel.fillBoard();
                BoardLabelPanel.insertBombs(Main.game.getBombs());

                MainPanel.boardButtonsPanel.removeAll();
                MainPanel.boardButtonsPanel.fillBoard();

                BoardButtonsPanel.amountOfDiscoveredFields = 0;
                BoardButtonsPanel.amountOfAllFields = Main.game.getGameWidth() * Main.game.getGameHeight();
            }
        } else if (endGameItem.equals(source)) {
            System.exit(0);
        }
    }

    void refresh() {
        MainContainer.menu.setMenuWidth(FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10));
        setBounds(0, 0, menuWidth, menuHeight);
    }

    public void setMenuWidth(int width) {
        menuWidth = width;
    }

    public int getMenuWidth() {
        return menuWidth;
    }

    public int getMenuHeight() {
        return menuHeight;
    }
}
