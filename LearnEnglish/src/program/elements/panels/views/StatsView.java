package program.elements.panels.views;

import program.Main;
import program.settings.MyColor;

import javax.swing.*;
import java.awt.*;

public class StatsView extends View {
    Font boldFont = new Font("Courier", Font.BOLD, 16);
    Font plainFont = new Font("Courier", Font.PLAIN, 16);
    private final int TEXTCOL_WIDTH = 280;
    private final int VALUECOL_WIDTH = 150;
    private final int ROW_HEIGHT = 20;
    private final int UP_MARGIN = 20;
    private final int LEFT_MARGIN = 0;
    private final int VERTICAL_GAP = 25;
    public static JLabel t1;
    public static JLabel t2;
    public static JLabel t3;
    public static JLabel t4;
    public static JLabel t5;
    public static JLabel t6;
    public static JLabel t7;
    public static JLabel t8;
    public static JLabel t9;

    public StatsView() {
        setLocation(80, 30);
        setSize(TEXTCOL_WIDTH+VALUECOL_WIDTH, 280);
        setLayout(null);

//        ----------  ROW 1 ----------
        JLabel s1 = new JLabel("Iloœæ zwrotów: ");
        s1.setBounds(LEFT_MARGIN, UP_MARGIN + 1 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s1.setFont(plainFont);
        add(s1);

        t1 = new JLabel(String.valueOf(Main.getAmountOfAllWords()));
        t1.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 1 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t1.setFont(boldFont);
        add(t1);

//        ----------  ROW 2 ----------
        JLabel s2 = new JLabel("Poziom 1: ");
        s2.setBounds(LEFT_MARGIN, UP_MARGIN + 2 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s2.setFont(plainFont);
        s2.setForeground(MyColor.RED);
        add(s2);

        t2 = new JLabel(String.valueOf(Main.map.get(1).size()));
        t2.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 2 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t2.setFont(boldFont);
        t2.setForeground(MyColor.RED);
        add(t2);

//        ----------  ROW 3 ----------
        JLabel s3 = new JLabel("Poziom 2: ");
        s3.setBounds(LEFT_MARGIN, UP_MARGIN + 3 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s3.setFont(plainFont);
        s3.setForeground(MyColor.ORANGE_DARK);
        add(s3);

        t3 = new JLabel(String.valueOf(Main.map.get(2).size()));
        t3.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 3 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t3.setFont(boldFont);
        t3.setForeground(MyColor.ORANGE_DARK);
        add(t3);

//        ----------  ROW 4 ----------
        JLabel s4 = new JLabel("Poziom 3: ");
        s4.setBounds(LEFT_MARGIN, UP_MARGIN + 4 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s4.setFont(plainFont);
        s4.setForeground(MyColor.ORANGE_LIGHT);
        add(s4);

        t4 = new JLabel(String.valueOf(Main.map.get(3).size()));
        t4.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 4 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t4.setFont(boldFont);
        t4.setForeground(MyColor.ORANGE_LIGHT);
        add(t4);

//        ----------  ROW 5 ----------
        JLabel s5 = new JLabel("Poziom 4: ");
        s5.setBounds(LEFT_MARGIN, UP_MARGIN + 5 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s5.setFont(plainFont);
        s5.setForeground(MyColor.YELLOW);
        add(s5);

        t5 = new JLabel(String.valueOf(Main.map.get(4).size()));
        t5.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 5 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t5.setFont(boldFont);
        t5.setForeground(MyColor.YELLOW);
        add(t5);

//        ----------  ROW 6 ----------
        JLabel s6 = new JLabel("Poziom 5: ");
        s6.setBounds(LEFT_MARGIN, UP_MARGIN + 6 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s6.setFont(plainFont);
        s6.setForeground(MyColor.GREEN);
        add(s6);

        t6 = new JLabel(String.valueOf(Main.map.get(5).size()));
        t6.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 6 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t6.setFont(boldFont);
        t6.setForeground(MyColor.GREEN);
        add(t6);

//        ----------  ROW 7 ----------
        JLabel s7 = new JLabel("Iloœæ poprawnych odpowiedzi: ");
        s7.setBounds(LEFT_MARGIN, UP_MARGIN + 7 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s7.setFont(plainFont);
        add(s7);

        t7 = new JLabel(Main.getAmountOfCorrectAns());
        t7.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 7 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t7.setFont(boldFont);
        add(t7);

//        ----------  ROW 8 ----------
        JLabel s8 = new JLabel("Iloœæ niepoprawnych odpowiedzi: ");
        s8.setBounds(LEFT_MARGIN, UP_MARGIN + 8 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s8.setFont(plainFont);
        add(s8);

        t8 = new JLabel(Main.getAmountOfIncorrectAns());
        t8.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 8 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t8.setFont(boldFont);
        add(t8);

//        ----------  ROW 9 ----------
        JLabel s9 = new JLabel("Iloœæ wszystkich odpowiedzi: ");
        s9.setBounds(LEFT_MARGIN, UP_MARGIN + 9 * VERTICAL_GAP, TEXTCOL_WIDTH, ROW_HEIGHT);
        s9.setFont(plainFont);
        add(s9);

        t9 = new JLabel(Main.getAmountOfAllAns());
        t9.setBounds(TEXTCOL_WIDTH, UP_MARGIN + 9 * VERTICAL_GAP, VALUECOL_WIDTH, ROW_HEIGHT);
        t9.setFont(boldFont);
        add(t9);


        setVisible(false);
    }
}
