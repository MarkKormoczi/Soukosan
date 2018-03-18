package com.coffeepp;

public abstract class Movable implements Updatable {



    private FloorBase place;
    private Movable lastPusher;

    public Movable GetLastPusher()
    {
        return lastPusher;
    }

    public FloorBase getPlace() {
        return place;
    }

    public void setPlace(FloorBase place) {
        this.place = place;
    }

    public void SetLastPusher(Movable w){
        lastPusher=w;
    }

    public boolean Push(Movable m, Direction d)
    {
        return false;
    }
    public void Destroy()
    {

    }
    public abstract void AddPoints();

    public abstract boolean SwitchCapable();
    public void Update()
    {

    }
    @Override
    public String toString() {
    	return "Movable";
    }
}
