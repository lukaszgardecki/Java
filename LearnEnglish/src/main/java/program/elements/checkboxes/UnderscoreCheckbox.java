package program.elements.checkboxes;

import program.settings.Click;
import program.settings.MyColor;

import javax.swing.*;

public class UnderscoreCheckbox extends JCheckBox {


    public UnderscoreCheckbox() {
        setSize(20, 20);
        setBackground(MyColor.BLUE);
        setActionCommand("showHide");
        addActionListener(new Click());
        setVisible(true);
    }
}
