package excercise;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ExampleController {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    public void initialize() {
        label1.setText("zmieniony tekst1");
        label2.setText("a tu nie wiem");
        
    }
}
