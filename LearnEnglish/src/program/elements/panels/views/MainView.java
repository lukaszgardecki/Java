package program.elements.panels.views;

import program.elements.buttons.CheckButton;
import program.elements.buttons.MenuButton;
import program.elements.labels.DateLabel;
import program.elements.panels.Content;
import program.Main;
import program.elements.panels.MainPanel;
import program.elements.text_fields.EnglishWordTextArea;
import program.elements.text_fields.CorrectAnswerTextArea;
import program.elements.text_fields.TranslateTextField;
import program.settings.MyColor;

import java.awt.*;
import java.awt.event.*;

public class MainView extends View implements KeyListener {
    static EnglishWordTextArea wordLabel;
    static CorrectAnswerTextArea correctAnswer;
    static TranslateTextField inputTextF;
    static DateLabel dateLabel;
    static CheckButton check;
    static boolean isAnswerWrong = false;

    public MainView() {
        wordLabel = new EnglishWordTextArea();
        correctAnswer = new CorrectAnswerTextArea();
        inputTextF = new TranslateTextField();
        dateLabel = new DateLabel();
        check = new CheckButton("SprawdŸ");

        add(check);
        add(wordLabel);
        add(dateLabel);
        add(correctAnswer);
        add(inputTextF);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();

        if(a.equals("check")) {
            if (!inputTextF.getText().isEmpty() && !inputTextF.getText().equals("T³umaczenie")) {
                //je¿eli odpowiedŸ jest dobra
                if (inputTextF.getText().equals(Main.loadWord().get(1))) {
                    Main.changeLevel("up");
                }
                //je¿eli odpowiedŸ jest z³a
                else {
                    isAnswerWrong = true;
                    wordLabel.setForeground(MyColor.RED);
                    correctAnswer.setText(Main.loadWord().get(1));

                    Main.changeLevel("down");

                }
//                wordLabel.setText(program.Main.loadWord().get(0));
//                dateLabel.setText("Ostatnia powtórka: " + program.Main.getDate());

                //nadpisz statystyki
                StatsField.t2.setText(String.valueOf(Main.map.get(1).size()));
                StatsField.t3.setText(String.valueOf(Main.map.get(2).size()));
                StatsField.t4.setText(String.valueOf(Main.map.get(3).size()));
                StatsField.t5.setText(String.valueOf(Main.map.get(4).size()));
                StatsField.t6.setText(String.valueOf(Main.map.get(5).size()));
            }

            inputTextF.setForeground(Color.GRAY);
            inputTextF.setText("T³umaczenie");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (isAnswerWrong) {
                wordLabel.setForeground(MyColor.BLACK);
                wordLabel.setText(Main.loadWord().get(0));
                correctAnswer.setText("");
                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
                isAnswerWrong = false;
            } else {
                check.doClick();
            }


            if (!isAnswerWrong) {
                wordLabel.setText(Main.loadWord().get(0));
                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            inputTextF.setText("");
            inputTextF.setForeground(Color.BLACK);
        }
    }
}
