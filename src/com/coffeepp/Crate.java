package com.coffeepp;

public class Crate extends Movable {

    private Worker lastPusher;

    public Worker GetLastPusher()
    {
        return lastPusher;
    }
    public void Push(Direction d)
    {



    }
    public void AddPoints()
    {
        lastPusher.AddPoints();
    }
    public boolean SwitchCapable()
    {
        return true;
    }

    public void SetLastPusher(Worker w){
        lastPusher=w;
    }

    @Override
    public String toString() {
    	return "Crate";
    }
}
