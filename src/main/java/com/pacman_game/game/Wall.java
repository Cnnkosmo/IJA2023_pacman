package com.pacman_game.game;

import com.pacman_game.common.Tile;

public class Wall implements Tile {
    int row = 0,col = 0;

    public Wall(int row, int col){
        this.row = row;
        this.col = col;

    }

    public boolean canGo(){
        return false;
    }

    @Override
    public int getColumn() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }
    @Override
    public void setStartPac(boolean bool) { }
    @Override
    public void setStartGhost(boolean bool){ }

    @Override
    public void setFinish(boolean finish) { }

    @Override
    public void setKeyObject(boolean keyObject) { }

    @Override
    public boolean isFinish()
    {
        return false;
    }

    @Override
    public boolean isKeyObject()
    {
        return false;
    }
}
