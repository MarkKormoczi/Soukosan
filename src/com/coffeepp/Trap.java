package com.coffeepp;

public class Trap extends FloorBase implements Updatable {

    private boolean state;

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void Kill(Movable m)
    {
        m.Destroy();
    }
    @Override
    public void Update()
    {

    }
    public boolean Accept(Movable m, Direction d)
    {
        if(state==true){
            Kill(m);
            return true;
        }
        if(this.getEntity()!=null){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
    	return "Trap";
    }
}
