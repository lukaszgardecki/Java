package pl.kursprojekt.mp3player.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPaneController {
    @FXML
    private MenuItem fileMenuItem;
    @FXML
    private MenuItem dirMenuItem;
    @FXML
    private MenuItem closeMenuItem;
    @FXML
    private MenuItem aboutMenuItem;

    public MenuItem getFileMenuItem() {
        return fileMenuItem;
    }

    public MenuItem getDirMenuItem() {
        return dirMenuItem;
    }

    public MenuItem getCloseMenuItem() {
        return closeMenuItem;
    }

    public MenuItem getAboutMenuItem() {
        return aboutMenuItem;
    }

    public void initialize() {
        configureMenu();
    }

    private void configureMenu() {
        closeMenuItem.setOnAction(action -> Platform.exit());

        aboutMenuItem.setOnAction(event -> {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/fxml/aboutPane.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setTitle("Mp3Player v1.0 - about");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
