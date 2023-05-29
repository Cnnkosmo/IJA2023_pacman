package com.pacman_game.pacman;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LoadGUI
{
    private PacmanApplication app;

    public LoadGUI(PacmanApplication app)
    {
        this.app = app;
    }

    public VBox getRoot()
    {
        Button button = new Button("letsgo");

        VBox root = new VBox();
        root.getChildren().add(button);
        return root;
    }
}
