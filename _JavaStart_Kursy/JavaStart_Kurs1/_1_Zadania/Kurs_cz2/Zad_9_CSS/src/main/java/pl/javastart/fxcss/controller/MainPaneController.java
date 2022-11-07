package pl.javastart.fxcss.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainPaneController {

    @FXML
    private Button clearButton;

    @FXML
    private Button lowerCaseButton;

    @FXML
    private TextArea mainTextArea;

    @FXML
    private Button upperCaseButton;

    public void initialize() {
        upperCaseButton.setOnAction(x -> mainTextArea.setText(mainTextArea.getText().toUpperCase()));

        lowerCaseButton.setOnAction(x -> mainTextArea.setText(mainTextArea.getText().toLowerCase()));

        clearButton.setOnAction(x -> mainTextArea.clear());
    }

}
