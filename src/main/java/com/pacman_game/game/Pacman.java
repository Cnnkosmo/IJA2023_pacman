package com.pacman_game.game;

import com.pacman_game.common.Object;
import com.pacman_game.common.Tile;

public class Pacman implements Object {
    private int row, col;  // current position of Pacman
    Tile.Direction direction;  // current direction of Pacman

    public Pacman(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.direction = Tile.Direction.R;  // default direction
    }

    @Override
    // move Pacman one step in its current direction
    public void move(Tile.Direction dir) {
        // calculate new position based on current direction
        int newRow = row;
        int newCol = col;
        switch (dir)
        {
            case D: //down
                newRow++;
                direction =  dir;
                break;
            case U: //up
                newRow--;
                direction = dir;
                break;
            case L: //left
                newCol--;
                direction = dir;
                break;
            case R: //right
                newCol++;
                direction = dir;
                break;
        }
        // update Pacman's position
        row = newRow;
        col = newCol;
    }

    @Override
    public int getCurrentRow()
    {
        return row;
    }

    @Override
    public int getCurrentCol()
    {
        return col;
    }
}
