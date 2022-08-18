package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class KeyPanel extends JPanel implements ActionListener {
    final String ADDITION_SIGN = Character.toString('\u002B');
    final String SUBTRACTION_SIGN = Character.toString('-');
//    final String SUBTRACTION_SIGN = Character.toString('\u2212');
    final String MULTIPLICATION_SIGN = Character.toString('\u00D7');
    final String DIVISION_SIGN = Character.toString('\u00F7');
    ArrayList<String> equationList = new ArrayList<>();
    ArrayList<String> opList = new ArrayList<>();
    DecimalFormat format = new DecimalFormat("0.#");

    public KeyPanel() {
        setBounds(25,175,335,250);
        //setBackground(Color.ORANGE);
        setLayout(new GridLayout(5, 4, 10, 10));


        Key empty1 = new Key();
        empty1.setVisible(false);
        add(empty1);

        Key empty2 = new Key();
        empty2.setVisible(false);
        add(empty2);

        Key keyClear = new Key();
        keyClear.setText("C");
        keyClear.setName("Clear");
        keyClear.setActionCommand("clear");
        keyClear.addActionListener(this);
        add(keyClear);

        Key keyDelete = new Key();
        keyDelete.setText("Del");
        keyDelete.setName("Delete");
        keyDelete.setActionCommand("delete");
        keyDelete.addActionListener(this);
        add(keyDelete);

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
        keyDiv.setText(DIVISION_SIGN);
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
        keyMult.setText(MULTIPLICATION_SIGN);
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
        keyPlus.setText(ADDITION_SIGN);
        keyPlus.setName("Add");
        keyPlus.setActionCommand("+");
        keyPlus.addActionListener(this);
        add(keyPlus);

        Key keyDot = new Key();
        keyDot.setText(".");
        keyDot.setName("Dot");
        keyDot.setActionCommand(".");
        keyDot.addActionListener(this);
        add(keyDot);

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
        keyMinus.setText(SUBTRACTION_SIGN);
        keyMinus.setName("Subtract");
        keyMinus.setActionCommand("-");
        keyMinus.addActionListener(this);
        add(keyMinus);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();
        StringBuilder textIn = new StringBuilder(ResultPanel.equationLabel.getText());
        String lastSign;
        boolean isEquationLabelEmpty = textIn.toString().equals("");
        boolean isLastSignAnOperator = false;
        ResultPanel.equationLabel.setForeground(Color.GREEN.darker());

        if(!isEquationLabelEmpty) {
            lastSign = String.valueOf(textIn.charAt(textIn.length() - 1));
            isLastSignAnOperator = lastSign.equals(ADDITION_SIGN) ||
                                   lastSign.equals(SUBTRACTION_SIGN) ||
                                   lastSign.equals(DIVISION_SIGN) ||
                                   lastSign.equals(MULTIPLICATION_SIGN);
        }
        //System.out.println(event);

        switch (event) {
            case "1":
                ResultPanel.equationLabel.setText(textIn.append("1").toString());
                break;
            case "2":
                ResultPanel.equationLabel.setText(textIn.append("2").toString());
                break;
            case "3":
                ResultPanel.equationLabel.setText(textIn.append("3").toString());
                break;
            case "4":
                ResultPanel.equationLabel.setText(textIn.append("4").toString());
                break;
            case "5":
                ResultPanel.equationLabel.setText(textIn.append("5").toString());
                break;
            case "6":
                ResultPanel.equationLabel.setText(textIn.append("6").toString());
                break;
            case "7":
                ResultPanel.equationLabel.setText(textIn.append("7").toString());
                break;
            case "8":
                ResultPanel.equationLabel.setText(textIn.append("8").toString());
                break;
            case "9":
                ResultPanel.equationLabel.setText(textIn.append("9").toString());
                break;
            case "0":
                ResultPanel.equationLabel.setText(textIn.append("0").toString());
                break;
            case "-":
                if (!isEquationLabelEmpty && isLastSignAnOperator) {
                    ResultPanel.equationLabel.setText(textIn.replace(textIn.length()-1,textIn.length(),SUBTRACTION_SIGN).toString());
                } else if (!isEquationLabelEmpty) {
                    ResultPanel.equationLabel.setText(textIn.append(SUBTRACTION_SIGN).toString());
                }
                break;
            case "+":
                if (!isEquationLabelEmpty && isLastSignAnOperator) {
                    ResultPanel.equationLabel.setText(textIn.replace(textIn.length()-1,textIn.length(),ADDITION_SIGN).toString());
                } else if (!isEquationLabelEmpty) {
                    ResultPanel.equationLabel.setText(textIn.append(ADDITION_SIGN).toString());
                }
                break;
            case "/":
                if (!isEquationLabelEmpty && isLastSignAnOperator) {
                    ResultPanel.equationLabel.setText(textIn.replace(textIn.length()-1,textIn.length(),DIVISION_SIGN).toString());
                } else if (!isEquationLabelEmpty) {
                    ResultPanel.equationLabel.setText(textIn.append(DIVISION_SIGN).toString());
                }
                break;
            case "*":
                if (!isEquationLabelEmpty && isLastSignAnOperator) {
                    ResultPanel.equationLabel.setText(textIn.replace(textIn.length()-1,textIn.length(),MULTIPLICATION_SIGN).toString());
                } else if (!isEquationLabelEmpty) {
                    ResultPanel.equationLabel.setText(textIn.append(MULTIPLICATION_SIGN).toString());
                }
                break;
            case "clear":
                ResultPanel.equationLabel.setText("");
                ResultPanel.resultLabel.setText("0");
                break;
            case ".":
                ResultPanel.equationLabel.setText(textIn.append(".").toString());
                break;

            case "delete":
                try {
                    ResultPanel.equationLabel.setText(textIn.deleteCharAt(textIn.length() - 1).toString());
                } catch (StringIndexOutOfBoundsException ignored) {};
                break;
            case "=":
                if (!isEquationLabelEmpty && isLastSignAnOperator) {
                    ResultPanel.equationLabel.setForeground(Color.RED.darker());
                } else if (!isEquationLabelEmpty) {
                    addToList(textIn);
                    makeCalculations();
                    String result = equationList.get(0);
                    result = format.format(Double.parseDouble(result));
                    result = result.replace(",", ".");
                    ResultPanel.resultLabel.setText(result);
                    equationList.clear();
                }
                break;
        }
    }

    public void addToList(StringBuilder text) {
        for (int i = 0; i < text.length(); i++) {
            String op = Character.toString(text.charAt(i));
            if (op.equals(ADDITION_SIGN) || op.equals(SUBTRACTION_SIGN) ||
                op.equals(MULTIPLICATION_SIGN) || op.equals(DIVISION_SIGN)) {
                equationList.add(text.substring(0, i));
                equationList.add(op);

                text.delete(0, i+1);
                addToList(text);
                break;
            }
            if (i == text.length()-1) equationList.add(text.toString());
        }
    }

    public void makeCalculations() {
        if (equationList.contains(DIVISION_SIGN)) {
            calc(DIVISION_SIGN);
            makeCalculations();
        } else if (equationList.contains(MULTIPLICATION_SIGN)) {
            calc(MULTIPLICATION_SIGN);
            makeCalculations();
        } else if (equationList.contains(ADDITION_SIGN) ||
                   equationList.contains(SUBTRACTION_SIGN)){
            calc(equationList.get(1));
            makeCalculations();
        }
    }

    public void calc(String sign) {
        int index = equationList.indexOf(sign);
        double num1 = Double.parseDouble(equationList.get(index-1));
        double num2 = Double.parseDouble(equationList.get(index+1));
        double result = 0;

        if (sign.equals(DIVISION_SIGN)) {
            if (num2 == 0) {
                ResultPanel.equationLabel.setForeground(Color.RED.darker());
                equationList.clear();
                equationList.add("0");
                return;
            } else {
                result = num1 / num2;
            }
        } else if (sign.equals(MULTIPLICATION_SIGN)) {
            result = num1 * num2;
        } else if (sign.equals(ADDITION_SIGN)) {
            result = num1 + num2;
        } else if (sign.equals(SUBTRACTION_SIGN)) {
            result = num1 - num2;
        }


        equationList.remove(index);
        equationList.set(index, String.valueOf(result));
        equationList.remove(index-1);
    }


}
