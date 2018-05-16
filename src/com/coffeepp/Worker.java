package com.coffeepp;

public class    Worker extends Movable {

    /**
     * Holds the points of this worker.
     */
    private int points;

    /**
     * Retruns the accumulated points of this worker.
     */

    public Worker()
    {
        this.setStrength(100);
    }
    public Worker(double _strength)
    {
        this.setStrength(_strength);
    }
    public int GetPoints()
    {
        return points;
    }

    /**
     * Moves the worker in the specified direction.
     */
    public void Move(Direction d) {
        FloorBase fl = this.getPlace().GetNeighbor(d);
        if (fl.Accept(this, d, this.GetStrength())) {

            if (this.getPlace() != null)
                this.getPlace().Remove(this);
            this.setPlace(fl);
            //System.out.println("OK");
        }
    }

    /**
     * Workes gets pushed. If called worker gets destroyed.
     * @param m The pusher that tries to push.
     * @param d The dirction which the worker was pushed.
     */
    @Override
    public boolean Push(Movable m, Direction d, double _strength)
    {
    	if(m.getClass().equals(Worker.class))
    	    //this.Move(d);
    	    ;
    	else {
            SetLastPusher(m);
            FloorBase pl= this.getPlace();
        /*if (d == Direction.up)
            d = Direction.down;
        else if (d == Direction.down)
            d = Direction.up;
        else if (d == Direction.left)
            d = Direction.right;
        else if (d == Direction.right)
            d = Direction.left;*/

            pl = pl.GetNeighbor(d);

            if(!pl.Accept(this, d, _strength ))
            {
                this.Destroy();
                pl.Accept(this, d, _strength);
                return true;
            }
            else
                {
                if(this.getPlace()!=null)
                    this.getPlace().Remove(this);
                this.setPlace(pl);
                pl.addEntity(this);
            }
            return true;
        }
            //this.Destroy();

    	/*if(_strength>=this.GetStrength()) {
    	    if(this.getPlace().GetNeighbor(d).Accept(this, d, this.GetStrength()))
                this.Move(d);
    	    else
    	        this.Destroy();
        }*/
        return true;
    }
    public void Destroy()
    {
        this.getPlace().entites.clear();
        this.setPlace(null);
        Game.getInstance().getLayout().GetWorkers().remove(this);
    }
    /**
     * Incrementing the point counter.
     */
    public void AddPoints()
    {
    	this.points += 1;
    }

    /**
     * Removes the liquid from the floor where the worker stands
     */
    public Liquid RemoveLiquid()
    {
        this.getPlace().setLiquid(new Liquid('N'));
        //dont you get fooled by the method name....
        return this.getPlace().getLiquid();
    }
    /**
     * Lays the given liquid to the floor where the worker stands
     * @param
     */
    public Liquid LaysLiquid(Liquid _liquid)
    {
        this.getPlace().setLiquid(_liquid);
        return  this.getPlace().getLiquid();
    }

    /**
     * Returns that the worker can"t switch the traps
     */
    public boolean SwitchCapable()
    {
        return false;
    }
    public Movable GetLasPusher()
    {
        return this;
    }
    @Override
    public String toString() {
    	return "Worker";
    }
}
