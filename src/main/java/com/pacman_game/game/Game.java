package com.pacman_game.game;

import com.pacman_game.common.Tile;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;


/*
*main class which will allow us to run our game and where is rendering of the map happening
 */
public class Game{
    Maze_cfg cfg;
    MazeMap map;
    public Game(File file){
        cfg = new Maze_cfg();
        cfg.startReading(cfg.getRowsOrCols(0, file), cfg.getRowsOrCols(1, file));
        cfg.getMapFromTxt(file);
        cfg.stopReading();
        map = cfg.createMaze();
    }
    /*
    *@brief return created pacman with the row and col values setted for same values as the tile with it start position
    *@param takes the whole map to look through and find start position for pacman
     */
    public Pacman createPacman(MazeMap map) {

        for (Tile[] row : map.map) {
            for (Tile item : row) {
                if (item instanceof Path) {
                    if (((Path) item).isStartPac()) {
                        return new Pacman(item.getRow(), item.getColumn());
                    }
                }
            }
        }
        return null;
    }

    public MazeMap getMap() {
        return map;
    }

    /*
    *@brief method returns array of ghosts same principle as for createPacman method
     *@param map
     */
    public ArrayList<Ghost> createGhosts(MazeMap map) {
        ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
        for (Tile[] row : map.map) {
            for (Tile item : row) {
                if (item instanceof Path) {
                    if (((Path) item).isStartGhost()) {
                        ghosts.add(new Ghost(item.getRow(), item.getColumn()));
                    }
                }
            }
        }
        return ghosts;
    }
    /*
    *@brief method that returns a list of controllers for ghosts(because we have unlimited number of ghosts so unlimited
    * number of controllers as well)
    * @param List of ghosts, map to set a reference to the whole map to the every controller
     */
    public ArrayList<GhostController> setGhostControllers(ArrayList<Ghost> ghosts, MazeMap map)
    {
        ArrayList<GhostController> ghostCntrl = new ArrayList<GhostController>();
        for (int i = 0; i < ghosts.size(); i++)
        {
            ghostCntrl.add(new GhostController((ghosts.get(i)), map));
        }
        return ghostCntrl;
    }
}