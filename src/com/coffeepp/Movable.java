package com.coffeepp;

public abstract class Movable implements Updatable {

    Game game = Game.getInstance();

    private FloorBase place;
    private Movable lastPusher;
    private double weight;
    private double strength;


    /**
     * The last movable that pushed this item.
     * @return
     */
    public double GetStrength()
    {
        Logger l = new Logger();
        l.enter(this, "GetStrength");
        l.exit(this, "GetStrength", Double.toString(strength));
        return strength;
    }
    public double GetWeight()
    {
        Logger l = new Logger();
        l.enter(this, "GetWeight");
        l.exit(this, "GetWeight", Double.toString(weight));
        return weight;
    }
    public Movable GetLastPusher()
    {
        Logger l = new Logger();
        l.enter(this, "GetLastPusher");
        l.exit(this, "GetLastPusher", lastPusher.toString());
        return lastPusher;
    }

    /**
     * The floor that this movable stands on.
     * @return
     */
    public FloorBase getPlace() {
        Logger l = new Logger();
        l.enter(this, "getPlace");
        if(place != null)
        l.exit(this, "getPlace", place.toString());
        return place;
    }

    /**
     * Sets the this movable current location.
     * @param place The new standing point of this movable.
     */
    public void setPlace(FloorBase place) {
        Logger l = new Logger();
        l.enter(this, "setPlace");
        l.exit(this, "setPlace", "void");
        this.place = place;
    }
    public void setWeight(double _weight) {
        Logger l = new Logger();
        l.enter(this, "setWeight");
        l.exit(this, "setWeight", "void");
        this.weight = _weight;
    }
    public void setStrength(double _strength) {
        Logger l = new Logger();
        l.enter(this, "setStrength");
        l.exit(this, "setStrength", "void");
        this.strength = _strength;
    }
    /**
     * Setst the Last pusher of this object.
     * @param w The last pusher.
     */
    public void SetLastPusher(Movable w){
        Logger l = new Logger();
        l.enter(this, "SetLastPusher");
        l.exit(this, "SetLastPusher", "void");
        lastPusher=w;
    }

    /**
     * Pushes this object in the soecified direction.
     * @param m The movable that tries to push
     * @param d The direction.
     * @return returns if the push was succesful.
     */

    abstract public boolean Push(Movable m, Direction d, double strength);

    /**
     * Destroys this movable.
     */
    public void Destroy()
    {
        Logger l = new Logger();
        l.enter(this, "Destroy");

        this.place = null;
        l.exit(this, "Destroy", "void");
    }

    /**
     * Incrementing the point counter.
     */
    public abstract void AddPoints();

    /**
     * Returns if the movable can switch the trap switches.
     */
    public abstract boolean SwitchCapable();

    /**
     *
     */
    public void Update()
    {
        Logger l = new Logger();
        l.enter(this, "Update");

        this.place = null;
        l.exit(this, "Update", "void");
    }
    @Override
    public String toString() {
    	return "Movable";
    }
}
