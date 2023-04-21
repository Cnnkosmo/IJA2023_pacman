package game;

import common.Maze;
import common.Tile;

public class Maze_cfg {
    Ghost ghost;
    Pacman pacman;
    Tile[][] map;
    int row = 0;
    int col = 0;
    int actual_row = 0;
    int cols = 0;
    public void startReading(int row, int col)
    {
        this.row = row;
        this.col = col;
        this.map = new Tile[row+2][col+2];
    }

    public boolean processLine(String line)
    {
        cols = 0;
        for (Character c : line.toCharArray())
        {
            map[actual_row][cols] = new Wall(actual_row,col);
            cols++;
            if (c == 'X')
            {
                map[actual_row][cols] = new Wall(actual_row,cols);
            }
            else if (c == '.')
            {
                map[actual_row][cols] = new Path(actual_row,cols);
            }
            else if (c == 'S')
            {
                map[actual_row][cols] = new Path(actual_row,cols);
                pacman = new Pacman(actual_row,cols);
            }
            else if (c == 'G')
            {
                map[actual_row][cols] = new Path(actual_row,cols);
                ghost = new Ghost(actual_row,cols);
            }
        }
        actual_row++;
        return false;
    }

    public void endReading(){

    }
}
