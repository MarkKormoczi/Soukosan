package com.coffeepp;

/**
 * A special floortype which destroys movable items if they try to move to them.
 */
public class Hole extends FloorBase {

    /**
     * Kills the movable that tries to step int this.
     * @param m The movable to be killed.
     */
    public void Kill(Movable m)
    {
        Logger l = new Logger();
        l.enter(this, "Kill");
        m.Destroy();
        l.exit(this, "Kill", "void");
    }

    /**
     * Always accept and always kills the movable.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return true always.
     */
    public boolean Accept(Movable m, Direction d) //mindig mindent megeszik
    {
        Logger l = new Logger();
        l.enter(this, "Accept");
        Kill(m);
        l.exit(this, "Accept", "true");
        return true;
    }

    @Override
    public String toString() {
    	return "Hole";
    }
}
