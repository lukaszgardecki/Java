package program.elements.text_fields;

import program.settings.KeyPress;

public class TranslateTextField extends TextField {
    public TranslateTextField(String name) {
        super(name);
        setLocation(130, 260);
        addKeyListener(new KeyPress());
    }
}
