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
        }
        else
        {
            if (nextField.isKeyObject())
            {
                maze.dotEaten(nextField.getRow(), nextField.getColumn());
            }
            else if (nextField.isFinish())
            {
                pacman.move(dir);
                maze.checkEndGame();
                return true;
            }
            pacman.move(dir);
        }
        return false;
    }
}
