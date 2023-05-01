package game;

import common.Tile;

public class Game {

    public static void main(String[] args)
    {
        Maze_cfg cfg = new Maze_cfg();
        cfg.startReading(2,3);
        cfg.processLine("X.S");
        cfg.processLine(".GG");
        cfg.stopReading();
        MazeMap map =  cfg.createMaze();
        printBoard(map);
    }


    public static void printBoard(MazeMap map){
        for (Tile[] row : map.map)
        {
            for (Tile item : row)
            {
                if (item instanceof Path)
                {
                    if (((Path) item).isStartGhost())
                    {
                        System.out.print("G" + " ");
                    }
                    else if (((Path) item).isStartPac())
                    {
                        System.out.print("S" + " ");
                    }
                    else
                    {
                        System.out.print("." + " ");
                    }
                }
                else if (item instanceof Wall)
                {
                    System.out.print("X" + " ");
                }
            }
            System.out.println('\n');
        }
        System.out.println("COLS "+ map.numCols());
        System.out.println("ROWS "+ map.numRows());
    }
}