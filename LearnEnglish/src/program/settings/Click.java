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

        if (a.equals("end")) {
            Main.saveData();
            Main.win.dispose();
        } else if(a.equals("stats") && statBtn.getText().equals("STATYSTYKI")) {
            mainView.setVisible(false);
            editView.setVisible(false);
            statsView.setVisible(true);

            MenuPanel.addRemoveBtn.setVisible(false);
            MenuPanel.endBtn.setVisible(false);
            statBtn.setText("WRÓÆ");
        } else if (a.equals("stats") && statBtn.getText().equals("WRÓÆ")) {
            if (MainPanel.addRemoveView.isVisible()) {
                AddOrRemoveView.tf1.setForeground(Color.GRAY);
                AddOrRemoveView.tf1.setText("wpisz s³ówko");
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
                AddOrRemoveView.addBtn.setText("DODAJ");
                AddOrRemoveView.list.clearSelection();
            }
            editView.setVisible(false);
            statsView.setVisible(false);
            mainView.setVisible(true);

            MenuPanel.addRemoveBtn.setVisible(true);
            MenuPanel.endBtn.setVisible(true);
            statBtn.setText("STATYSTYKI");
        } else if(a.equals("check")) {
            if (check.getText().equals("Dalej")) {
                wordLabel.setText(Main.loadWord().get(4));
                wordLabel.setForeground(MyColor.BLACK);
                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
                correctAnswer.setText("");
                inputTextF.requestFocusInWindow();
                inputTextF.setEditable(true);
                inputTextF.setForeground(MyColor.BLACK);
                inputTextF.setText("");
                check.setText("SprawdŸ");
            } else if (check.getText().equals("SprawdŸ") && !inputTextF.getText().isEmpty() && !inputTextF.getText().equals("T³umaczenie")) {
                /* ----- if answer is good ----- */
                if ((inputTextF.getText().toLowerCase()).equals(Main.loadWord().get(5).toLowerCase())) {
                    Main.changeLevel("up");
                    wordLabel.setText(Main.loadWord().get(4));
                    dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
                    inputTextF.setText("");
                    inputTextF.requestFocusInWindow();
                }
                /* ----- if answer is bad ----- */
                else {
                    wordLabel.setForeground(MyColor.RED);
                    correctAnswer.setText(Main.getCorrectAnswer());
                    inputTextF.setForeground(Color.GRAY);
                    inputTextF.setEditable(false);
                    check.setText("Dalej");
                    Main.changeLevel("down");
                }
                Main.updateStatistics();
            }
        } else if (a.equals("addRemove")) {
            mainView.setVisible(false);
            statsView.setVisible(false);
            editView.setVisible(true);
            AddOrRemoveView.tf1.transferFocus();
            AddOrRemoveView.tf2.transferFocus();

            MenuPanel.addRemoveBtn.setVisible(false);
            MenuPanel.endBtn.setVisible(false);
            statBtn.setText("WRÓÆ");
        } else if (a.equals("add") && AddOrRemoveView.addBtn.getText().equals("DODAJ")) {
            if (!AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") && !AddOrRemoveView.tf1.getText().isBlank() &&
                !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
                Main.addWordToBase();

                AddOrRemoveView.tf1.setText("");
                AddOrRemoveView.tf1.requestFocusInWindow();
                AddOrRemoveView.tf2.setText("");
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
            }

        } else if (a.equals("add") && AddOrRemoveView.addBtn.getText().equals("ZMIEÑ")) {
            if (!AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") && !AddOrRemoveView.tf1.getText().isBlank() &&
                    !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
                Main.changeTheWordInBase();

                AddOrRemoveView.tf1.setText("");
                AddOrRemoveView.tf1.requestFocusInWindow();
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
                AddOrRemoveView.addBtn.setText("DODAJ");
                AddOrRemoveView.list.clearSelection();
            }
        }

        else if (a.equals("remove")) {
            if (!AddOrRemoveView.tf1.getText().equals("wpisz s³ówko") && !AddOrRemoveView.tf1.getText().isBlank() &&
                    !AddOrRemoveView.tf2.getText().equals("wpisz t³umaczenie") && !AddOrRemoveView.tf2.getText().isBlank()) {
                Main.removeFromBase();

                AddOrRemoveView.tf1.setText("");
                AddOrRemoveView.tf1.requestFocusInWindow();
                AddOrRemoveView.tf2.setForeground(Color.GRAY);
                AddOrRemoveView.tf2.setText("wpisz t³umaczenie");
                AddOrRemoveView.addBtn.setBackground(MyColor.GREEN);
                AddOrRemoveView.addBtn.setText("DODAJ");
                AddOrRemoveView.list.clearSelection();
            }
        }
    }



}
