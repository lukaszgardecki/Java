package program.elements.buttons;

import program.settings.MyColor;

public class CheckButton extends Button{
    public CheckButton(String name) {
        super(name);
        setLocation(220, 300);
        setActionCommand("check");
        setBackground(MyColor.GREEN);

    }
}
