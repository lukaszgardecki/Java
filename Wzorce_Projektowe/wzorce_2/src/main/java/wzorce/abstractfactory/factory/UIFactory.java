package wzorce.abstractfactory.factory;

import wzorce.abstractfactory.os.components.Button;
import wzorce.abstractfactory.os.components.CheckBox;

public interface UIFactory {

    Button createButton();
    CheckBox createCheckBox();
}
