package com.coffeepp;

/**
 * This type of special floorbase is for the purpose of the game.
 * The workers need to push the crates to theese places.
 */
public class TargetSpot extends FloorBase {
    /**
     * Accepst the Crate if it can, and issues a point for it.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return
     */
    public boolean Accept(Movable m, Direction d, double strength)
    {
        Logger l = new Logger();
        l.enter(this, "Accept");

        // szerintem ez kell ide, de nézzétek meg.
        super.Accept(m, d, strength);
        if(this.getEntity()!=null){
            m.AddPoints();
            l.exit(this, "AddPoints", "false");
            return true;
        }
        l.exit(this, "AddPoints", "true");
        return false;

    }
    @Override
    public String toString() {
    	return "TargetSpot";
    }
}
