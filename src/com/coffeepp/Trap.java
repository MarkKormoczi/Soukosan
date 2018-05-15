package com.coffeepp;

public class Trap extends FloorBase implements Updatable {

    private boolean state = false;

    /**
     * Returns this traps state.
     * @return
     */

    /**
     * Sets this traps trapdoor.
     * @param state The desired state
     */
    public void setState(boolean state) {
        this.state = state;
    }

    public void SetActive()
    {
        state = true;
    }
    public boolean isActive()
    {
        return state;
    }

    /**
     * Kills the movable that tries to step int this.
     */
    public void Kill(Movable m)
    {
        if(state == true) {
                m.Destroy();
            this.entites.clear();
        }}

    /**
     * For updating the Trap
     */
    @Override
    public void Update()
    {
        for(int i = 0; i < Game.getInstance().getLayout().GetFloorbases().size(); i++)
        {
            if(Game.getInstance().getLayout().GetFloorbases().get(i).getState())
            {
                state = true;
                return;
            }
        }
        ///Kill(this.entites.iterator().next());
        state = false;
    }

    /**
     * Kills or accepts the moveble according to its state.
     * @param m The to be accepted movavble.
     * @param d The direction which the accepted comes from.
     * @return
     */
    public boolean Accept(Movable m, Direction d, double s)
    {
        //if(this.getEntity()!=null){
        if(!entites.isEmpty()) {
            return super.Accept(m,d,s);
        }
        if(state==true){
            Kill(m);
            return true;
        }
        return true;
    }

    @Override
    public String toString() {
    	return "Trap";
    }
}
