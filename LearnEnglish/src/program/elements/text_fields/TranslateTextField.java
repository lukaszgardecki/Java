package program.elements.text_fields;

import program.settings.KeyPress;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TranslateTextField extends TextField {
    public TranslateTextField(String name) {
        super(name);
        setLocation(130, 260);
        //setText("Tłumaczenie");

        addKeyListener(new KeyPress());
//        addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (getText().equals("Tłumaczenie")) {
//                    setText("");
//                    setForeground(Color.BLACK);
//                }
//            }
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (getText().isEmpty()) {
//                    setForeground(Color.GRAY);
//                    setText("Tłumaczenie");
//                }
//            }
//        });
    }
}
