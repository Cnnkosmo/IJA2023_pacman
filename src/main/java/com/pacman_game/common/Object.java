package com.pacman_game.common;

public interface Object
{
   int getCurrentRow();
   int getCurrentCol();
   void move(Tile.Direction dir);
}
