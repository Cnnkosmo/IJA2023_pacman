package com.pacman_game.game;

import com.pacman_game.common.Object;
import com.pacman_game.common.Tile;

public class Pacman implements Object {
    private int row, col;  // current position of Pacman
    private int direction;  // current direction of Pacman

    public Pacman(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.direction = 0;  // default direction
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
                break;
            case U: //up
                newRow--;
                break;
            case L: //left
                newCol--;
                break;
            case R: //right
                newCol++;
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
