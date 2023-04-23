package game;
import common.Maze;
import common.Tile;

public class MazeMap implements Maze {

    private int rows;
    private int cols;
    private Tile[][] map;

    private int lastRow = 0; //row counter

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
//                        field.put(new FinishObject(field));
                        break;
                    case 'G':
//                        field.put(new GhostObject(field));
                        break;
                    case 'K':
//                        field.put(new KeyObject(field));
                        break;
                    case 'S':
//                        field.put(new PacmanObject(field));
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

    @Override
    public void resetMaze() {

    }

    @Override
    public Tile getTile(int row, int col) {
        return this.map[row][col];
    }

    @Override
    public Tile nextTile() {
        return null;
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
