package com.coffeepp;

public class Switch extends FloorBase implements Updatable {

    private boolean state;

    @Override
    public void Update() {

    }
    public boolean GetState()
    {
        return state;
    }
    @Override
    public String toString() {
    	return "Switch";
    }
}
