package com.pacman_game.game;
import com.pacman_game.common.Maze;
import com.pacman_game.common.Tile;

public class MazeMap implements Maze {

    public int rows;
    public int cols;
    public Tile[][] map;
    private int lastRow = 0; //row counter
    boolean end;

    public MazeMap(int rows, int cols) {
        this.rows = rows + 2;
        this.cols = cols + 2;
        this.map = new Tile[this.rows][this.cols];
    }
    public boolean createWall() {
        return this.insertLine("X".repeat(this.cols));
    }

    public boolean insertLine(String line) {
        if (line.length() != this.cols)
            return false;
        if (this.lastRow >= this.rows)
            return false;

        int col = 0;
        Tile field;
        for (char ch : line.toCharArray()) {
            if (ch == 'X') {
                field = new Wall(this.lastRow, col);
            } else {
                field = new Path(this.lastRow, col);
                switch (ch) {
                    case 'T':
                        field.setFinish(true);
                        break;
                    case 'G':
                        field.setStartGhost(true);
                        break;
                    case 'K':
                        field.setKeyObject(true);
                        break;
                    case 'S':
                        field.setStartPac(true);
                        break;
                    case '.':
                        break;
                    default:
                        return false;
                }
            }
            this.map[this.lastRow][col] = field;
            col++;
        }

        this.lastRow++;

        return true;
    }

    public boolean isEnd()
    {
        return end;
    }

    @Override
    public void resetMaze() {

    }

    @Override
    public Tile getTile(int row, int col) {
        return this.map[row][col];
    }
    @Override
    public Tile nextTile(Tile.Direction dir, int row, int col)
    {
        switch (dir)
        {
            case U:
                return getTile(row - 1,col);
            case D:
                return getTile(row + 1, col);
            case L:
                return getTile(row, col - 1);
            case R:
                return getTile(row, col + 1);
            default:
                return null;
        }
    }
    @Override
    public int numRows() {
        return this.rows;
    }

    @Override
    public int numCols() {
        return this.cols;
    }

    @Override
    public void dotEaten(int row, int col)
    {
        map[row][col].setKeyObject(false);
    }

    @Override
    public void paint() {

    }

    @Override
    public void checkEndGame() {
        end = true;
    }

    @Override
    public boolean withinMaze() {
        return false;
    }
}
