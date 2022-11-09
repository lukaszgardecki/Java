package pl.javastart.fxproperties.controller;

import javafx.beans.binding.StringBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class VolumeController {

    @FXML
    private Label volumeLevelLabel;

    @FXML
    private Slider volumeSlider;


    public void initialize() {
        StringBinding stringBinding = volumeSlider.valueProperty().asString();
        volumeLevelLabel.textProperty().bind(stringBinding);

        volumeSlider.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            double volume = (Double) newValue;
            if (volume > 75) System.out.println("Za g³oœno!");
            else if (volume < 10) System.out.println("Nic nie s³ychaæ");
        });
    }
}
