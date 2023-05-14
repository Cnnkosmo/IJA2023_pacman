package com.pacman_game.pacman;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

import com.pacman_game.game.PacmanController;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import javafx.scene.layout.AnchorPane;
import com.pacman_game.game.*;
import com.pacman_game.common.*;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;

import java.util.ArrayList;
import java.util.Random;


public class PacmanAppController implements Initializable{
    PacmanController pacmanController;
    ArrayList<GhostController> ghostControllers;
    static final int cellSize = 40;
    Pacman pacman;
    ArrayList<Ghost> ghosts;
    MazeMap map;
    @FXML
    Circle pacmanObj;

    @FXML
    Rectangle ghostObj;
    public PacmanAppController()
    {
        Game game = new Game();
        this.map = game.getMap();
        this.pacman = game.createPacman(game.getMap());
        this.ghosts = game.createGhosts(game.getMap());
        this.pacmanController = new PacmanController(pacman,game.getMap());
        this.ghostControllers = game.setGhostControllers(ghosts,game.getMap());
    }

    public void moveUp()
    {
        pacmanController.update(Tile.Direction.U);
        ghostControllers.get(0).update(Tile.Direction.R);
        System.out.println("rowpacman:" + pacman.getCurrentRow() + " colpacman: "+ pacman.getCurrentCol());
        System.out.println("movin up");
        moveGhosts(ghostControllers);
        initialize(location,resources);
    }
    public void moveDown()
    {
        pacmanController.update(Tile.Direction.D);
        System.out.println("rowpacman:" + pacman.getCurrentRow() + " colpacman: "+ pacman.getCurrentCol());
        System.out.println("movin down");
        moveGhosts(ghostControllers);
        initialize(location,resources);
    }
    public void moveLeft()
    {
        pacmanController.update(Tile.Direction.L);
        System.out.println("rowpacman:" + pacman.getCurrentRow() + " colpacman: "+ pacman.getCurrentCol());
        System.out.println("movin left");
        moveGhosts(ghostControllers);
        initialize(location,resources);
    }
    public void moveRight()
    {
        pacmanController.update(Tile.Direction.R);
        System.out.println("rowpacman:" + pacman.getCurrentRow() + " colpacman: "+ pacman.getCurrentCol());
        System.out.println("movin right");
        moveGhosts(ghostControllers);
        initialize(location,resources);
    }

    public void moveGhosts(ArrayList<GhostController> ghostControllers)
    {
        Random rand =  new Random();
        int upperbound = 4;
        for (GhostController controller : ghostControllers)
        {
            int intRandom = rand.nextInt(upperbound);
            System.out.println("Random" + intRandom);
            switch (intRandom){
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
                default:break;
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
        maze = new GridPane();
        pane.getChildren().clear();
        for (int i = 0; i < map.map.length-2; i++)
        {
            maze.getRowConstraints().add(new RowConstraints(40));
        }
        for (int i = 0; i < map.map[0].length-2; i++)
        {
            maze.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (Tile[] row : map.map)
        {
            for (Tile item : row)
            {
            if (item instanceof Path){
                    if (((Path)item).isStartPac())
                    {
                        pacmanObj = new Circle(15);
                    }
                    else if (item.isFinish())
                    {
                        maze.add(new Sphere(15),item.getColumn(),item.getRow());
                    }
                    else if (item.isKeyObject())
                    {
                        maze.add(new Sphere(5),item.getColumn(),item.getRow());
                    }
                }
                else {
                    maze.add(new Rectangle(20,20), item.getColumn(),item.getRow());
                }
            }

        }
        maze.gridLinesVisibleProperty().set(true);
        pane.getChildren().add(maze);
        maze.add(pacmanObj,pacman.getCurrentCol(),pacman.getCurrentRow());
        for (Ghost ghost : ghosts)
        {
            maze.add(new Rectangle(39,39), ghost.getCurrentCol(), ghost.getCurrentRow());
        }

    }

}
