package mvc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Button loginButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;


    public void initialize() {
        usernameTextField.setText("Tekst");
    }

}