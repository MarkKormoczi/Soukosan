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
        return strength;
    }
    public double GetWeight()
    {
        return weight;
    }
    public Movable GetLastPusher()
    {
        return lastPusher;
    }

    /**
     * The floor that this movable stands on.
     * @return
     */
    public FloorBase getPlace() {
        return place;
    }

    /**
     * Sets the this movable current location.
     * @param place The new standing point of this movable.
     */
    public void setPlace(FloorBase place) {
        this.place = place;
    }
    public void setWeight(double _weight) {
        this.weight = _weight;
    }
    public void setStrength(double _strength) {
        this.strength = _strength;
    }
    /**
     * Setst the Last pusher of this object.
     * @param w The last pusher.
     */
    public void SetLastPusher(Movable w){
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

        this.place = null;
        game.getLayout().GetWorkers().remove(this);
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

        //this.place = null;
    }
    @Override
    public String toString() {
    	return "Movable";
    }
}
