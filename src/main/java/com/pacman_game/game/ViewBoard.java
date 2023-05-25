package com.pacman_game.game;
import java.io.FileWriter;
import com.pacman_game.common.Object;
import com.pacman_game.common.Tile;

import java.io.IOException;
import java.util.ArrayList;

public class ViewBoard {
    Pacman pacman;
    ArrayList<Ghost> ghosts;
    MazeMap map;
    FileWriter writer;
    public ViewBoard(Pacman pacman,  ArrayList<Ghost> ghosts, MazeMap map){
        this.pacman = pacman;
        this.ghosts = ghosts;
        this.map = map;
        try {
            writer = new FileWriter("log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                        try {
                            writer.write("S" + " ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (samePosGhost(ghosts,item))
                    {
                        try {
                            writer.write("G" + " ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else if (((Path) item).keyObject)
                    {
                        try {
                            writer.write("K" + " ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    else
                    {
                        try {
                            writer.write("." + " ");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                else if (item instanceof Wall)
                {
                    try {
                        writer.write("X" + " ");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try {
                writer.write('\n');
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.write("COLS "+ map.numCols());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write("ROWS "+ map.numRows() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
