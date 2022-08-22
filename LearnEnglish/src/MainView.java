import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JPanel implements ActionListener, KeyListener {

    static JTextField inputTextF;
    static Button check;
    JTextArea wordLabel;
    JLabel dateLabel;
    JTextArea correctAnswer;
    static boolean isAnswerWrong = false;

    public MainView() {
        setBounds(0,0, 684, 361);
        setBackground(MyColor.BLUE);
        setLayout(null);

        Button statsBtn = new Button("STATYSTYKI");
        statsBtn.setBounds(550,30, 110, 30);
        statsBtn.setActionCommand("stats");
        statsBtn.addActionListener(this);
        statsBtn.setBackground(MyColor.ORANGE_LIGHT);
        statsBtn.setContentAreaFilled(false);
        statsBtn.setFocusPainted(false);
        statsBtn.setBorderPainted(false);
        add(statsBtn);

        check = new Button("SprawdŸ");
        check.setBounds(220,300, 120, 30);
        check.setActionCommand("check");
        check.addActionListener(this);
        check.setBackground(MyColor.GREEN);
        check.setContentAreaFilled(false);
        check.setFocusPainted(false);
        check.setBorderPainted(false);
        add(check);

        wordLabel = new JTextArea();
        wordLabel.setText(Main.loadWord().get(0));
        wordLabel.setBounds(55, 30, 450, 80);
        wordLabel.setLineWrap(true);
        wordLabel.setWrapStyleWord(true);
        wordLabel.setEditable(false);
        wordLabel.setBackground(MyColor.BLUE_LIGHT);
        wordLabel.setForeground(MyColor.BLACK);
        wordLabel.setFont(new Font("Courier", Font.BOLD, 30));
        add(wordLabel);

        dateLabel = new JLabel();
        dateLabel.setText("Ostatnia powtórka: " + Main.getDate());
        dateLabel.setBounds(280, 110, 300, 20);
        dateLabel.setFont(new Font("Courier", Font.PLAIN, 12));
        add(dateLabel);

        correctAnswer = new JTextArea();
        correctAnswer.setBackground(MyColor.BLUE);
        correctAnswer.setEditable(false);
        correctAnswer.setLineWrap(true);
        correctAnswer.setWrapStyleWord(true);
        correctAnswer.setBounds(55, 185, 450, 27);
        correctAnswer.setFont(new Font("Courier", Font.PLAIN, 22));
        correctAnswer.setForeground(MyColor.GREEN);
        add(correctAnswer);


        inputTextF = new JTextField("T³umaczenie");
        inputTextF.setBounds(130, 260, 300, 30);
        inputTextF.setForeground(Color.GRAY);
        inputTextF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputTextF.getText().equals("T³umaczenie")) {
                    inputTextF.setText("");
                    inputTextF.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (inputTextF.getText().isEmpty()) {
                    inputTextF.setForeground(Color.GRAY);
                    inputTextF.setText("T³umaczenie");
                }
            }
        });
        inputTextF.setFont(new Font("Courier", Font.PLAIN, 18));
        inputTextF.setBackground(MyColor.BLUE_LIGHT);
        inputTextF.setBorder(BorderFactory.createEmptyBorder());
        inputTextF.addKeyListener(this);
        add(inputTextF);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();

        if(a.equals("stats")) {
            Content.view.setVisible(false);
            Content.st.setVisible(true);
        }

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
//                wordLabel.setText(Main.loadWord().get(0));
//                dateLabel.setText("Ostatnia powtórka: " + Main.getDate());

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
