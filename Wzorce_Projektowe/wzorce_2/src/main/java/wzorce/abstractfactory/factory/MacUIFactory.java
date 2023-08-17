package wzorce.abstractfactory.factory;

import wzorce.abstractfactory.os.components.Button;
import wzorce.abstractfactory.os.components.CheckBox;
import wzorce.abstractfactory.os.mac.MacButton;
import wzorce.abstractfactory.os.mac.MacCheckBox;

public class MacUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
