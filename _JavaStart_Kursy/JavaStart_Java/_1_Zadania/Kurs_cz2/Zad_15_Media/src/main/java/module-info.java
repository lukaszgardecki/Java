module Zad_15_Media {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    exports pl.javastart.fxmedia to javafx.graphics;
    opens pl.javastart.fxmedia to javafx.fxml;
}