package game;

import common.Object;
import common.Tile;

public class Ghost implements Object {
    @Override
    public int getLocation() {
        return 0;
    }

    @Override
    public boolean moveValid() {
        return false;
    }

    @Override
    public Tile getCurrentPosition() {
        return null;
    }
}
