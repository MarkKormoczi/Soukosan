package com.coffeepp;

public class Floor extends FloorBase {
    public boolean Accept(Movable m, Direction d)
    {
        return true;
    }
    @Override
    public String toString() {
    	return "Floor";
    }
}
