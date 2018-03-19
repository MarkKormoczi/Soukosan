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
        Logger l = new Logger();
        l.enter(this, "Push");

        SetLastPusher(m);
        FloorBase pl= this.getPlace();
        /*if (d == Direction.up)
            d = Direction.down;
        else if (d == Direction.down)
            d = Direction.up;
        else if (d == Direction.left)
            d = Direction.right;
        else if (d == Direction.right)
            d = Direction.left;*/

        pl = pl.GetNeighbor(d);
        if(!pl.Accept(this, d)) {
            l.exit(this, "Push", "false");
            return false;
        } else {
            if(this.getPlace()!=null)
            this.getPlace().Remove(this);
        }
        l.exit(this, "Push", "true");
        return true;
    }

    /**
     * Responsible for delivering the point to the last pusher Worker
     */
    public void AddPoints()
    {
        Logger l = new Logger();
        l.enter(this, "AddPoints");

        Movable lp= this.GetLastPusher();
        lp.AddPoints();

        l.exit(this, "AddPoints", "void");
    }

    /**
     * Returns if the object can switch a Switch.
     */
    public boolean SwitchCapable()
    {
        Logger l = new Logger();
        l.enter(this, "SwitchCapable");
        l.exit(this, "SwitchCapable", "true");
        return true;
    }

    @Override
    public String toString() {
    	return "Crate";
    }
}
