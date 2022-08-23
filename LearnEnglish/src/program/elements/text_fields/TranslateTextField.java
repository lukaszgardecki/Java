package program.elements.text_fields;

import program.settings.KeyPress;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TranslateTextField extends TextField {
    public TranslateTextField() {
        setLocation(130, 260);
        setText("T³umaczenie");
        setForeground(Color.GRAY);
        addKeyListener(new KeyPress());
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals("T³umaczenie")) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(Color.GRAY);
                    setText("T³umaczenie");
                }
            }
        });
    }
}
