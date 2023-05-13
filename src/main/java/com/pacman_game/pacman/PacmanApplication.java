package com.pacman_game.pacman;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

public class PacmanApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        PacmanAppController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);

        TilePane grid = new TilePane();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                // Create a new cell and set its properties
                StackPane cell = new StackPane();
                cell.setPrefSize(50, 50); // Set the size of the cell
                cell.setStyle("-fx-background-color: black;"); // Set the background color of the cell

                // Add the cell to the grid
                grid.getChildren().add(cell);
            }
        }



        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode())
                {
                    case UP:
                        controller.moveUp();
                        break;
                    case DOWN:
                        controller.moveDown();
                        break;
                    case RIGHT:
                        controller.moveRight();
                        break;
                    case LEFT:
                        controller.moveLeft();
                        break;
                    default:
                        break;
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}