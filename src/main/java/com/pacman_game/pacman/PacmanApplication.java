package com.pacman_game.pacman;

import com.pacman_game.game.*;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
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
                        showRewatch(stage);
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
    public void showRewatch(Stage stage) {
        final JFrame frame = new JFrame("Open File Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser fc = new JFileChooser();
        File file = null;
        if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        RewatchUi rewatchUi = new RewatchUi(this, file);
        Scene scene = new Scene(rewatchUi.getRoot(rewatchUi.maps.get(0)));
        RewatchContoller rewatchContoller = new RewatchContoller(rewatchUi);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent)
            {
                switch (keyEvent.getCode())
                {
                    case Q:
                        rewatchContoller.renderPrevious();
                        break;
                    case E:
                        rewatchContoller.renderNext();
                        break;
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }
    public void showGame(Stage stage) {
        final JFrame frame = new JFrame("Open File Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFileChooser fc = new JFileChooser();
        File file = null;
        if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
        }
        boolean record = false;
        GameScene gameScene = new GameScene(this, file);
        Scene scene = new Scene(gameScene.rerender(gameScene.map));
        PacmanAppController appController = new PacmanAppController(gameScene);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
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
                    case R:
                        appController.gameIsLoggedNow(true);
                        break;
                    case P:
                        appController.gameIsLoggedNow(false);
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