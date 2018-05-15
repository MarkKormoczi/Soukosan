package com.coffeepp;

public class Trap extends FloorBase implements Updatable {

    private boolean state;

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
     * @param m The movable to be killed.
     */
    public void Kill(Movable m)
    {
        if(state)
        m.Destroy();
    }

    /**
     * For updating the Trap
     */
    @Override
    public void Update()
    {
        for(int i = 0; i < Game.getInstance().getLayout().GetFloorbases().size(); i++)
        {            System.out.println(Game.getInstance().getLayout().GetFloorbases().get(i).getState());

            if(Game.getInstance().getLayout().GetFloorbases().get(i).getState())
            {
                state = true;
                return;
            }
        }
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
        if(state==true){
            Kill(m);
            return true;
        }
        //if(this.getEntity()!=null){
        if(!entites.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return "Trap";
    }
}
