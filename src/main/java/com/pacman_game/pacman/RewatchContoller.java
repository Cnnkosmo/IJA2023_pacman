package com.pacman_game.pacman;

public class RewatchContoller
{
    RewatchUi rewatchUi;
    public RewatchContoller(RewatchUi rewatchUi)
    {
        this.rewatchUi = rewatchUi;
    }

    public void renderNext()
    {
        rewatchUi.setIndex(rewatchUi.getIndex()+1);
        rewatchUi.getRoot(rewatchUi.maps.get(rewatchUi.getIndex()));
        System.out.println("E pushed");
    }
    public void renderPrevious()
    {
        rewatchUi.setIndex(rewatchUi.getIndex()-1);
        rewatchUi.getRoot(rewatchUi.maps.get(rewatchUi.getIndex()));
        System.out.println("Q pushed");
    }
}
