package com.coffeepp;

public class TargetSpot extends FloorBase {
    public boolean Accept(Movable m, Direction d)
    {

        if(this.getEntity()!=null){
            m.AddPoints();
            return true;
        }

        return false;

    }
    @Override
    public String toString() {
    	return "TargetSpot";
    }
}
