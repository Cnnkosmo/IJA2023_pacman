package game;

import common.Tile;

public class Path implements Tile
{
    int row = 0, col = 0;

    public Path(int row, int col){
        this.row = row;
        this.col = col;
    }
    @Override
    public void setWall() {

    }

    @Override
    public void setDot() {

    }
}
