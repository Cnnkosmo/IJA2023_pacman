package game;

import common.Tile;

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
    public void setWall() {

    }

    @Override
    public void setDot() {

    }

    @Override
    public void setStartPac(boolean bool) {

    }

    @Override
    public void setStartGhost(boolean bool) {

    }
}
