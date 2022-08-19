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
    final String MULTIPLICATION_SIGN = Character.toString('\u00D7');
    final String DIVISION_SIGN = Character.toString('\u00F7');
    final String SQUARE_ROOT_SIGN = Character.toString('\u221A');
    final String PLUS_MINUS_SIGN = Character.toString('\u00B1');
    final String POWER_2_SIGN = "x\u00B2";
    final String POWER_Y_SIGN = "x\u02B8";
    ArrayList<String> equationList = new ArrayList<>();
    DecimalFormat format = new DecimalFormat("0.##########");
    StringBuilder textIn;
    boolean isEquationLabelEmpty;
    boolean isLastSignAnOperator;
    boolean isLastSignNumeric;

    public KeyPanel() {
        setBounds(5,175,341,340);
        setBackground(Calculator.backgroundColor);
        setLayout(new GridLayout(6, 4, 3, 2));

        Key key1 = new NumberKey("1", "One", this);
        Key key2 = new NumberKey("2", "Two", this);
        Key key3 = new NumberKey("3", "Three", this);
        Key key4 = new NumberKey("4", "Four", this);
        Key key5 = new NumberKey("5", "Five", this);
        Key key6 = new NumberKey("6", "Six", this);
        Key key7 = new NumberKey("7", "Seven", this);
        Key key8 = new NumberKey("8", "Eight", this);
        Key key9 = new NumberKey("9", "Nine", this);
        Key key0 = new NumberKey("0", "Zero", this);
        Key keyDot = new NumberKey(".", "Dot", this);
        Key keyPlusMinus = new NumberKey(PLUS_MINUS_SIGN, "PlusMinus", this);

        Key keyPlus = new OperatorKey(ADDITION_SIGN, "Add", this);
        Key keyMinus = new OperatorKey(SUBTRACTION_SIGN, "Subtract", this);
        Key keyMult = new OperatorKey(MULTIPLICATION_SIGN, "Multiply", this);
        Key keyDiv = new OperatorKey(DIVISION_SIGN, "Divide", this);
        Key keyPowerTwo = new OperatorKey(POWER_2_SIGN, "PowerTwo", this);
        Key keyPowerY = new OperatorKey(POWER_Y_SIGN, "PowerY", this);
        Key keySquareRoot = new OperatorKey(SQUARE_ROOT_SIGN, "SquareRoot", this);
        Key keyParentheses = new OperatorKey("( )", "Parentheses", this);
        Key keyClear = new OperatorKey("C", "Clear", this);
        Key keyClearEverything = new OperatorKey("CE", "ClearEverything", this);
        Key keyDelete = new OperatorKey("Del", "Delete", this);

        Key keyEqual = new EqualsKey("=", "Equals", this);

        add(keyParentheses);
        add(keyClearEverything);
        add(keyClear);
        add(keyDelete);
        add(keyPowerTwo);
        add(keyPowerY);
        add(keySquareRoot);
        add(keyDiv);
        add(key7);
        add(key8);
        add(key9);
        add(keyMult);
        add(key4);
        add(key5);
        add(key6);
        add(keyMinus);
        add(key1);
        add(key2);
        add(key3);
        add(keyPlus);
        add(keyPlusMinus);
        add(key0);
        add(keyDot);
        add(keyEqual);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String event = ae.getActionCommand();
        String lastSign = "";
        ResultPanel.equationLabel.setForeground(Color.GREEN.darker());
        textIn = new StringBuilder(ResultPanel.equationLabel.getText());
        isEquationLabelEmpty = textIn.toString().equals("");
        isLastSignAnOperator = false;

        if(!isEquationLabelEmpty) {
            lastSign = String.valueOf(textIn.charAt(textIn.length() - 1));
            isLastSignAnOperator = lastSign.equals(ADDITION_SIGN) ||
                                   lastSign.equals(SUBTRACTION_SIGN) ||
                                   lastSign.equals(DIVISION_SIGN) ||
                                   lastSign.equals(MULTIPLICATION_SIGN);
            isLastSignNumeric = Character.isDigit(lastSign.charAt(0));
        }



        switch (event) {
            case "One":
                ResultPanel.equationLabel.setText(textIn.append("1").toString());
                break;
            case "Two":
                ResultPanel.equationLabel.setText(textIn.append("2").toString());
                break;
            case "Three":
                ResultPanel.equationLabel.setText(textIn.append("3").toString());
                break;
            case "Four":
                ResultPanel.equationLabel.setText(textIn.append("4").toString());
                break;
            case "Five":
                ResultPanel.equationLabel.setText(textIn.append("5").toString());
                break;
            case "Six":
                ResultPanel.equationLabel.setText(textIn.append("6").toString());
                break;
            case "Seven":
                ResultPanel.equationLabel.setText(textIn.append("7").toString());
                break;
            case "Eight":
                ResultPanel.equationLabel.setText(textIn.append("8").toString());
                break;
            case "Nine":
                ResultPanel.equationLabel.setText(textIn.append("9").toString());
                break;
            case "Zero":
                ResultPanel.equationLabel.setText(textIn.append("0").toString());
                break;
            case "Subtract":
                formatEquationLabel(SUBTRACTION_SIGN);
                break;
            case "Add":
                formatEquationLabel(ADDITION_SIGN);
                break;
            case "Divide":
                formatEquationLabel(DIVISION_SIGN);
                break;
            case "Multiply":
                formatEquationLabel(MULTIPLICATION_SIGN);
                break;
            case "Clear":
                ResultPanel.equationLabel.setText("");
                ResultPanel.resultLabel.setText("0");
                break;
            case "Dot":
                if(!lastSign.equals(".")) {
                    ResultPanel.equationLabel.setText(textIn.append(".").toString());
                }
                break;
            case "Delete":
                try {
                    ResultPanel.equationLabel.setText(textIn.deleteCharAt(textIn.length() - 1).toString());
                } catch (StringIndexOutOfBoundsException ignored) {}
                break;
            case "PlusMinus":

                break;
            case "Parentheses":
                int leftCounter = 0;
                int rightCounter = 0;

                for(int i = 0; i < textIn.length(); i++) {
                    if (textIn.toString().charAt(i) == '(') leftCounter++;
                    if (textIn.toString().charAt(i) == ')') rightCounter++;
                }

                if (textIn.length() == 0 || isLastSignAnOperator || lastSign.equals("(")) {
                    ResultPanel.equationLabel.setText(textIn.append("(").toString());
                } else if (leftCounter == rightCounter && (isLastSignNumeric || lastSign.equals(")"))) {
                    ResultPanel.equationLabel.setText(textIn.append(MULTIPLICATION_SIGN).append("(").toString());
                } else {
                    ResultPanel.equationLabel.setText(textIn.append(")").toString());
                }
                break;
            case "PowerTwo":

                break;
            case "PowerY":

                break;
            case "SquareRoot":
                ResultPanel.equationLabel.setText(textIn.append(SQUARE_ROOT_SIGN).append("(").toString());
                break;
            case "ClearEverything":

                break;
            case "Equals":

                equationList.clear();

                if (!isEquationLabelEmpty && isLastSignAnOperator) {
                    ResultPanel.equationLabel.setForeground(Color.RED.darker());
                } else if (!isEquationLabelEmpty) {

                    System.out.println( textIn);

                    addToList(textIn);

                    System.out.println("---------------------------------------------------");
                    System.out.println("to jest lista startowa:\n" + equationList);

                    makeCalculations(equationList);

                    String result = equationList.toString()
                            .replace("(", "")
                            .replace(")", "")
                            .replace("[", "")
                            .replace("]", "")
                            .replace(", ", "");

                    System.out.println("lista koñcowa equationList:\n" + result);

                    //String result = equationList.get(0);
                    result = format.format(Double.parseDouble(result));
                    result = result.replace(",", ".");
                    ResultPanel.resultLabel.setText(result);

                }
                break;
        }
    }


    /*
        Adding each element of the equation to the equationList
     */
    public void addToList(StringBuilder text) {
        for (int i = 0; i < text.length(); i++) {
            String op = Character.toString(text.charAt(i));

            if (op.equals("(")) {
                equationList.add(op);
                text.delete(0, i+1);
                addToList(text);
                break;
            } else if (op.equals(")")) {
                if (i != 0) {
                    equationList.add(text.substring(0, i));
                }
                equationList.add(op);
                text.delete(0, i+1);
                addToList(text);
                break;
            } else if (op.equals(ADDITION_SIGN) || op.equals(SUBTRACTION_SIGN) ||
                op.equals(MULTIPLICATION_SIGN) || op.equals(DIVISION_SIGN)) {
                if (i != 0) {
                    equationList.add(text.substring(0, i));
                }
                equationList.add(op);
                text.delete(0, i+1);
                addToList(text);
                break;
            }


            System.out.println("ostatni element, który powinien byæ dodany do listy to: " + text);

            if (i == text.length()-1) equationList.add(text.substring(0));
        }
    }

    public void makeCalculations(ArrayList<String> list) {
        if (list.contains(DIVISION_SIGN)) {
            calculate(list, DIVISION_SIGN);

            System.out.println("najpierw zrobiê dzielenie. lista po calculate:\n" + list);

            makeCalculations(list);

            System.out.println("to jest list po drugim makecalc:\n" + list);


        } else if (list.contains(MULTIPLICATION_SIGN)) {
            calculate(list, MULTIPLICATION_SIGN);
            System.out.println("najpierw zrobiê mno¿enie. lista po calculate:\n" + list);

            makeCalculations(list);
            System.out.println("to jest list po drugim makecalc:\n" + list);
        } else if (list.contains(ADDITION_SIGN) || list.contains(SUBTRACTION_SIGN)){
            int idexOfFirstSign;

            idexOfFirstSign = Math.min(list.indexOf(ADDITION_SIGN), list.indexOf(SUBTRACTION_SIGN));

            if (!list.contains(ADDITION_SIGN)) {
                idexOfFirstSign = list.indexOf(SUBTRACTION_SIGN);
            } else if (!list.contains(SUBTRACTION_SIGN)) {
                idexOfFirstSign = list.indexOf(ADDITION_SIGN);
            }

            System.out.println("first index to: " + idexOfFirstSign);


            String firstSign = list.get(idexOfFirstSign);

            System.out.println("pierwszy znak to " + firstSign);

            calculate(list, firstSign);

            System.out.println("najpierw zrobiê dodawanie/odejmowanie. lista po calculate:\n" + list);
            makeCalculations(list);
            System.out.println("to jest list po drugim makecalc:\n" + list);
        }

        if (list.size() == 3 && list.get(0).equals("(") && list.get(2).equals(")")) {
            list.remove(0);
            list.remove(1);
        }

//        else if (list.contains(SUBTRACTION_SIGN)) {
//            calculate(list, SUBTRACTION_SIGN);
//            System.out.println("odejmowanie. lista po calculate:\n" + list);
//            makeCalculations(list);
//        }
    }

    public void calculate(ArrayList<String> list, String sign) {

        System.out.println("lista, która wesz³a do calculate:\n" + list);

        int index = list.indexOf(sign);

       // System.out.println(equationList);


        //double num1 = Double.parseDouble(equationList.get(index-1));
        //double num2 = Double.parseDouble(equationList.get(index+1));
        double num1 = findNum("left", index, list);

        int index2 = list.indexOf(sign);
        double num2 = findNum("right", index2, list);

        double result = 0;

        if (sign.equals(DIVISION_SIGN)) {
            if (num2 == 0) {
                ResultPanel.equationLabel.setForeground(Color.RED.darker());
                list.clear();
                list.add("0");
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

        boolean isParenthesisAtLeft;
        try {
            isParenthesisAtLeft = list.get(index2 - 2).equals("(");
        } catch (IndexOutOfBoundsException e) {
            isParenthesisAtLeft = false;
        }

        boolean isParenthesisAtRight;
        try {
            isParenthesisAtRight = list.get(index2 + 2).equals(")");
        } catch (IndexOutOfBoundsException e) {
            isParenthesisAtRight = false;
        }

        list.remove(index2);
        list.set(index2, String.valueOf(result));
        list.remove(index2-1);

        if(isParenthesisAtLeft && isParenthesisAtRight) {
            list.remove(index2-2);
            list.remove(index2-1);
        }

//        System.out.println(list);
//        list.removeAll(Collections.singleton("("));
//        list.removeAll(Collections.singleton(")"));
        //System.out.println("to jest lista pod koniec kalkulate:\n" + list);
        //makeCalculations(list);


    }

    public void formatEquationLabel(String sign) {
        String text = textIn.toString();
        if (text.startsWith(".") || text.contains(ADDITION_SIGN + ".") || text.contains(SUBTRACTION_SIGN + ".") || text.contains(MULTIPLICATION_SIGN + ".") || text.contains(DIVISION_SIGN + ".")) {
            int index = textIn.lastIndexOf(".");
            textIn.replace(index, index+1, "0.");
        } else if (text.endsWith(".")) {
            int index = textIn.lastIndexOf(".");
            textIn.replace(index, index+1, ".0");
        }

        if (!isEquationLabelEmpty && isLastSignAnOperator) {
            ResultPanel.equationLabel.setText(textIn.replace(textIn.length()-1,textIn.length(),sign).toString());
        } else if (!isEquationLabelEmpty) {
            ResultPanel.equationLabel.setText(textIn.append(sign).toString());
        }
    }

    public double findNum(String side, int index, ArrayList<String> list) {

        System.out.println("teraz sprawdzê stronê: " + side + ", index: " + index + " lista, która wesz³a do findNum:\n" + list);


        boolean isSignANum;
        String sign = "";
        double num = 0;
        int counter1 = 0;
        int counter2 = 0;
        if (side.equals("left")) sign = list.get(index-1);
        if (side.equals("right")) sign = list.get(index+1);


        isSignANum = !sign.equals("(") && !sign.equals(")") && !sign.equals(ADDITION_SIGN) && !sign.equals(SUBTRACTION_SIGN) && !sign.equals(MULTIPLICATION_SIGN) && !sign.equals(DIVISION_SIGN);

        //System.out.println(index);
       // System.out.println(isSignANum);

        if (isSignANum) {
            num = Double.parseDouble(sign);
        } else {
            if (side.equals("right")) {
                int startIndex = index+1;
                int endIndex;
                for (int i = startIndex; ;i++) {
                    if (list.get(i).equals("(")) {
                        counter1++;
                    }
                    if (list.get(i).equals(")")) counter2++;
                    if (counter1 == counter2) {
                        endIndex = i;
                        break;
                    }
                }
                ArrayList<String> tempList = new ArrayList<>(list.subList(startIndex, endIndex+1));

                System.out.println(tempList);

                makeCalculations(tempList);

                StringBuilder tempSb = new StringBuilder();
                for (String s : tempList) {
                    tempSb.append(s);
                }
                for (int k = startIndex; k < endIndex; k++) {
                    list.remove(startIndex);
                }
                list.set(startIndex, tempSb.toString());


                //System.out.println(tempSb);
                num = Double.parseDouble(tempSb.toString());

            }
            if (side.equals("left")) {
                int startIndex;
                int endIndex = index-1;
                for (int i = endIndex; ;i--) {
                    if (list.get(i).equals("(")) counter1++;
                    if (list.get(i).equals(")")) counter2++;
                    if (counter1 == counter2) {
                        startIndex = i;
                        break;
                    }
                }
                ArrayList<String> tempList = new ArrayList<>(list.subList(startIndex, index));

                //System.out.println(tempList);

                makeCalculations(tempList);

                StringBuilder tempSb = new StringBuilder();
                for (String s : tempList) {
                    tempSb.append(s);
                }
                for (int k = startIndex; k < endIndex; k++) {
                    list.remove(startIndex);
                }



                list.set(startIndex, tempSb.toString());


                num = Double.parseDouble(tempSb.toString());


            }

        }
        return num;
    }
}
