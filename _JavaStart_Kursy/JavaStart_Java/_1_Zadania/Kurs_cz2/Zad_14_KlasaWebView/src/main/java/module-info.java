module Zad_14_KlasaWebView {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    exports pl.javastart.fxbrowser to javafx.graphics;
    opens pl.javastart.fxbrowser to javafx.fxml;
}