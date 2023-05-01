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
    public int getCurrentX() {
        return 0;
    }

    @Override
    public int getCurrentY() {
        return 0;
    }

    @Override
    public void move(int dir) {

    }

}
