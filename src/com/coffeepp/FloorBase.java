package com.coffeepp;

public abstract class FloorBase {

    private FloorBase up;
    private FloorBase down;
    private FloorBase left;
    private FloorBase right;
    private Movable entity;

    public FloorBase GetNeighbor(Direction d)
    {
        switch(d)
        {
            case up: return up;
            case down: return down;
            case left: return left;
            case right: return right;
            default: return up;
        }
    }
    public Movable GetEntity()
    {
        return entity;
    }
    public boolean Accept(Movable m, Direction d)
    {
        //ide még jönnek cuccok csak egy alapot írtam
        entity = m;
        return true;
    }
    public void Remove(Movable m)
    {
        entity = null;
    }
    @Override
    public String toString() {
    	return "FloorBase";
    }
}
