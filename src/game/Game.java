package game;

import common.Tile;

import java.util.ArrayList;
/*
*main class which will allow us to run our game and where is rendering of the map happening
 */
public class Game {
    public static void main(String[] args) {
        Maze_cfg cfg = new Maze_cfg();
        cfg.startReading(10, 10);
        cfg.processLine(".........S");
        cfg.processLine(".....G...G");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.processLine("..........");
        cfg.stopReading();
        MazeMap map = cfg.createMaze();
        Pacman pacman = createPacman(map);
        ArrayList<Ghost> ghosts = createGhosts(map);
        PacmanController pacmanController = new PacmanController(pacman,map);
        ArrayList<GhostController> ghostControllers = setGhostControllers(ghosts,map);
        pacmanController.update(Tile.Direction.D);
        pacmanController.update(Tile.Direction.D);
        ViewBoard view = new ViewBoard(pacman, ghosts, map);
        view.render(pacman,ghosts,map);
        ghostControllers.get(0).update((Tile.Direction.R));
        view.render(pacman,ghosts,map);
//        System.out.println(view.samePosGhost(ghosts, map.getTile(2,3)));
    }
    /*
    *@brief return created pacman with the row and col values setted for same values as the tile with it start position
    *@param takes the whole map to look through and find start position for pacman
     */
    public static Pacman createPacman(MazeMap map) {

        for (Tile[] row : map.map) {
            for (Tile item : row) {
                if (item instanceof Path) {
                    if (((Path) item).isStartPac()) {
                        return new Pacman(item.getRow(), item.getColumn());
                    }
                }
            }
        }
        return null;
    }
    /*
    *@brief method returns array of ghosts same principle as for createPacman method
     *@param map
     */
    public static ArrayList<Ghost> createGhosts(MazeMap map) {
        ArrayList<Ghost> ghosts = new ArrayList<Ghost>();
        for (Tile[] row : map.map) {
            for (Tile item : row) {
                if (item instanceof Path) {
                    if (((Path) item).isStartGhost()) {
                        ghosts.add(new Ghost(item.getRow(), item.getColumn()));
                    }
                }
            }
        }
        return ghosts;
    }
    /*
    *@brief method that returns a list of controllers for ghosts(because we have unlimited number of ghosts so unlimited
    * number of controllers as well)
    * @param List of ghosts, map to set a reference to the whole map to the every controller
     */
    public static ArrayList<GhostController> setGhostControllers(ArrayList<Ghost> ghosts, MazeMap map)
    {
        ArrayList<GhostController> ghostCntrl = new ArrayList<GhostController>();
        for (int i = 0; i < ghosts.size(); i++)
        {
            ghostCntrl.add(new GhostController((ghosts.get(i)), map));
        }
        return ghostCntrl;
    }

}