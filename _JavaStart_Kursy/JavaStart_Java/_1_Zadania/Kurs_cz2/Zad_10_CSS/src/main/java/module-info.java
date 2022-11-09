module Zad_10_CSS {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports org.example.app to javafx.graphics;
    opens org.example.controller to javafx.fxml;
}