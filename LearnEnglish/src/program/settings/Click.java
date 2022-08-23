package program.settings;

import program.Main;
import program.elements.panels.MainPanel;
import program.elements.panels.MenuPanel;
import program.elements.panels.views.MainView;
import program.elements.panels.views.StatsView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static program.elements.panels.MenuPanel.statBtn;
import static program.elements.panels.views.MainView.*;

public class Click implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();
        if(a.equals("stats") && statBtn.getText().equals("STATYSTYKI")) {
            MainPanel.mainView.setVisible(false);
            MainPanel.statsView.setVisible(true);
            MenuPanel.addRemoveBtn.setVisible(false);
            statBtn.setText("WR”∆");
        } else if (a.equals("stats") && statBtn.getText().equals("WR”∆")) {
            MainPanel.statsView.setVisible(false);
            MainPanel.mainView.setVisible(true);
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
                    MainView.correctAnswer.setText(Main.loadWord().get(5));
                    Main.changeLevel("down");
                }

                //nadpisz statystyki
                StatsView.t2.setText(String.valueOf(Main.map.get(1).size()));
                StatsView.t3.setText(String.valueOf(Main.map.get(2).size()));
                StatsView.t4.setText(String.valueOf(Main.map.get(3).size()));
                StatsView.t5.setText(String.valueOf(Main.map.get(4).size()));
                StatsView.t6.setText(String.valueOf(Main.map.get(5).size()));
            }

            MainView.inputTextF.setForeground(Color.GRAY);
            MainView.inputTextF.setText("T≥umaczenie");
        } else if (a.equals("addRemove")) {
            MainPanel.mainView.setVisible(false);
            MainPanel.addRemoveView.setVisible(true);
            MenuPanel.addRemoveBtn.setVisible(false);
            statBtn.setText("WR”∆");
        }
    }


}
