module Zad_5_Zdarzenia{
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports pl.kurs.apka.main to javafx.graphics;
    opens pl.kurs.apka.controller to javafx.fxml;
}