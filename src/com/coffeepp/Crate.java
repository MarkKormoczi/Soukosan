package com.coffeepp;

import java.lang.annotation.Target;

/**
 * This class represents the crates that needed to complete the stages.
 * Can be pushed by Workers or other Crates.
 */
public class Crate extends Movable {

    /**
     * Crate gets pushed.
     //* @param m the movable that tries to push this object.
     //* @param d the Direction which in the object is being pushed.
     */

    public Crate()
    {
        this.setWeight(5);
    }
    public Crate(double _weight)
    {
        this.setWeight(_weight);
    }
    @Override
    public boolean Push(Movable m, Direction d, double strength)
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

        if(!pl.Accept(this, d, strength - (this.GetWeight() * this.getPlace().getLiquid().getModifier())))
        {//- (this.GetWeight() )
            l.exit(this, "Push", "false");
            return false;
        } else {
            if(this.getPlace()!=null)
            this.getPlace().Remove(this);
            this.setPlace(pl);
            pl.setEntity(this);
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
        //if(isGivepoint == true) {
            Movable lp = this.GetLastPusher();
            lp.AddPoints();
        //}
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
    public void Destroy()
    {
        Logger l = new Logger();
        l.enter(this, "Destroy");

        this.setPlace(null);
        l.exit(this, "Destroy", "void");
        System.out.println("Destroyed crate. Game Over.");
        Game.getInstance().GameOver();

    }

    @Override
    public String toString() {
    	return "Crate";
    }
}
