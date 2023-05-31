package com.pacman_game.pacman;

import java.io.File;
import java.util.ArrayList;
import com.pacman_game.game.*;
import com.pacman_game.common.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseFile
{
    ArrayList<MazeMap> maps;
    static File file;
    Maze_cfg cfg;
    public ParseFile(File file)
    {
        this.file = file;
        this.cfg = new Maze_cfg();
    }

    public ArrayList<MazeMap> parse(int cols, int rows,File file)
    {
        ArrayList<MazeMap> maps = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            cfg = new Maze_cfg();
            cfg.startReading(cols, rows);
            while ((line = reader.readLine()) != null)
            { // read each subsequent line
                if (cfg.processLineWithNoWalls(line) == false)
                {
                    cfg.stopReadingWithNoWalls();
                    maps.add(cfg.createMaze());
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return maps;
    }

}
