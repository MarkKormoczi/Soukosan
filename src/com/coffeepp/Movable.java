package com.coffeepp;

public abstract class Movable implements Updatable {

    public boolean Push(Movable m, Direction d)
    {
        return false;
    }
    public void Destroy()
    {

    }
    public void AddPoint()
    {

    }
    public boolean SwitchCapable()
    {
        return false;
    }
    public void Update()
    {

    }
}
