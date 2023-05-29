package com.pacman_game.pacman;

import com.pacman_game.game.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PacmanApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new AnchorPane());

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()){
                    case L:
                        showGui(stage);
                        break;
                    case G:
                        showGame(stage);
                        break;

                }
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public void showGui(Stage stage) {
        LoadGUI load = new LoadGUI(this);
        Scene scene = new Scene(load.getRoot());
        stage.setScene(scene);
        stage.show();
    }
    public void showGame(Stage stage) {
        GameScene gameScene = new GameScene(this);
        Scene scene = new Scene(gameScene.rerender());
        PacmanAppController appController = new PacmanAppController(gameScene);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode())
                {
                    case W:
                        appController.moveUp();
                        System.out.println("W");
                        break;
                    case D:
                        appController.moveRight();
                        System.out.println("D");
                        break;
                    case S:
                        appController.moveDown();
                        System.out.println("S");
                        break;
                    case A:
                        appController.moveLeft();
                        System.out.println("A");
                        break;
                }

            }
        });
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {

        launch(args);
    }
}