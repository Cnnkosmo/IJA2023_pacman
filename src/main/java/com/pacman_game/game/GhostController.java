package com.pacman_game.game;

import com.pacman_game.common.Controller;
import com.pacman_game.common.Tile;

public class GhostController implements Controller {
    private Ghost ghost;
    private MazeMap maze;

    public GhostController(Ghost ghost, MazeMap maze)
    {
        this.ghost = ghost;
        this.maze = maze;
    }
    public void update(Tile.Direction dir)
    {
        Tile nextField = maze.nextTile(dir,ghost.getCurrentRow(),ghost.getCurrentCol());
        if (nextField instanceof Wall){
            throw new UnsupportedOperationException();
        }
        else
        {
            ghost.move(dir);
        }
    }
}
