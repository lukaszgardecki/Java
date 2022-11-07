package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class MainController {
    @FXML
    private MenuPaneController menuPaneController;
    @FXML
    private ContentPaneController contentPaneController;
    @FXML
    private ControlPaneController controlPaneController;


    private Slider volumeSlider = controlPaneController.getVolumeSlider();
    private Slider progressSlider = controlPaneController.getProgressSlider();
    private Button previousButton = controlPaneController.getPreviousButton();
    private Button nextButton = controlPaneController.getNextButton();
    private ToggleButton playButton = controlPaneController.getPlayButton();
    private MenuItem fileMenuItem = menuPaneController.getFileMenuItem();
    private MenuItem dirMenuItem = menuPaneController.getDirMenuItem();
    private MenuItem closeMenuItem = menuPaneController.getCloseMenuItem();
    private MenuItem aboutMenuItem = menuPaneController.getAboutMenuItem();



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
