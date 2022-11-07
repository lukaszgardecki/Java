package pl.kurs.apka.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TextPaneController {
    @FXML
    private TextArea leftTextArea;
    @FXML
    private TextArea rightTextArea;

    public TextArea getLeftTextArea() {
        return leftTextArea;
    }

    public TextArea getRightTextArea() {
        return rightTextArea;
    }
}
