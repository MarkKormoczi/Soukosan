package com.coffeepp;

public class Trap extends FloorBase implements Updatable {

    private boolean state;

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
        return false;
    }
    public void Remove()
    {

    }
    public boolean GetState()
    {
        return state;
    }
}
