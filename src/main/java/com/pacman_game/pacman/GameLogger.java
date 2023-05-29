package com.pacman_game.pacman;
import com.pacman_game.game.*;
import com.pacman_game.common.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameLogger
{
    ArrayList<MazeMap> log = new ArrayList<>();
    ViewBoard viewBoard;

    public GameLogger(Pacman pacman, ArrayList<Ghost> ghosts, MazeMap map)
    {
        this.viewBoard = new ViewBoard(pacman, ghosts, map);
    }
    public void log(MazeMap map)
    {
        log.add(map);
    }
    public void createLogTxt()
    {
        try
        {
            File logfile = new File("log.txt");
            if (logfile.createNewFile())
            {
                System.out.println("File Created" + logfile.getName());
            }
            else
            {
                System.out.println("File already exists");
            }
        }
        catch (IOException e)
        {
            System.out.println("an error occured");
            e.printStackTrace();
        }
    }

    public void logAllGame(Pacman pacman, ArrayList<Ghost> ghosts)
    {
        for (MazeMap map : log)
        {
            viewBoard.render(pacman, ghosts, map);
        }
    }
}
