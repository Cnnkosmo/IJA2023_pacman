package com.pacman_game.common;

public interface Tile {
    static enum Direction
    {
        D, L, R, U;
        public int deltaRow()
        {
            return 0;
        }
        public int deltaCol()
        {
            return 0;
        }
    }
    int getColumn();
    int getRow();
    void setStartPac(boolean bool);
    void setStartGhost(boolean bool);
    void setFinish(boolean finish);
    void setKeyObject(boolean keyObject);
    boolean isFinish();
    boolean isKeyObject();
}
