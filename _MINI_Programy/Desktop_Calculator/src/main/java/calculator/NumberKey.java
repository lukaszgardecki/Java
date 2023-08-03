package calculator;

import java.awt.*;
import java.awt.event.ActionListener;

public class NumberKey extends Key {

    public NumberKey(String text, String name, ActionListener actionListener) {
        super(text, name, actionListener);
        setBackground(new Color(253, 253, 253));
    }
}
