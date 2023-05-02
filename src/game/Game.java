package game;

import common.Tile;

import java.util.ArrayList;

public class Game {
    public static void main(String[] args) {
        Maze_cfg cfg = new Maze_cfg();
        cfg.startReading(3, 3);
        cfg.processLine("XGS");
        cfg.processLine("X..");
        cfg.processLine("XG.");
        cfg.stopReading();
        MazeMap map = cfg.createMaze();
        Pacman pacman = createPacman(map);
        ArrayList<Ghost> ghosts = createGhosts(map);
        PacmanController pacmanController = new PacmanController(pacman,map);
        ArrayList<GhostController> ghostControllers = setGhostControllers(ghosts,map);
//        pacmanController.update(Tile.Direction.L);
        ViewBoard view = new ViewBoard(pacman, ghosts, map);
        view.render(pacman,ghosts,map);
//        System.out.println(view.samePosGhost(ghosts, map.getTile(2,3)));
    }
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