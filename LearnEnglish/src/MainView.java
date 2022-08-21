import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JPanel implements ActionListener, KeyListener {

    static JTextField inputTextF;
    static Button check;
    JLabel wordLabel;


    public MainView() {
        setBounds(0,0, 684, 261);
        setBackground(MyColor.BLUE);
        setLayout(null);

        Button statsBtn = new Button("STATYSTYKI");
        statsBtn.setBounds(550,20, 110, 30);
        statsBtn.setActionCommand("stats");
        statsBtn.addActionListener(this);
        statsBtn.setBackground(MyColor.ORANGE_LIGHT);
        statsBtn.setContentAreaFilled(false);
        statsBtn.setFocusPainted(false);
        statsBtn.setBorderPainted(false);
        add(statsBtn);

        check = new Button("Sprawdü");
        check.setBounds(220,200, 120, 30);
        check.setActionCommand("check");
        check.addActionListener(this);
        check.setBackground(MyColor.GREEN);
        check.setContentAreaFilled(false);
        check.setFocusPainted(false);
        check.setBorderPainted(false);
        add(check);

        wordLabel = new JLabel("s≥owo angielskie");
        wordLabel.setBounds(55, 20, 450, 60);
        //wordLabel.setBackground(Color.BLUE);
        wordLabel.setForeground(MyColor.ORANGE_LIGHT);
        wordLabel.setFont(new Font("Courier", Font.BOLD, 30));
        add(wordLabel);

        inputTextF = new JTextField("T≥umaczenie");
        inputTextF.setBounds(130, 160, 300, 30);
        inputTextF.setForeground(Color.GRAY);
        inputTextF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputTextF.getText().equals("T≥umaczenie")) {
                    inputTextF.setText("");
                    inputTextF.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (inputTextF.getText().isEmpty()) {
                    inputTextF.setForeground(Color.GRAY);
                    inputTextF.setText("T≥umaczenie");
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
            inputTextF.setForeground(Color.GRAY);
            inputTextF.setText("T≥umaczenie");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            check.doClick();
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
