package game;

public class Game {

    public static void main(String[] args)
    {
        Maze_cfg cfg = new Maze_cfg();
        cfg.startReading(2,2);
        cfg.processLine("X.");
        cfg.processLine(".X");
        cfg.stopReading();
        MazeMap map =  cfg.createMaze();
        System.out.println(map.numCols());

    }



}