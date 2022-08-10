package four;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static four.ConnectFour.COLS;
import static four.ConnectFour.ROWS;

public class ButtonReset extends JButton implements ActionListener {
    public ButtonReset () {
        setBounds(570,17,100,25);
        setActionCommand("res");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("res")) {
            Cell.clearBoard();
        }
    }
}
