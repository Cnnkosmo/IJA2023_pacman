package common;

public interface Maze
{
//    Tile[][] tiles;
//    int dotseaten;

    void resetMaze();
    Tile getTile();
    Tile nextTile();
    void dotEaten();
    void paint();
    void checkEndGame();
    boolean withinMaze();
}
