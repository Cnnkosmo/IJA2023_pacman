package game;

import common.Tile;

import java.util.ArrayList;

public class Game {

    static PacmanController pacmanController;
    static ArrayList<GhostController> ghostControllers = new ArrayList<GhostController>();
    public static void main(String[] args)
    {
        Maze_cfg cfg = new Maze_cfg();
        cfg.startReading(2,3);
        cfg.processLine("X.S");
        cfg.processLine(".GG");
        cfg.stopReading();
        MazeMap map =  cfg.createMaze();
        setControllers(map);
        printBoard(map);
        pacmanController.update(Tile.Direction.L);
        printBoard(map);
    }

    public static void setControllers(MazeMap map){
        for (Tile[] row : map.map)
        {
            for (Tile item : row)
            {
                if (item instanceof Path)
                {
                    if (((Path)item).isStartPac())
                    {
                        pacmanController = new PacmanController(new Pacman(item.getRow(),item.getColumn()),map);
                    }
                    else if (((Path)item).isStartGhost())
                    {
                        ghostControllers.add(new GhostController(new Ghost(item.getRow(),item.getColumn()),map));
                    }
                }
            }
        }
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