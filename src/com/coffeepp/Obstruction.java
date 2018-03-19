package com.coffeepp;

/**
 * Represents an penetrable floortile
 */
public class Obstruction extends FloorBase {

    /**
     * Never accepst anything.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return
     */
    public boolean Accept(Movable m, Direction d)
    {
        Logger l = new Logger();
        l.enter(this, "GetPoints");

        l.exit(this, "GetPoints", "false");
        return false;
    }

    @Override
    public String toString() {
    	return "Obstruction";
    }
}
