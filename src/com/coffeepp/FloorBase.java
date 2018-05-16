package com.coffeepp;



import java.util.HashSet;
import java.util.Set;

/**
 * This is the basic floortype whch the more special types inherit form
 */
public abstract class FloorBase implements Updatable {

    private Position p;
    private FloorBase up;
    private FloorBase down;
    private FloorBase left;
    private FloorBase right;

    //ENTITY REFACTOR
    //private Movable entity;

    protected Set<Movable> entites = new HashSet<Movable>();

    private Liquid liquid;

    /**
     * Returns the entity contained in this floor.
     *
     * @return the entity
     */
    public String nam;

    public FloorBase() {

    }

    public void SetActive()
    {

    }
    public boolean getState()
    {
        return false;
    }
    public Position GetPosition() {
        return p;
    }

    public void SetPosition(Position _p) {
        p = _p;
    }

    public FloorBase(String m) {
        nam = m;
    }


    /*public Movable getEntity() {
        if (entity != null) {
            return entity;
        }
        return null;

    }*/

    public Liquid getLiquid() {
        return liquid;
    }

    //ENTITY REFACTOR

    /*public void setEntity(Movable entity) {
        Logger l = new Logger();
        l.enter(this, "setEntity");
        this.entity = entity;
        l.exit(this, "setEntity", "void");
    }*/

    public void addEntity(Movable Entity){
        this.entites.add(Entity);
    }

    public void setLiquid(Liquid _liquid) {
        liquid = _liquid;
        liquid.SetPlace(this);
    }
    /**
    * Visszaadja a megadott irányban lévő szomszédos FloorBase-t
    * @param d The direction which we are asking about.
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

    public boolean isActive()
    {
        return false;
    }
    /**
     * Sets The neighnbour int the desired Direction.
     * @param fb The new neighbor.
     * @param d The new neighbors direction.
     */
    public void setNeighbor(FloorBase fb, Direction d)
    {
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


        /*if(entity == null ) {
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
        }*/

        // if nothing on this floor
        if(entites.isEmpty()) {
            if (strength > 0) {
                addEntity(m);
                return true;
            } else {
                return false;
            }
        }

        boolean success = true;
        for (Movable e : entites){
            if(e.Push(m,d,strength)){
                addEntity(m);
            }
            else  success = false;
        }
        return  success;
        // If something is on this floor. We try to push
        /*if (this.entity.Push(m, d, strength)) {
            //on success we move to this

            setEntity(m);

            l.exit(this, "Accept", "true");
            return true;
        }*/

        // If something is on this floor. We try to push

        //return false;
    }

    /**
     * Removes the movable from this floor.
     * @param m the movable to be removed.
     */
    public void Remove(Movable m)
    {
        //entity = null;
        entites.remove(m);
    }

    /**
     * szándékosan üres, nem mindenki valósítja meg viszont szükséges a tárolás miatt
     */
    public void Update(){
    }

    @Override
    public String toString() {
    	return "FloorBase";
    }
}
