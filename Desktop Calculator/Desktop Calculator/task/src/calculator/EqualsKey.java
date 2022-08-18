package calculator;

import java.awt.*;
import java.awt.event.ActionListener;

public class EqualsKey extends Key {

    public EqualsKey(String text, String name, ActionListener actionListener) {
        super(text, name, actionListener);
        setBackground(new Color(175, 195, 221));
    }
}
