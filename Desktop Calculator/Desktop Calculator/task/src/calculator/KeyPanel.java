package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyPanel extends JPanel implements ActionListener {

    public KeyPanel() {
        setBounds(25,100,335,250);
        //setBackground(Color.ORANGE);
        setLayout(new GridLayout(4, 4, 25, 25));

        Key key7 = new Key();
        key7.setText("7");
        key7.setName("Seven");
        key7.setActionCommand("7");
        key7.addActionListener(this);
        add(key7);

        Key key8 = new Key();
        key8.setText("8");
        key8.setName("Eight");
        key8.setActionCommand("8");
        key8.addActionListener(this);
        add(key8);

        Key key9 = new Key();
        key9.setText("9");
        key9.setName("Nine");
        key9.setActionCommand("9");
        key9.addActionListener(this);
        add(key9);

        Key keyDiv = new Key();
        keyDiv.setText("/");
        keyDiv.setName("Divide");
        keyDiv.setActionCommand("/");
        keyDiv.addActionListener(this);
        add(keyDiv);

        Key key4 = new Key();
        key4.setText("4");
        key4.setName("Four");
        key4.setActionCommand("4");
        key4.addActionListener(this);
        add(key4);

        Key key5 = new Key();
        key5.setText("5");
        key5.setName("Five");
        key5.setActionCommand("5");
        key5.addActionListener(this);
        add(key5);

        Key key6 = new Key();
        key6.setText("6");
        key6.setName("Six");
        key6.setActionCommand("6");
        key6.addActionListener(this);
        add(key6);

        Key keyMult = new Key();
        keyMult.setText("x");
        keyMult.setName("Multiply");
        keyMult.setActionCommand("*");
        keyMult.addActionListener(this);
        add(keyMult);

        Key key1 = new Key();
        key1.setText("1");
        key1.setName("One");
        key1.setActionCommand("1");
        key1.addActionListener(this);
        add(key1);

        Key key2 = new Key();
        key2.setText("2");
        key2.setName("Two");
        key2.setActionCommand("2");
        key2.addActionListener(this);
        add(key2);

        Key key3 = new Key();
        key3.setText("3");
        key3.setName("Three");
        key3.setActionCommand("3");
        key3.addActionListener(this);
        add(key3);

        Key keyPlus = new Key();
        keyPlus.setText("+");
        keyPlus.setName("Add");
        keyPlus.setActionCommand("+");
        keyPlus.addActionListener(this);
        add(keyPlus);

        Key empty = new Key();
        empty.setVisible(false);
        add(empty);

        Key key0 = new Key();
        key0.setText("0");
        key0.setName("Zero");
        key0.setActionCommand("0");
        key0.addActionListener(this);
        add(key0);

        Key keyEqual = new Key();
        keyEqual.setText("=");
        keyEqual.setName("Equals");
        keyEqual.setActionCommand("=");
        keyEqual.addActionListener(this);
        add(keyEqual);

        Key keyMinus = new Key();
        keyMinus.setText("-");
        keyMinus.setName("Subtract");
        keyMinus.setActionCommand("-");
        keyMinus.addActionListener(this);
        add(keyMinus);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();
        String textIn;
        String textNew;
        System.out.println(event);

        switch (event) {
            case "1":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "1");
                ResultPanel.txtF.setText(textNew);
                break;
            case "2":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "2");
                ResultPanel.txtF.setText(textNew);
                break;
            case "3":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "3");
                ResultPanel.txtF.setText(textNew);
                break;
            case "4":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "4");
                ResultPanel.txtF.setText(textNew);
                break;
            case "5":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "5");
                ResultPanel.txtF.setText(textNew);
                break;
            case "6":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "6");
                ResultPanel.txtF.setText(textNew);
                break;
            case "7":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "7");
                ResultPanel.txtF.setText(textNew);
                break;
            case "8":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "8");
                ResultPanel.txtF.setText(textNew);
                break;
            case "9":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "9");
                ResultPanel.txtF.setText(textNew);
                break;
            case "0":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "0");
                ResultPanel.txtF.setText(textNew);
                break;
            case "-":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "-");
                ResultPanel.txtF.setText(textNew);
                break;
            case "+":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "+");
                ResultPanel.txtF.setText(textNew);
                break;
            case "/":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "/");
                ResultPanel.txtF.setText(textNew);
                break;
            case "*":
                textIn = ResultPanel.txtF.getText();
                textNew = String.format(textIn + "x");
                ResultPanel.txtF.setText(textNew);
                break;
            case "=":
                textIn = ResultPanel.txtF.getText();
                String[] numTab = {};
                int result = 0;


                if (textIn.contains("+")) {
                    numTab = textIn.split("\\+");
                    result = Integer.parseInt(String.valueOf(numTab[0])) +
                             Integer.parseInt(String.valueOf(numTab[1]));
                } else if (textIn.contains("-")) {
                    numTab = textIn.split("-");
                    result = Integer.parseInt(String.valueOf(numTab[0])) -
                            Integer.parseInt(String.valueOf(numTab[1]));
                } else if (textIn.contains("x")) {
                    numTab = textIn.split("x");
                    result = Integer.parseInt(String.valueOf(numTab[0])) *
                            Integer.parseInt(String.valueOf(numTab[1]));
                } else if (textIn.contains("/")) {
                    numTab = textIn.split("/");
                    result = Integer.parseInt(String.valueOf(numTab[0])) /
                            Integer.parseInt(String.valueOf(numTab[1]));
                }
                if(!textIn.equals("")) {
                    ResultPanel.txtF.setText(textIn + "=" + result);
                }
                break;

        }
    }


}
