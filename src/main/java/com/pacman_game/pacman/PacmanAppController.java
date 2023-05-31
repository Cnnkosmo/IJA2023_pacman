package com.pacman_game.pacman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.pacman_game.game.PacmanController;
import com.pacman_game.game.*;
import com.pacman_game.common.*;

import java.util.ArrayList;
import java.util.Random;

public class PacmanAppController{
    GameScene scene;
    public PacmanAppController(GameScene scene)
    {
        this.scene = scene;
    }

    public void moveUp() {
        scene.pacmanController.update(Tile.Direction.U);
        moveGhosts(scene.ghostControllers);
        scene.rerender(scene.map);
//        scene.view.render(scene.pacman,scene.ghosts,scene.map);
        if (scene.isLogged())
        {
            scene.logger.log(scene.pacman,scene.ghosts,scene.map);
        }
    }

    public void moveDown() {
        scene.pacmanController.update(Tile.Direction.D);
        moveGhosts(scene.ghostControllers);
        scene.rerender(scene.map);
        if (scene.isLogged())
        {
            scene.logger.log(scene.pacman,scene.ghosts,scene.map);
        }
    }

    public void moveLeft() {
        scene.pacmanController.update(Tile.Direction.L);
        moveGhosts(scene.ghostControllers);
        scene.rerender(scene.map);
        if (scene.isLogged())
        {
            scene.logger.log(scene.pacman,scene.ghosts,scene.map);
        }
    }

    public void moveRight() {
        scene.pacmanController.update(Tile.Direction.R);
        moveGhosts(scene.ghostControllers);
        scene.rerender(scene.map);
        if (scene.isLogged())
        {
            scene.logger.log(scene.pacman,scene.ghosts,scene.map);
        }
    }
    public void gameIsLoggedNow(boolean isItLogged)
    {
        scene.setLogged(isItLogged);
    }

    public void moveGhosts(ArrayList<GhostController> ghostControllers) {
        Random rand = new Random();
        int upperbound = 4;
        for (GhostController controller : ghostControllers) {
            int intRandom = rand.nextInt(upperbound);
            switch (intRandom) {
                case 0:
                    controller.update(Tile.Direction.D);
                    break;
                case 1:
                    controller.update(Tile.Direction.L);
                    break;
                case 2:
                    controller.update(Tile.Direction.R);
                    break;
                case 3:
                    controller.update(Tile.Direction.U);
                    break;
                default:
                    break;
            }
        }
    }
}
