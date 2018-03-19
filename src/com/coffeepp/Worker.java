package com.coffeepp;

public class Worker extends Movable {

    /**
     * Holds the points of this worker.
     */
    private int points;

    /**
     * Retruns the accumulated points of this worker.
     */
    public int GetPoints()
    {
    	Logger l = new Logger();
    	l.enter(this, "GetPoints");
    	
    	l.exit(this, "GetPoints", Integer.toString(points));
        return points;
    }

    /**
     * Moves the worker in the specified direction.
     */
    public void Move(Direction d)
    {
    	Logger l = new Logger();
    	l.enter(this, "Move", d.toString());

        if ( this.getPlace().GetNeighbor(d).Accept(this, d) )
            this.getPlace().Remove(this);

    	l.exit(this, "Move", "void");
    }

    /**
     * Workes gets pushed. If called worker gets destroyed.
     * @param m The pusher that tries to push.
     * @param d The dirction which the worker was pushed.
     */
    @Override
    public boolean Push(Movable m, Direction d)
    {
    	Logger l = new Logger();
    	l.enter(this, "Push", d.toString());

    	this.Destroy();

    	l.exit(this, "Push", "false");
        return false;
    }

    /**
     * Incrementing the point counter.
     */
    public void AddPoints()
    {
    	Logger l = new Logger();
    	l.enter(this, "AddPoints");
    	
    	this.points += 1;

    	l.exit(this, "AddPoints", "void");
    }

    /**
     * Returns that the worker can"t switch the traps
     */
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
