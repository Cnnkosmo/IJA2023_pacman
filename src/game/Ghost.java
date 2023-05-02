package game;

import common.Object;
import common.Tile;

public class Ghost implements Object {
    int row = 0, col = 0;
    int direction;

    public Ghost(int row, int col){
        this.row = row;
        this.col = col;
        this.direction = 0;
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

    @Override
    public void move(Tile.Direction dir) {

    }

}
