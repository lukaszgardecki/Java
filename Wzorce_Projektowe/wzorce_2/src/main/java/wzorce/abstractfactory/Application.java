package wzorce.abstractfactory;

import wzorce.abstractfactory.os.components.Button;
import wzorce.abstractfactory.os.components.CheckBox;
import wzorce.abstractfactory.factory.UIFactory;

public class Application {
    private final Button button;
    private final CheckBox checkBox;

    public Application(UIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint() {
        button.paint();
        checkBox.paint();
    }
}
