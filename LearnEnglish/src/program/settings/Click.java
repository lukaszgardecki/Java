package program.settings;

import program.Main;
import program.elements.panels.MainPanel;
import program.elements.panels.MenuPanel;
import program.elements.panels.views.AddOrRemoveView;
import program.elements.panels.views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static program.elements.panels.MenuPanel.statBtn;
import static program.elements.panels.views.MainView.*;

public class Click implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        JPanel mainView = MainPanel.mainView;
        JPanel editView = MainPanel.addRemoveView;
        JPanel statsView = MainPanel.statsView;

        if(a.equals("stats") && statBtn.getText().equals("STATYSTYKI")) {
            mainView.setVisible(false);
            editView.setVisible(false);
            statsView.setVisible(true);

            MenuPanel.addRemoveBtn.setVisible(false);
            statBtn.setText("WR”∆");
        } else if (a.equals("stats") && statBtn.getText().equals("WR”∆")) {
            if (MainPanel.addRemoveView.isVisible()) {
                AddOrRemoveView.tf1.setForeground(Color.GRAY);
                AddOrRemoveView.tf1.setText("wpisz s≥Ûwko");
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t≥umaczenie");
                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
                AddOrRemoveView.addBtn.setText("DODAJ");
                AddOrRemoveView.list.clearSelection();
            }
            editView.setVisible(false);
            statsView.setVisible(false);
            mainView.setVisible(true);

            MenuPanel.addRemoveBtn.setVisible(true);
            statBtn.setText("STATYSTYKI");
        } else if(a.equals("check")) {
            if (!inputTextF.getText().isEmpty() && !inputTextF.getText().equals("T≥umaczenie")) {
                //jeøeli odpowiedü jest dobra
                if (inputTextF.getText().equals(Main.loadWord().get(5))) {
                    Main.changeLevel("up");
                }
                //jeøeli odpowiedü jest z≥a
                else {
                    isAnswerWrong = true;
                    wordLabel.setForeground(MyColor.RED);
                    //MainView.correctAnswer.setText(Main.loadWord().get(5));
                    MainView.correctAnswer.setText(Main.getCorrectAnswer());
                    Main.changeLevel("down");
                }

                //nadpisz statystyki
                Main.updateStatistics();
            }

            MainView.inputTextF.setForeground(Color.GRAY);
            MainView.inputTextF.setText("T≥umaczenie");
        } else if (a.equals("addRemove")) {
            mainView.setVisible(false);
            statsView.setVisible(false);
            editView.setVisible(true);
            AddOrRemoveView.tf1.transferFocus();
            AddOrRemoveView.tf2.transferFocus();

            MenuPanel.addRemoveBtn.setVisible(false);
            statBtn.setText("WR”∆");
        } else if (a.equals("add") && AddOrRemoveView.addBtn.getText().equals("DODAJ")) {
            if (!AddOrRemoveView.tf1.getText().equals("wpisz s≥Ûwko") && !AddOrRemoveView.tf1.getText().isBlank() &&
                !AddOrRemoveView.tf2.getText().equals("wpisz t≥umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
                Main.addWordToBase();

                AddOrRemoveView.tf1.setText("");
                AddOrRemoveView.tf1.requestFocusInWindow();
                AddOrRemoveView.tf2.setText("");
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t≥umaczenie");
            }

        } else if (a.equals("add") && AddOrRemoveView.addBtn.getText().equals("ZMIE—")) {
            if (!AddOrRemoveView.tf1.getText().equals("wpisz s≥Ûwko") && !AddOrRemoveView.tf1.getText().isBlank() &&
                    !AddOrRemoveView.tf2.getText().equals("wpisz t≥umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
                Main.changeTheWordInBase();

                AddOrRemoveView.tf1.setText("");
                AddOrRemoveView.tf1.requestFocusInWindow();
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t≥umaczenie");
                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
                AddOrRemoveView.addBtn.setText("DODAJ");
                AddOrRemoveView.list.clearSelection();
            }
        }

        else if (a.equals("remove")) {
            if (!AddOrRemoveView.tf1.getText().equals("wpisz s≥Ûwko") && !AddOrRemoveView.tf1.getText().isBlank() &&
                    !AddOrRemoveView.tf2.getText().equals("wpisz t≥umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
                Main.removeFromBase();

                AddOrRemoveView.tf1.setText("");
                AddOrRemoveView.tf1.requestFocusInWindow();
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t≥umaczenie");
                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
                AddOrRemoveView.addBtn.setText("DODAJ");
                AddOrRemoveView.list.clearSelection();
            }
        }
    }



}
