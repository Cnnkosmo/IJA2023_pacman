package com.pacman_game.pacman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import com.pacman_game.game.PacmanController;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.AnchorPane;
import com.pacman_game.game.*;
import com.pacman_game.common.*;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;

import static javafx.application.Platform.exit;

public class PacmanAppController implements Initializable {
    PacmanController pacmanController;
    ArrayList<GhostController> ghostControllers;
    static final int cellSize = 40;
    Pacman pacman;
    ArrayList<Ghost> ghosts;
    MazeMap map;
    File log;
    ViewBoard view;
    public PacmanAppController() {
        Game game = new Game();
        this.map = game.getMap();
        this.pacman = game.createPacman(game.getMap());
        this.ghosts = game.createGhosts(game.getMap());
        this.pacmanController = new PacmanController(pacman, game.getMap());
        this.ghostControllers = game.setGhostControllers(ghosts, game.getMap());
        this.view = new ViewBoard(pacman,ghosts,map);
        log = new File("log.txt");
        this.Create_File();
    }

    public void Create_File()
    {
        try {
            log.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void moveUp() {
        pacmanController.update(Tile.Direction.U);
        ghostControllers.get(0).update(Tile.Direction.R);
        moveGhosts(ghostControllers);
        initialize(location, resources);
    }

    public void moveDown() {
        pacmanController.update(Tile.Direction.D);
        moveGhosts(ghostControllers);
        initialize(location, resources);
    }

    public void moveLeft() {
        pacmanController.update(Tile.Direction.L);
        moveGhosts(ghostControllers);
        initialize(location, resources);
    }

    public void moveRight() {
        pacmanController.update(Tile.Direction.R);
        moveGhosts(ghostControllers);
        initialize(location, resources);
    }

    public void moveGhosts(ArrayList<GhostController> ghostControllers) {
        Random rand = new Random();
        int upperbound = 4;
        for (GhostController controller : ghostControllers) {
            int intRandom = rand.nextInt(upperbound);
            switch (intRandom) {
                case 0:
                    controller.update(Tile.Direction.D);
                    break;
                case 1:
                    controller.update(Tile.Direction.L);
                    break;
                case 2:
                    controller.update(Tile.Direction.R);
                    break;
                case 3:
                    controller.update(Tile.Direction.U);
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    private AnchorPane pane;
    @FXML
    GridPane maze;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (map.isEnd())
        {
            System.out.println("YOU'VE WIN :)");
            exit();
        }
        maze = new GridPane();
        pane.getChildren().clear();
        for (int i = 0; i < map.map.length - 2; i++) {
            maze.getRowConstraints().add(new RowConstraints(40));
        }
        for (int i = 0; i < map.map[0].length - 2; i++) {
            maze.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (Tile[] row : map.map) {
            for (Tile item : row) {
                if (item instanceof Path) {
                    if (item.getRow() == pacman.getCurrentRow() && item.getColumn() == pacman.getCurrentCol()) {
                        Image image = new Image("file:../pacman_game/data/pacman.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());

                    } else if (item.isFinish()) {
                        Image image = new Image("file:../pacman_game/data/key.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    } else if (item.isKeyObject()) {
                        Image image = new Image("file:../pacman_game/data/apple.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    } else {//../pacman_game/src/main/resources/com/pacman_game/pacman/field.png
                        Image image = new Image("file:../pacman_game/data/field.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    }
                } else {
                    Image image = new Image("file:../pacman_game/data/wall2.png");
                    ImageView view = new ImageView(image);
                    view.setFitHeight(40);
                    view.setFitWidth(40);
                    maze.add(view, item.getColumn(), item.getRow());
                }
            }

        }
        maze.gridLinesVisibleProperty().set(true);
        pane.getChildren().add(maze);
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
        view.render(pacman,ghosts,map);
    }
}
