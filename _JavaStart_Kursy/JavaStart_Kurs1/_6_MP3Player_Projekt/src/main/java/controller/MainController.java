package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private TableView<?> contentTable;

    @FXML
    private MenuItem dirMenuItem;

    @FXML
    private MenuItem fileMenuItem;

    @FXML
    private Button nextButton;

    @FXML
    private ToggleButton playButton;

    @FXML
    private Button previousButton;

    @FXML
    private Slider progressSlider;

    @FXML
    private Slider volumeSlider;

    public void initialize() {
        System.out.println("MainController created");
    }
}
