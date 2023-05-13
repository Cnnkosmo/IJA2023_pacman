package com.pacman_game.common;

public interface Maze
{
//    Tile[][] tiles;
//    int dotseaten;

    void resetMaze();
    Tile getTile(int row, int col);
    Tile nextTile(Tile.Direction dir, int row, int col);

    int numRows();
    int numCols();
    void dotEaten();
    void paint();
    void checkEndGame();
    boolean withinMaze();
}
