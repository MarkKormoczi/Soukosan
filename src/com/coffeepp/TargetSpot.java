package com.coffeepp;

public class TargetSpot extends FloorBase {
    public boolean Accept(Movable m, Direction d)
    {
        return true;
    }
    @Override
    public String toString() {
    	return "TargetSpot";
    }
}
