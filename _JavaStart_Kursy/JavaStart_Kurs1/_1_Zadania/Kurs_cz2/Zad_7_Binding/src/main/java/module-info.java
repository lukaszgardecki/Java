module Zad_7_Binding {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.javastart.fxproperties.main to javafx.graphics;
    opens pl.javastart.fxproperties.controller to javafx.fxml;
}