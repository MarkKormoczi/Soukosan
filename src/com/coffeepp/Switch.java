package com.coffeepp;

/**
 * Represents a special type of floor, that is connected with a trap.
 * Can be switched upon entering.
 */
public class Switch extends FloorBase implements Updatable {

    private boolean state;
    private Trap trapdoor;

    /**
     * Retuns the Trap associated with this Switch.
     * @return
     */
    public Trap getTrapdoor() {
        Logger l = new Logger();
        l.enter(this, "getTrapdoor");
        l.exit(this, "getTrapdoor", trapdoor.toString());
        return trapdoor;
    }


    /**
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return true always.
     */
    public boolean Accept(Movable m, Direction d, double s) //mindig mindent megeszik
    {
        super.Accept(m, d, s);
        if(m.SwitchCapable()){
            state = true;
        }
        Logger l = new Logger();
        l.enter(this, "Accept");
        l.exit(this, "Accept", "true");
        return true;
    }

    /**
     * Removes the movable from this floor.
     * @param m the movable to be removed.
     */
    public void Remove(Movable m)
    {
        super.Remove(m);
        this.state = false;
        Logger l = new Logger();
        l.enter(this, "Remove");
        l.exit(this, "Remove", "void");
    }

    /**
     * Sets this switches trapdoor.
     * @param trapdoor
     */
    public void setTrapdoor(Trap trapdoor) {
        Logger l = new Logger();
        l.enter(this, "setTrapdoor");
        l.exit(this, "setTrapdoor", "void");
        this.trapdoor = trapdoor;
    }

    /**
     * Returns this switches state.
     * @return
     */
    public boolean getState() {
        Logger l = new Logger();
        l.enter(this, "getState");
        l.exit(this, "getState", Boolean.toString(state));
        return state;
    }

    /**
     * Sets this switches state.
     * @param state the desired state
     */
    public void setState(boolean state) {
        Logger l = new Logger();
        l.enter(this, "setState");
        l.exit(this, "setState", "void");
        this.state = state;
    }

    /**
     * For updating the switch.
     */
    @Override
    public void Update() {

    }

    @Override
    public String toString() {
    	return "Switch";
    }
}
