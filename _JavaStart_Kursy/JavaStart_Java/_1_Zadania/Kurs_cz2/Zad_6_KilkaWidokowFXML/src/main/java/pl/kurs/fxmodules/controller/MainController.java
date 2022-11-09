package pl.kurs.fxmodules.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainController {

    @FXML
    private ContentPaneController contentPaneController;
    @FXML
    private ControlPaneController controlPaneController;

    public void initialize() {
        //pobieramy wszystkie kontrolki
        Button lowerCaseButton = controlPaneController.getLowerCaseButton();
        Button upperCaseButton = controlPaneController.getUpperCaseButton();
        TextArea textArea = contentPaneController.getMainTextArea();

        lowerCaseButton.setOnAction(event -> textArea.setText(textArea.getText().toLowerCase()));
        upperCaseButton.setOnAction(event -> textArea.setText(textArea.getText().toUpperCase()));
    }
}
