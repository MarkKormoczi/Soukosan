package com.coffeepp;

public class Trap extends FloorBase implements Updatable {

    private boolean state;

    /**
     * Returns this traps state.
     * @return
     */
    public boolean getState() {
        Logger l = new Logger();
        l.enter(this, "getState");
        l.exit(this, "getState", Boolean.toString(state));
        return state;
    }

    /**
     * Sets this traps trapdoor.
     * @param state The desired state
     */
    public void setState(boolean state) {
        Logger l = new Logger();
        l.enter(this, "setState");
        this.state = state;
        l.exit(this, "setState", "void");
    }


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
     * For updating the Trap
     */
    @Override
    public void Update()
    {

    }

    /**
     * Kills or accepts the moveble according to its state.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return
     */
    public boolean Accept(Movable m, Direction d, double s)
    {
        Logger l = new Logger();
        l.enter(this, "Accept");
        if(state==true){
            Kill(m);
            l.exit(this, "Accept", "true");
            return true;
        }
        //if(this.getEntity()!=null){
        if(!entites.isEmpty()) {
            l.exit(this, "Accept", "false");
            return false;
        }
        l.exit(this, "Accept", "true");
        return true;
    }

    @Override
    public String toString() {
    	return "Trap";
    }
}
