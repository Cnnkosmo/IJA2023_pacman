package common;

public interface Maze
{
//    Tile[][] tiles;
//    int dotseaten;

    void resetMaze();
    Tile getTile(int row, int col);
    Tile nextTile();
    int numRows();
    int numCols();
    void dotEaten();
    void paint();
    void checkEndGame();
    boolean withinMaze();
}
