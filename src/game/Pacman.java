package game;

import common.Object;

public class Pacman implements Object {
    private int x, y;  // current position of Pacman
    private int direction;  // current direction of Pacman

    public Pacman(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.direction = 0;  // default direction
    }

    @Override
    // move Pacman one step in its current direction
    public void move(int dir) {
        // calculate new position based on current direction
        int newX = x;
        int newY = y;
        switch (dir) {
            case 0:
                newY--;
                break;
            case 1:
                newY++;
                break;
            case 2:
                newX--;
                break;
            case 3:
                newX++;
                break;
        }
        // check if new position is valid (not a wall)
//        if (isWall(newX, newY)) {
//            return;
//        }
        // update Pacman's position
        x = newX;
        y = newY;
    }

    @Override
    public int getCurrentX()
    {
        return x;
    }

    @Override
    public int getCurrentY()
    {
        return y;
    }
}
