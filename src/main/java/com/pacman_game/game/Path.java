package com.pacman_game.game;

import com.pacman_game.common.Tile;

public class Path implements Tile
{
    int row = 0, col = 0;
    boolean startPac = false;
    boolean startGhost = false;
    boolean isFinish = false;
    boolean keyObject = false;

    public void setStartPac(boolean startPac) {
        this.startPac = startPac;
    }

    public void setStartGhost(boolean startGhost) {
        this.startGhost = startGhost;
    }

    public boolean isStartPac()
    {
        return startPac;
    }

    public boolean isStartGhost()
    {
        return startGhost;
    }

    public Path(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public void setKeyObject(boolean keyObject) {
        this.keyObject = keyObject;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public boolean isKeyObject() {
        return keyObject;
    }

    public boolean canGO()
    {
        return true;
    }


    @Override
    public int getColumn() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }
}
