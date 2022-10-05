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
        int mainContainerWidth;
        int mainContainerHeight;
        int mainPanelWidth;
        int mainPanelHeight;

        Object source = e.getSource();

        if (easyItem.equals(source)) {
            if (!Main.game.getLevel().equals("easy")) {
                Main.playEasyLevel();

                mainContainerWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10);
                mainContainerHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + MainContainer.menu.getMenuHeight() + (3 * 10);
                mainPanelWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * MainPanel.getMarginX());
                mainPanelHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + (3 * MainPanel.getMarginY());

                System.out.printf("Poziom ³atwy, plansza: %sx%s, bomby: %s\n", Main.game.getGameWidth(), Main.game.getGameHeight(), Main.game.getBombs());

                MainFrameSaper.container.setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
                MainContainer.menu.setMenuWidth(FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10));
                setBounds(0, 0, menuWidth, menuHeight);

                MainContainer.mainPanel.setBounds(0, MainContainer.menu.getMenuHeight(), mainPanelWidth, mainPanelHeight);
                
                MainPanel.scoreTimePanel.setBounds(MainPanel.getMarginX(),
                        MainPanel.getMarginY(),
                        FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * MainPanel.getMarginX()) - 2 * MainPanel.getMarginX(),
                        ScoreTimePanel.getScoreTimePanelHeight());








                Main.frame.pack();
                Main.frame.setLocationRelativeTo(null);
            } else {
                //za³aduj now¹ planszê!
                System.out.println("£adujê now¹ planszê EASY");
            }

        } else if (intermediateItem.equals(source)) {
            if (!Main.game.getLevel().equals("intermediate")) {
                Main.playIntermediateLevel();

                mainContainerWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10);
                ;
                mainContainerHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + MainContainer.menu.getMenuHeight() + (3 * 10);
                mainPanelWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * MainPanel.getMarginX());
                mainPanelHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + (3 * MainPanel.getMarginY());





                System.out.printf("Poziom œredni, plansza: %sx%s, bomby: %s\n", Main.game.getGameWidth(), Main.game.getGameHeight(), Main.game.getBombs());

                MainFrameSaper.container.setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
                MainContainer.menu.setMenuWidth(FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10));
                setBounds(0, 0, menuWidth, menuHeight);

                MainContainer.mainPanel.setBounds(0, MainContainer.menu.getMenuHeight(), mainPanelWidth, mainPanelHeight);

                MainPanel.scoreTimePanel.setBounds(MainPanel.getMarginX(),
                        MainPanel.getMarginY(),
                        FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * MainPanel.getMarginX()) - 2 * MainPanel.getMarginX(),
                        ScoreTimePanel.getScoreTimePanelHeight());






                Main.frame.pack();
                Main.frame.setLocationRelativeTo(null);
            } else {
                //za³aduj now¹ planszê!
                System.out.println("£adujê now¹ planszê INTERMEDIATE");
            }
        } else if (expertItem.equals(source)) {
            if (!Main.game.getLevel().equals("expert")) {
                Main.playExpertLevel();

                mainContainerWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10);
                ;
                mainContainerHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + MainContainer.menu.getMenuHeight() + (3 * 10);
                mainPanelWidth = FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * MainPanel.getMarginX());
                mainPanelHeight = FieldLabel.getFieldHeight() * Main.game.getGameHeight() + 50 + (3 * MainPanel.getMarginY());



                System.out.printf("Poziom trudny, plansza: %sx%s, bomby: %s\n", Main.game.getGameWidth(), Main.game.getGameHeight(), Main.game.getBombs());

                MainFrameSaper.container.setPreferredSize(new Dimension(mainContainerWidth, mainContainerHeight));
                MainContainer.menu.setMenuWidth(FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * 10));
                setBounds(0, 0, menuWidth, menuHeight);

                MainContainer.mainPanel.setBounds(0, MainContainer.menu.getMenuHeight(), mainPanelWidth, mainPanelHeight);

                MainPanel.scoreTimePanel.setBounds(MainPanel.getMarginX(),
                        MainPanel.getMarginY(),
                        FieldLabel.getFieldWidth() * Main.game.getGameWidth() + (2 * MainPanel.getMarginX()) - 2 * MainPanel.getMarginX(),
                        ScoreTimePanel.getScoreTimePanelHeight());






                Main.frame.pack();
                Main.frame.setLocationRelativeTo(null);
            } else {
                //za³aduj now¹ planszê!
                System.out.println("£adujê now¹ planszê EXPERT");
            }


        } else if (endGameItem.equals(source)) {
            System.exit(0);
        }

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
