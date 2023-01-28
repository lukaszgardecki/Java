package program.elements.text_fields;

import program.elements.panels.MainPanel;
import program.settings.KeyPress;

import java.awt.*;

public class TranslateTextField extends TextField {

    final int WIDTH = 450;
    final int HEIGHT = 35;
    final int X = (MainPanel.WIDTH - WIDTH)/2;
    final int Y = 450;

    public TranslateTextField(String name) {
        super(name);
        setLocation(X, Y);
        setSize(WIDTH, HEIGHT);
        addKeyListener(new KeyPress());
        setFont(new Font(Font.MONOSPACED, Font.BOLD, 18));
    }
}
