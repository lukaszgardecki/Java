package wzorce.abstractfactory.os.mac;

import wzorce.abstractfactory.os.components.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Mac CheckBox");
    }
}
