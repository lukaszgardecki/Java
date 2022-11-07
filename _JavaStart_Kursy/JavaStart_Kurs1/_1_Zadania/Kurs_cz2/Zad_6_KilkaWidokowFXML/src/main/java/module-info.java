module Zad_6_KilkaWidokowFXML {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.kurs.fxmodules.main to javafx.graphics;
    opens  pl.kurs.fxmodules.controller to javafx.fxml;
}