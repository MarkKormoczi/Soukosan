package com.coffeepp;

public class Hole extends FloorBase {

    public void Kill(Movable m)
    {
        m.Destroy();
    }

    public boolean Accept(Movable m, Direction d) //mindig mindent megeszik
    {
        Kill(m);
        return true;
    }

    @Override
    public String toString() {
    	return "Hole";
    }
}
