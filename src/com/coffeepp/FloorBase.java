package com.coffeepp;
/**
 * This is the basic floortype whch the more special types inherit form
 */
public abstract class FloorBase implements Updatable {

    private FloorBase up;
    private FloorBase down;
    private FloorBase left;
    private FloorBase right;
    private Movable entity;
    private Liquid liquid;
    //TODO liquid

    /**
     * Returns the entity contained in this floor.
     * @return the entity
     */
    public String nam;
    public FloorBase()
    {

    }
    public FloorBase(String m)
    {nam = m;}
    public Movable getEntity() {
        Logger l = new Logger();
        l.enter(this, "getEntity");
        if(entity!=null){
        l.exit(this, "getEntity", entity.toString());
        return entity;}
        return null;
    }
    public Liquid getLiquid() {
        Logger l = new Logger();
        l.enter(this, "getLiquid");
        if(entity!=null)
            l.exit(this, "getLiquid", entity.toString());
        return liquid;
    }
    /**
     * Sets the contained entity in this floor.
     * @param entity the new entity to be set
     */
    public void setEntity(Movable entity) {
        Logger l = new Logger();
        l.enter(this, "setEntity");
        this.entity = entity;
        l.exit(this, "setEntity", "void");
    }
    public void setLiquid(Liquid _liquid) {
        Logger l = new Logger();
        l.enter(this, "setLiquid");
        liquid = _liquid;

        l.exit(this, "setLiquid", "void");
    }
    /**
    * Visszaadja a megadott irányban lévő szomszédos FloorBase-t
    * @param d The direction which we are asking about.
    */
    public FloorBase GetNeighbor(Direction d)
    {
        Logger l = new Logger();
        l.enter(this, "GetNeighbor");
        l.exit(this, "GetNeighbor", d.toString());
        switch(d)
        {
            case up: return up;
            case down: return down;
            case left: return left;
            case right: return right;
            default: return up;
        }
    }

    /**
     * Sets The neighnbour int the desired Direction.
     * @param fb The new neighbor.
     * @param d The new neighbors direction.
     */
    public void setNeighbor(FloorBase fb, Direction d)
    {
        Logger l = new Logger();
        l.enter(this, "setNeighbor");
        l.exit(this, "setNeighbor", "void");
        switch(d)
        {
            case up: up = fb; break;
            case down: down = fb; break;
            case left: left = fb; break;
            case right: right = fb; break;
        }
    }

    /**
     * Accepsts a movable to this floor.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return returns if the acceptance was succesful.
     */
    public boolean Accept(Movable m, Direction d, double strength)
    {
        Logger l = new Logger();
        l.enter(this, "Accept");

        if(entity == null ) {
            //System.out.println("\nstrength:"+strength +" Weight: "+m.GetWeight());
            if(0 < strength)
            {
                setEntity(m);
                l.exit(this, "Accept", "true");
                return true;
            } else {
                l.exit(this, "Accept", "false");
                return false;
            }
        }

        // If something is on this floor. We try to push
        if (this.entity.Push(m, d, strength)) {
            //on success we move to this

            setEntity(m);

            l.exit(this, "Accept", "true");
            return true;
        }
        l.exit(this, "Accept", "false");
        return false;
    }

    /**
     * Removes the movable from this floor.
     * @param m the movable to be removed.
     */
    public void Remove(Movable m)
    {
        Logger l = new Logger();
        l.enter(this, "Remove");
        entity = null;
        l.exit(this, "Remove", "void");
    }

    /**
     * szándékosan üres, nem mindenki valósítja meg viszont szükséges a tárolás miatt
     */
    public void Update(){
        Logger l = new Logger();
        l.enter(this, "Update");
        l.exit(this, "Update", "void");
    }

    @Override
    public String toString() {
    	return "FloorBase";
    }
}
