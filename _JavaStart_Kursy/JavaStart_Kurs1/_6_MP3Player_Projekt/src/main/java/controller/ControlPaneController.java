package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class ControlPaneController {
    @FXML
    private Button previousButton;
    @FXML
    private ToggleButton playButton;
    @FXML
    private Button nextButton;
    @FXML
    private Slider volumeSlider;
    @FXML
    private Slider progressSlider;

    public void initialize() {
        System.out.println("ControlPane Controller created");
        configureButtons();
        configureVolume();
    }

    private void configureVolume() {
        volumeSlider.addEventFilter(MouseEvent.MOUSE_PRESSED,
                event -> System.out.println("Wciœniêto przycisk na suwaku g³oœnoœci"));
    }

    private void configureButtons() {
        previousButton.setOnAction(event -> System.out.println("Poprzednia piosenka"));
        nextButton.setOnAction(event -> System.out.println("Nastêpna piosenka"));
        playButton.setOnAction(event -> {
            if (playButton.isSelected()) {
                System.out.println("Play");
            } else {
                System.out.println("Stop");
            }
        });
    }


}
