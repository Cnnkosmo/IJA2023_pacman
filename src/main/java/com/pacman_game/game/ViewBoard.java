package com.pacman_game.game;

import com.pacman_game.common.Object;
import com.pacman_game.common.Tile;

import java.util.ArrayList;

public class ViewBoard {
    Pacman pacman;
    ArrayList<Ghost> ghosts;
    MazeMap map;
    public ViewBoard(Pacman pacman,  ArrayList<Ghost> ghosts, MazeMap map){
        this.pacman = pacman;
        this.ghosts = ghosts;
        this.map = map;
    }
    public boolean samePosPac(Object obj, Tile tile){
        if (tile.getRow() == obj.getCurrentRow() && tile.getColumn() == obj.getCurrentCol())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean samePosGhost(ArrayList<Ghost> ghosts, Tile tile)
    {
        for (Ghost ghost : ghosts)
        {
            if (ghost.getCurrentRow() == tile.getRow() && ghost.getCurrentCol() == tile.getColumn())
            {
                return true;
            }
        }
        return false;
    }
    public void render(Pacman pacman, ArrayList<Ghost> ghosts, MazeMap map)
    {
        for (Tile[] row : map.map)
        {
            for (Tile item : row)
            {
                if (item instanceof Path)
                {
                    if (samePosPac(pacman,item))
                    {
                        System.out.print("S" + " ");
                    }
                    else if (samePosGhost(ghosts,item))
                    {
                        System.out.print("G" + " ");
                    }
                    else
                    {
                        System.out.print("." + " ");
                    }
                }
                else if (item instanceof Wall)
                {
                    System.out.print("X" + " ");
                }
            }
            System.out.println('\n');
        }
        System.out.println("COLS "+ map.numCols());
        System.out.println("ROWS "+ map.numRows());
    }
}
