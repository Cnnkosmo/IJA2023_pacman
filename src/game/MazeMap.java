package game;
import common.Maze;
import common.Tile;

public class MazeMap implements Maze {
    Pacman pacman;
    int row = 0;
    int col = 0;

    public MazeMap(int row, int col){
        this.row = row;
        this.col = col;
    }
    @Override
    public void resetMaze() {

    }

    public void setPacman(Pacman pacman, int row,int col) {
        this.pacman = new Pacman(row,col);
    }

    @Override
    public Tile getTile() {
        return null;
    }

    @Override
    public Tile nextTile() {
        return null;
    }

    @Override
    public void dotEaten() {

    }

    @Override
    public void paint() {

    }

    @Override
    public void checkEndGame() {

    }

    @Override
    public boolean withinMaze() {
        return false;
    }
}
