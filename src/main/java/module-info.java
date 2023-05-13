module com.pacman_game.pacman_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pacman_game.pacman to javafx.fxml;
    exports com.pacman_game.pacman;
}