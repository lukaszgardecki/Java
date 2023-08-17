package wzorce.abstractfactory.os.win;

import wzorce.abstractfactory.os.components.Button;

public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Win Button");
    }
}
