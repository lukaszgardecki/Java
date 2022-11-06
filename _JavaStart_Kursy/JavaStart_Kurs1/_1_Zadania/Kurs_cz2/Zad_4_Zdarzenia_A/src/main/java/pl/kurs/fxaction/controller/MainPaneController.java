package pl.kurs.fxaction.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class MainPaneController {

    @FXML
    private TextArea mainTextArea;
    @FXML
    private Button lowerCaseButton;

    public void initialize() {
        // Obs�uga zdarzenia z guzika:
//        lowerCaseButton.addEventFilter(
//                ActionEvent.ACTION,
//                actionEvent -> mainTextArea.setText(mainTextArea.getText().toLowerCase())
//        );

//        mainTextArea.setOnKeyPressed(keyEvent -> System.out.println("Wci�ni�to"));
//        mainTextArea.setOnKeyReleased(keyEvent -> System.out.println("zwolniono "));
//        mainTextArea.setOnKeyTyped(keyEvent -> System.out.println("wci�ni�to i zwolniono"));

//        mainTextArea.addEventFilter(
//                KeyEvent.KEY_TYPED,
//                keyEvent -> System.out.println("wci�ni�to i zwolniono")
//        );

        

        mainTextArea.addEventFilter(
                MouseEvent.MOUSE_PRESSED,
                mouseEvent -> System.out.println("Wci�ni�to przycisk myszy")
        );
        mainTextArea.addEventFilter(
                MouseEvent.MOUSE_RELEASED,
                mouseEvent -> System.out.println("Zwolniono przycisk myszy")
        );
        mainTextArea.addEventFilter(
                MouseEvent.MOUSE_CLICKED,
                mouseEvent -> System.out.println("Klikni�to przycisk myszy")
        );

        mainTextArea.addEventFilter(
                MouseEvent.MOUSE_ENTERED,
                mouseEvent -> System.out.println("Najechano na pole tekstowe")
        );
        mainTextArea.addEventFilter(
                MouseEvent.MOUSE_EXITED,
                mouseEvent -> System.out.println("Wyjechano poza pole tekstowe")
        );
//        mainTextArea.addEventFilter(
//                MouseEvent.MOUSE_MOVED,
//                mouseEvent -> System.out.println("Poruszanie si� nad polem tekstowym")
//        );
//        mainTextArea.addEventFilter(
//                MouseEvent.MOUSE_DRAGGED,
//                mouseEvent -> System.out.println("Poruszanie si� nad polem tekstowym z wci�ni�tym przyciskiem myszy")
//        );


    }

//    @FXML
//    private void toLowerCaseAction(ActionEvent event) {
//        mainTextArea.setText(mainTextArea.getText().toLowerCase());
//    }
}
