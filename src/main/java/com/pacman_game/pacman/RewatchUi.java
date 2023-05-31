package com.pacman_game.pacman;

import com.pacman_game.common.Tile;
import com.pacman_game.game.MazeMap;
import com.pacman_game.game.Path;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.io.File;
import java.util.ArrayList;

import static javafx.application.Platform.exit;

public class RewatchUi {
    private PacmanApplication app;
    GameScene scene;
    ParseFile parser;
    ArrayList<MazeMap> maps;
    GridPane maze;
    int index;

    public RewatchUi(PacmanApplication app, File file)
    {
        this.app = app;
        this.parser = new ParseFile(file);
        this.maps = parser.parse(10, 10, file);
        this.maze = new GridPane();
        this.index = 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public GridPane getRoot(MazeMap map)
    {
        if (map.isEnd()) {
            exit();
        }
        maze.getChildren().clear();
        for (int i = 0; i < map.map.length - 2; i++) {
            maze.getRowConstraints().add(new RowConstraints(40));
        }
        for (int i = 0; i < map.map[0].length - 2; i++) {
            maze.getColumnConstraints().add(new ColumnConstraints(40));
        }
        for (Tile[] row : map.map) {
            for (Tile item : row) {
                if (item instanceof Path) {
                    if (((Path) item).isStartPac()) {
                        System.out.print("S");
                        Image image = new Image("file:../pacman_game/data/pacman.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());

                    } else if (((Path) item).isStartGhost()) {
                        System.out.print("G");
                        Image image = new Image("file:../pacman_game/data/ghost.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());

                    } else if (item.isFinish()) {
                        System.out.print("T");
                        Image image = new Image("file:../pacman_game/data/key.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    } else if (item.isKeyObject()) {
                        System.out.print("K");
                        Image image = new Image("file:../pacman_game/data/apple.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    } else {//../pacman_game/src/main/resources/com/pacman_game/pacman/field.png
                        System.out.print(".");
                        Image image = new Image("file:../pacman_game/data/field.png");
                        ImageView view = new ImageView(image);
                        view.setFitHeight(40);
                        view.setFitWidth(40);
                        maze.add(view, item.getColumn(), item.getRow());
                    }
                } else {
                    System.out.print("#");
                    Image image = new Image("file:../pacman_game/data/wall2.png");
                    ImageView view = new ImageView(image);
                    view.setFitHeight(40);
                    view.setFitWidth(40);
                    maze.add(view, item.getColumn(), item.getRow());
                }
            }
            System.out.println();
        }
        maze.setGridLinesVisible(true);
//        view.render(pacman,ghosts,map);
        return maze;
    }
}
