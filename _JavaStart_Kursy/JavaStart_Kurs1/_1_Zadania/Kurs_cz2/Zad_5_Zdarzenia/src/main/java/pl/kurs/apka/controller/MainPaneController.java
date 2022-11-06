package pl.kurs.apka.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;

public class MainPaneController {

    @FXML
    private Button clearButton;

    @FXML
    private TextArea leftTextArea;

    @FXML
    private TextArea rightTextArea;


    public void initialize() {
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
