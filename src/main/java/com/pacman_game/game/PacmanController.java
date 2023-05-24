package com.pacman_game.game;
import com.pacman_game.common.Controller;
import com.pacman_game.common.Tile;

public class PacmanController implements Controller {
    private Pacman pacman;
    private MazeMap maze;

    public PacmanController(Pacman pacman, MazeMap maze)
    {
        this.pacman = pacman;
        this.maze = maze;
    }
    public boolean update(Tile.Direction dir)
    {
        Tile nextField = maze.nextTile(dir,pacman.getCurrentRow(),pacman.getCurrentCol());
        if (nextField instanceof Wall)
        {
//            System.out.println("hitted the wall");
        }
        else
        {
            if (nextField.isKeyObject())
            {
//                System.out.println("hit the dot");
                maze.dotEaten(nextField.getRow(), nextField.getColumn());
            }
            else if (nextField.isFinish())
            {
//                System.out.println("finished the game");
                pacman.move(dir);
                return true;
            }
            pacman.move(dir);
        }
        return false;
    }
}
