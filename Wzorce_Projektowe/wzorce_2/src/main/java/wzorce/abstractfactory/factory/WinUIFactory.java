package wzorce.abstractfactory.factory;

import wzorce.abstractfactory.os.components.Button;
import wzorce.abstractfactory.os.components.CheckBox;
import wzorce.abstractfactory.os.win.WinButton;
import wzorce.abstractfactory.os.win.WinCheckBox;

public class WinUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}
