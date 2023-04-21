package game;

import common.Object;
import common.Tile;

public class Pacman  implements Object {
    int row = 0, col = 0;

    public Pacman(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    @Override
    public int getLocation()
    {
        return 0;
    }

    @Override
    public boolean moveValid()
    {
        return false;
    }

    @Override
    public Tile getCurrentPosition()
    {
        return null;
    }
}
