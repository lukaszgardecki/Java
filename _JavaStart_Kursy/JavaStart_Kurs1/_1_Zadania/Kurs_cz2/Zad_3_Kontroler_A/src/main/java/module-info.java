module Zad_3_Kontroler_A {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports excercise to javafx.graphics;
    opens  excercise to javafx.fxml;
}