package com.coffeepp;

public class Worker extends Movable {

    private int points;
    public int GetPoints()
    {
    	Logger l = new Logger();
    	l.enter(this, "GetPoints");
    	
    	l.exit(this, "GetPoints", Integer.toString(points));
        return points;
    }
    public void Move(Movable m, Direction d)
    {
    	Logger l = new Logger();
    	l.enter(this, "Move", d.toString());
    	
    	l.exit(this, "Move", "void");
    }
    public boolean Push(Direction d)
    {
    	Logger l = new Logger();
    	l.enter(this, "Push", d.toString());
    	
    	l.exit(this, "Push", "false");
        return false;
    }
    public void AddPoints()
    {
    	Logger l = new Logger();
    	l.enter(this, "AddPoints");
    	
    	
    	l.exit(this, "AddPoints", "void");
    }
    public boolean SwitchCapable()
    {
    	Logger l = new Logger();
    	l.enter(this, "SwitchCapable");
    	
    	l.exit(this, "SwitchCapable", "false");
        return false;
    }
    @Override
    public String toString() {
    	return "Worker";
    }
}
