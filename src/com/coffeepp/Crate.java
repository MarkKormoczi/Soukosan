package com.coffeepp;

public class Crate extends Movable {

    public void Push(Direction d)
    {
        FloorBase pl= this.getPlace();
        pl = pl.GetNeighbor(d);
        pl.
    }
    public void AddPoints()
    {
        Movable lp= this.GetLastPusher();
        lp.AddPoints();
    }
    public boolean SwitchCapable()
    {
        return true;
    }

    @Override
    public String toString() {
    	return "Crate";
    }
}
