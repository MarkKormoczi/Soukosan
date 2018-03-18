package com.coffeepp;

public class Hole extends FloorBase {
    public void Kill(Movable m)
    {
        m.Destroy();
    }
    public void Update()
    {

    }
    public boolean Accept(Movable m, Direction d)
    {
        return true;
    }
    public void Remove(Movable m)
    {

    }
}
