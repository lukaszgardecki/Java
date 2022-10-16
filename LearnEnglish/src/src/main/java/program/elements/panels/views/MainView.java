package program.elements.panels.views;

import program.elements.buttons.CheckButton;
import program.elements.labels.DateLabel;
import program.elements.labels.GroupVol;
import program.elements.panels.MainPanel;
import program.elements.text_fields.EnglishWordTextArea;
import program.elements.text_fields.CorrectAnswerTextArea;
import program.elements.text_fields.TranslateTextField;
import program.elements.text_fields.UnderscoresTextArea;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

import static program.Main.loadWord;
import static program.Main.memoBox;


public class MainView extends View {

    public static EnglishWordTextArea wordLabel;
    public static CorrectAnswerTextArea correctAnswer;
    public static UnderscoresTextArea underscores;
    public static TranslateTextField inputTextF;
    public static DateLabel dateLabel;
    public static CheckButton check;
    public static JPanel groups;
    public static GroupVol g1, g2, g3, g4, g5, g6, g7;
    public MainView() {

        underscores = new UnderscoresTextArea();
        g1 = new GroupVol(String.valueOf(memoBox.getGroup(0).size()));
        g2 = new GroupVol(String.valueOf(memoBox.getGroup(1).size()));
        g3 = new GroupVol(String.valueOf(memoBox.getGroup(2).size()));
        g4 = new GroupVol(String.valueOf(memoBox.getGroup(3).size()));
        g5 = new GroupVol(String.valueOf(memoBox.getGroup(4).size()));
        g6 = new GroupVol(String.valueOf(memoBox.getGroup(5).size()));
        g7 = new GroupVol(String.valueOf(memoBox.getGroup(6).size()));
        wordLabel = new EnglishWordTextArea();
        groups = new JPanel();
        correctAnswer = new CorrectAnswerTextArea();
        inputTextF = new TranslateTextField("T≥umaczenie");
        dateLabel = new DateLabel();
        check = new CheckButton("Sprawdü");

        setGroupColor(loadWord());

        groups.setLayout(new GridLayout(1, 7));
        groups.setSize(450, 50);
        groups.setLocation((MainPanel.WIDTH - 450)/2, 90);
        groups.setOpaque(false);

        groups.add(g1);
        groups.add(g2);
        groups.add(g3);
        groups.add(g4);
        groups.add(g5);
        groups.add(g6);
        groups.add(g7);

        add(check);
        add(wordLabel, PALETTE_LAYER);
        add(groups, DEFAULT_LAYER);
        add(underscores);

        add(dateLabel);
        add(correctAnswer);
        add(inputTextF);


        setVisible(true);
    }

    public static void setGroupColor(String[] word) {
        int group = Integer.parseInt(word[1]);
        setDefaultGroupColors();

        if (group == 0) MainView.g1.setBackground(MyColor.BLUE1_DARK);
        else if (group == 1) MainView.g2.setBackground(MyColor.RED_DARK);
        else if (group == 2) MainView.g3.setBackground(MyColor.ORANGE1_DARK);
        else if (group == 3) MainView.g4.setBackground(MyColor.ORANGE2_DARK);
        else if (group == 4) MainView.g5.setBackground(MyColor.YELLOW_DARK);
        else if (group == 5) MainView.g6.setBackground(MyColor.GREEN_DARK);
    }

    private static void setDefaultGroupColors() {
        MainView.g1.setBackground(MyColor.BLUE1_LIGHT);
        MainView.g2.setBackground(MyColor.RED_LIGHT);
        MainView.g3.setBackground(MyColor.ORANGE1_LIGHT);
        MainView.g4.setBackground(MyColor.ORANGE2_LIGHT);
        MainView.g5.setBackground(MyColor.YELLOW_LIGHT);
        MainView.g6.setBackground(MyColor.GREEN_LIGHT);
        //MainView.g7.setBackground(MyColor.GRAY);
    }


}
