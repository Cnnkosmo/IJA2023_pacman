package game;

import common.Tile;

public class ViewBoard {
    public void render(Pacman pacman, Ghost[] ghosts, MazeMap map)
    {
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
