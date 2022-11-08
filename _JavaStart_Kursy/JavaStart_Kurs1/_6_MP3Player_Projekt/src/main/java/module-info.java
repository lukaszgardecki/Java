module _6_MP3Player.Projekt {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jid3lib;

    exports pl.kursprojekt.mp3player.main to javafx.graphics;
    opens pl.kursprojekt.mp3player.controller to javafx.fxml;
    opens pl.kursprojekt.mp3player.mp3 to javafx.base;
}
