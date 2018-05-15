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
        m.Destroy();
    }

    /**
     * Always accept and always kills the movable.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return true always.
     */
    public boolean Accept(Movable m, Direction d, double s) //mindig mindent megeszik
    {
        super.Accept(m, d, s);
        Kill(m);
        return true;
    }

    @Override
    public String toString() {
    	return "Hole";
    }
}
