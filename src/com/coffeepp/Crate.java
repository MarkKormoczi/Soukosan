package com.coffeepp;

public class Crate extends Movable {
    private Worker lastPusher;
    public Worker GetLastPusher()
    {
        return lastPusher;
    }
    public boolean Push(Direction d)
    {
        return false;
    }
    public void AddPoints()
    {

    }
    public boolean SwitchCapable()
    {
        return true;
    }


}
