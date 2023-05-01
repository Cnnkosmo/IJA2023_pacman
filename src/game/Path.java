package game;

import common.Tile;

public class Path implements Tile
{
    int row = 0, col = 0;
    boolean startPac = false;
    boolean startGhost = false;

    public void setStartPac(boolean startPac) {
        this.startPac = startPac;
    }

    public void setStartGhost(boolean startGhost) {
        this.startGhost = startGhost;
    }

    public boolean isStartPac() {
        return startPac;
    }

    public boolean isStartGhost() {
        return startGhost;
    }

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
