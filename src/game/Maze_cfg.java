package game;


import common.Maze;
import common.Tile;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    public int getRowsOrCols(int what){ // what is either 0 or 1 ( 0 for Rows from mao.txt, 1 for cols from map.txt)
        if(what != 0 && what != 1){
            System.out.println("ERROR, BAD ATTEMPT TO USE FUNCTION getRowsOrCols!");
        }
        int number = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("../IJA2023_pacman-main/maps/map_1.txt"));
            String firstLine = reader.readLine();
            String[] numbers = firstLine.split("\\s+");;
            number = Integer.parseInt(numbers[what]);
            reader.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return number;
    }
    public void getMapFromTxt(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("../IJA2023_pacman-main/maps/map_1.txt"));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) { // read each subsequent line
                //901
                // System.out.println(line);
                processLine(line);
            }
        } catch(IOException e){
            e.printStackTrace();
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
