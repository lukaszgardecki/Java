package calculator;

import java.awt.*;
import java.awt.event.ActionListener;

public class OperatorKey extends Key{

    public OperatorKey(String text, String name, ActionListener actionListener) {
        super(text, name, actionListener);
        setBackground(new Color(219, 219, 219));
    }
}
