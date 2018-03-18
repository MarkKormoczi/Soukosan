package com.coffeepp;

public abstract class FloorBase implements Updatable {

    private FloorBase up;
    private FloorBase down;
    private FloorBase left;
    private FloorBase right;
    private Movable entity;

    public Movable getEntity() {
        return entity;
    }

    public void setEntity(Movable entity) {
        this.entity = entity;
    }

    /**
    * Visszaadja a megadott irányban lévő szomszédos FloorBase-t
    */
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
    public void setNeighbor(FloorBase fb, Direction d)
    {
        switch(d)
        {
            case up: up = fb;
            case down: down = fb;
            case left: left = fb;
            case right: right = fb;
        }
    }

    public boolean Accept(Movable m, Direction d)
    {

        if(entity == null) {
            entity = m;
            return true;
        }
        return false;
    }
    public void Remove(Movable m)
    {
        entity = null;
    }
    public void Update(){} //szándékosan üres, nem mindenki valósítja meg viszont szükséges a tárolás miatt

    @Override
    public String toString() {
    	return "FloorBase";
    }
}
