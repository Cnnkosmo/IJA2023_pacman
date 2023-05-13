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
    void setWall();
    void setDot();
    void setStartPac(boolean bool);
    void setStartGhost(boolean bool);
}
