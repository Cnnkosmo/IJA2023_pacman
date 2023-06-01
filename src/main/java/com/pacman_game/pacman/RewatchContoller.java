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
        System.out.println("current ind" + rewatchUi.getIndex());
        System.out.println("maps.size" + rewatchUi.maps.size());
        if (rewatchUi.getIndex() < rewatchUi.maps.size())
        {
            rewatchUi.getRoot(rewatchUi.maps.get(rewatchUi.getIndex()));
        }
        System.out.println("E pushed");

    }
    public void renderPrevious()
    {
            rewatchUi.setIndex(rewatchUi.getIndex()-1);
            if (rewatchUi.getIndex() > 0 && rewatchUi.getIndex() < rewatchUi.maps.size())
            {
                rewatchUi.getRoot(rewatchUi.maps.get(rewatchUi.getIndex()));
            }
            System.out.println("Q pushed");
    }
}
