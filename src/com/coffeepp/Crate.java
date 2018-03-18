package com.coffeepp;

public class Crate extends Movable {

    public void Push(Direction d) //ellök valamit az adott irányba
    {
        FloorBase pl= this.getPlace();
        pl = pl.GetNeighbor(d);
        if(pl.Accept(this,d)==false)
            this.Destroy();

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
