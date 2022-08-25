package program.elements.text_fields;

import program.settings.KeyPress;

import java.awt.*;

public class TranslateTextField extends TextField {
    public TranslateTextField(String name) {
        super(name);
        setLocation(55, 260);
        setSize(450, 35);
        addKeyListener(new KeyPress());
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
    }
}
