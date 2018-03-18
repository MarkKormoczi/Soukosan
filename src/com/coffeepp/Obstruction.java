package com.coffeepp;

public class Obstruction extends FloorBase {
    public boolean Accept(Movable m, Direction d)
    {
        return true;
    }
    public void Remove(Movable m)
    {   }
}
