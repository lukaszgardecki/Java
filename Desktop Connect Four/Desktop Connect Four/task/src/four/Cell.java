package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ClassLoadingMXBean;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

public class Cell extends JButton implements ActionListener {
    private static final Font FONT = new Font("Courier", Font.BOLD, 20);
    private static String currentSign = "X";
    static Map<String, Cell> map = new LinkedHashMap<>();

    public Cell (String label) {
        //super(label);
        setActionCommand("clicked");
        addActionListener(this);
        setName("Button" + label);
        setText(" ");
        setFont(FONT);
        setFocusPainted(false);

    }

    public static void setCurrentSign(String currentSign) {
        Cell.currentSign = currentSign;
    }





    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String a = actionEvent.getActionCommand();
        if (a.equals("clicked")) {

            String column = getName().substring(6,7); // -> num of column

            for (int i = 1; i <= 6; i++) {
                Cell aa = map.get(column+i);
                String text = aa.getText();
                if (text.equals(" ")) {
                    aa.setText(currentSign);
                    break;
                }
            }

            if (currentSign.equals("X")) {
                setCurrentSign("O");
            } else {
                setCurrentSign("X");
            }
        }
    }


}
