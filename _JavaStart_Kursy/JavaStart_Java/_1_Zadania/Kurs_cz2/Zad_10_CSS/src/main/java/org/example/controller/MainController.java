package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private Button clearButton;

    @FXML
    private TextArea mainTextArea;


    public void initialize() {
        clearButton.setOnAction(x -> mainTextArea.clear());
    }

}
