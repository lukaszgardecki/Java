package program.elements.buttons;

import program.elements.panels.MainPanel;
import program.settings.MyColor;

public class CheckButton extends Button{
    final int X = (MainPanel.WIDTH - WIDTH)/2;
    final int Y = 500;

    public CheckButton(String name) {
        super(name);
        setLocation(X, Y);
        setActionCommand("check");
        setBackground(MyColor.GREEN);
    }
}
