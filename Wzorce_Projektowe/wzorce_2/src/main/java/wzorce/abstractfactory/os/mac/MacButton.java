package wzorce.abstractfactory.os.mac;

import wzorce.abstractfactory.os.components.Button;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac Button");
    }
}
