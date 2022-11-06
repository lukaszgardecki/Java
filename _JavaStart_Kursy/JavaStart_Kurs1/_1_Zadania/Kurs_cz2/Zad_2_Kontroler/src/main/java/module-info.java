module Zad_2_Kontroler {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports mvc to javafx.graphics;
    opens mvc to javafx.fxml;
}