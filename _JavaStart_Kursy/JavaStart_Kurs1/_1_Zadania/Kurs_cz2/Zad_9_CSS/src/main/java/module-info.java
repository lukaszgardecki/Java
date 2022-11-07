module Zad_9_CSS {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.javastart.fxcss.app to javafx.graphics;
    opens pl.javastart.fxcss.controller to javafx.fxml;
}