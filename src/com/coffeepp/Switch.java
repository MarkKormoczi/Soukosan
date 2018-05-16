package com.coffeepp;

/**
 * Represents a special type of floor, that is connected with a trap.
 * Can be switched upon entering.
 */
public class Switch extends FloorBase implements Updatable {

    private boolean state = false;
    private Trap trapdoor;

    /**
     * Retuns the Trap associated with this Switch.
     * @return
     */
    public Trap getTrapdoor() {
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
        else{
            state = false;
        }
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
    }

    /**
     * Sets this switches trapdoor.
     * @param trapdoor
     */
    public void setTrapdoor(Trap trapdoor) {
        this.trapdoor = trapdoor;
    }

    /**
     * Returns this switches state.
     * @return
     */
    @Override
    public boolean getState() {
        return state;
    }

    /**
     * Sets this switches state.
     * @param state the desired state
     */
    public void setState(boolean state) {
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
