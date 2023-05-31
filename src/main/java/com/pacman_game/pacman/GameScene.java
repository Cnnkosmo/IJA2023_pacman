package com.pacman_game.pacman;

import com.pacman_game.common.Tile;
import com.pacman_game.game.Ghost;
import com.pacman_game.game.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import com.pacman_game.game.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Scene;

import static javafx.application.Platform.exit;

public class GameScene
{
    private PacmanApplication app;
    PacmanController pacmanController;
    ArrayList<GhostController> ghostControllers;
    Pacman pacman;
    ArrayList<Ghost> ghosts;
    MazeMap map;
    File log;
    ViewBoard view;

    GridPane maze;
    GameLogger logger;

    boolean isLogged;

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public GameScene (PacmanApplication app, File file)
    {
        this.app = app;
        Game game = new Game(file);
        this.map = game.getMap();
        this.pacman = game.createPacman(game.getMap());
        this.ghosts = game.createGhosts(game.getMap());
        this.pacmanController = new PacmanController(pacman, game.getMap());
        this.ghostControllers = game.setGhostControllers(ghosts, game.getMap());
        this.logger = new GameLogger(pacman,ghosts,map);
        this.view = new ViewBoard(pacman,ghosts,map);
        this.maze = new GridPane();

        maze.setGridLinesVisible(true);
        log = new File("log.txt");
        logger.logColsRows(pacman,ghosts,map);
    }


    public GridPane rerender(MazeMap map)
    {
        if (map.isEnd())
        {
            logger.createLogTxt();
            System.out.println("YOU'VE WIN :)");
            if (logger.logAllGame(pacman,ghosts))
            {
                exit();
            }
        }
        maze.getChildren().clear();
        for (int i = 0; i < map.map.length - 2; i++) {
            maze.getRowConstraints().add(new RowConstraints(40));
        }
        for (int i = 0; i < map.map[0].length - 2; i++) {
            maze.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (Tile[] row : map.map)
        {
            for (Tile item : row)
            {
                if (item instanceof Path)
                {
                    if (item.getRow() == pacman.getCurrentRow() && item.getColumn() == pacman.getCurrentCol())
                    {
                        Image image = new Image("file:../pacman_game/data/pacman.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());

                    }
                    else if (item.isFinish())
                    {
                        Image image = new Image("file:../pacman_game/data/key.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    }
                    else if (item.isKeyObject())
                    {
                        Image image = new Image("file:../pacman_game/data/apple.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    }
                    else
                    {//../pacman_game/src/main/resources/com/pacman_game/pacman/field.png
                        Image image = new Image("file:../pacman_game/data/field.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    }
                    }
                    else
                    {
                    Image image = new Image("file:../pacman_game/data/wall2.png");
                    ImageView view = new ImageView(image);
                    view.setFitHeight(40);
                    view.setFitWidth(40);
                    maze.add(view, item.getColumn(), item.getRow());
                }
            }
        }
        for (Ghost ghost : ghosts) {
            if (pacman.getCurrentCol() == ghost.getCurrentCol() && pacman.getCurrentRow() == ghost.getCurrentRow()) {
                System.out.println("YOU'VE LOST :(");
                exit();
            }
            Image image = new Image("file:../pacman_game/data/ghost.png");
            ImageView view = new ImageView(image);
            view.setFitHeight(40);
            view.setFitWidth(40);
            maze.add(view, ghost.getCurrentCol(), ghost.getCurrentRow());


        }
        maze.setGridLinesVisible(true);
//        view.render(pacman,ghosts,map);
        return maze;
    }
}
