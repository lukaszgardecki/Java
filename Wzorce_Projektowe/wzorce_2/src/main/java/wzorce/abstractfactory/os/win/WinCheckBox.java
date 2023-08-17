package wzorce.abstractfactory.os.win;

import wzorce.abstractfactory.os.components.CheckBox;

public class WinCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Win CheckBox");
    }
}
