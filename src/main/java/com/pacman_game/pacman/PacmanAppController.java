package com.pacman_game.pacman;

import com.pacman_game.common.Tile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.shape.Circle;


import com.pacman_game.game.Maze_cfg;
import com.pacman_game.game.MazeMap;


public class PacmanAppController {
    @FXML
    GridPane maze = new GridPane();
    public void moveUp()
    {
        System.out.println("MOVIN' UP");
    }
    public void moveDown()
    {
        System.out.println("MOVIN' DOWN");
    }
    public void moveRight()
    {
        System.out.println("MOVIN' RIGHT");
    }
    public void moveLeft()
    {
        System.out.println("MOVIN' LEFT");
    }

}