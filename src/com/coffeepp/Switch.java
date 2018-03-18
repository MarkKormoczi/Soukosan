package com.coffeepp;

public class Switch extends FloorBase implements Updatable {

    private boolean state;
    private Trap trapdoor;


    public Trap getTrapdoor() {
        return trapdoor;
    }

    public void setTrapdoor(Trap trapdoor) {
        this.trapdoor = trapdoor;
    }


    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void Update() {

    }
    @Override
    public String toString() {
    	return "Switch";
    }
}
