module Zad_4_Zdarzenia_A{
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.kurs.fxaction.main to javafx.graphics;
    opens pl.kurs.fxaction.controller to javafx.fxml;
}