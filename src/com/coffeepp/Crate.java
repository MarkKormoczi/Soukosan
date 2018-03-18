package com.coffeepp;

/**
 * This class represents the crates that needed to complete the stages.
 * Can be pushed by Workers or other Crates.
 */
public class Crate extends Movable {

    /**
     * Crate gets pushed.
     * @param m the movable that tries to push this object.
     * @param d the Direction which in the object is being pushed.
     */
    @Override
    public boolean Push(Movable m, Direction d)
    {
        SetLastPusher(m);
        FloorBase pl= this.getPlace();
        pl = pl.GetNeighbor(d);
        if(!pl.Accept(this, d))
            return false;
        else
            this.getPlace().Remove(this);
        return true;
    }

    /**
     * Responsible for delivering the point to the last pusher Worker
     */
    public void AddPoints()
    {
        Movable lp= this.GetLastPusher();
        lp.AddPoints();
    }

    /**
     * Returns if the object can switch a Switch.
     */
    public boolean SwitchCapable()
    {
        return true;
    }

    @Override
    public String toString() {
    	return "Crate";
    }
}
