package pl.kurs.apka.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class MainPaneController {

    @FXML
    private Button clearButton;
    @FXML
    private TextPaneController textPaneController;

    public void initialize() {
        TextArea leftTextArea = textPaneController.getLeftTextArea();
        TextArea rightTextArea = textPaneController.getRightTextArea();

        leftTextArea.addEventFilter(KeyEvent.KEY_RELEASED,
                event -> reverseTextHandler(leftTextArea, rightTextArea)
        );
        rightTextArea.addEventFilter(KeyEvent.KEY_RELEASED,
                event -> reverseTextHandler(rightTextArea, leftTextArea)
        );

        clearButton.setOnAction(event -> {
            leftTextArea.clear();
            rightTextArea.clear();
        });
    }

    private void reverseTextHandler(TextArea source, TextArea target) {
        StringBuilder sb = new StringBuilder(source.getText());
        target.setText(sb.reverse().toString());
    }
}
