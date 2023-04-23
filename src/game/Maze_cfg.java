package game;

import common.Maze;
import common.Tile;

public class Maze_cfg {
    private MazeMap maze;

    public Maze_cfg() {
        this.maze = null;
    }

    public MazeMap createMaze() {
        return this.maze;
    }

    public boolean processLine(String line) {
        if (this.maze == null)
            return false;

        if (this.maze.insertLine("X" + line + "X")) {
            return true;
        }
        else {
            this.maze = null;
            return false;
        }
    }

    public void startReading(int rows, int cols) {
        this.maze = new MazeMap(rows, cols);
        this.maze.createWall();
    }

    public boolean stopReading() {
        if (this.maze == null) {
            return false;
        }

        return this.maze.createWall();
    }
}
