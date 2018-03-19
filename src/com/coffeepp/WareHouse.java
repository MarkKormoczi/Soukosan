package com.coffeepp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the Game location with floors crates and worksers.
 */
public class WareHouse
{
    private List<Worker> workers = new ArrayList<Worker>();
    private List<Crate> crates = new ArrayList<Crate>();
    private List<FloorBase> floorbases = new ArrayList<FloorBase>(); //mindenki updateable

    /**
     * Updates all updatable items
     */
    public void UpdateAll()
    {
        Logger l = new Logger();
        l.enter(this, "UpdateAll");

        Worker w;
        Crate c;
        FloorBase fb;

        for(int i=0; i<workers.size(); i++) {
            w = workers.get(i);
            w.Update();
        }

        for(int i=0; i<crates.size(); i++) {
            c = crates.get(i);
            c.Update();
        }

        for(int i=0; i<floorbases.size(); i++) {
            fb = floorbases.get(i);
            fb.Update();
        }
        l.exit(this, "UpdateAll", "void");
    }

    /**
     * Adds a worker the the Worker list.
     * @param w The Worker to be added
     */
    public void AddWorker(Worker w){
        Logger l = new Logger();
        l.enter(this, "AddWorker");
        workers.add(w);
        l.exit(this, "AddWorker", "void");
    }

    /**
     * Adds a Crate to the Crate list
     * @param c The Crate to be added
     */
    public void AddCrate(Crate c){
        Logger l = new Logger();
        l.enter(this, "AddCrate");
        crates.add(c);
        l.exit(this, "AddPoints", "void");
    }

    /**
     * Adds a Floorbase to the Floorbase list
     * @param fb The Floorbase to be added.
     */
    public void AddFloorbase(FloorBase fb){
        Logger l = new Logger();
        l.enter(this, "AddFloorbase");

        floorbases.add(fb);
        l.exit(this, "AddFloorbase", "void");
    }

    /**
     * Removes a worker from the Worker List.
     * @param w The Worker to be removed.
     */
    public void RemoveWorker(Worker w){
        Logger l = new Logger();
        l.enter(this, "RemoveWorker");
        workers.remove(w);
        l.exit(this, "RemoveWorker", "void");
    }

    /**
     * Removes a Crate from the Crate List.
     * @param c The Crate to be removed.
     */
    public void RemoveCrate(Crate c){
        Logger l = new Logger();
        l.enter(this, "RemoveCrate");
        crates.remove(c);
        l.exit(this, "RemoveCrate", "void");

    }

    /**
     * Removes a Floorbase from the Floorbase List.
     * @param fb The Floorbase to be removed.
     */
    public void RemoveFloorbase(FloorBase fb){
        Logger l = new Logger();
        l.enter(this, "RemoveFloorbase");
        floorbases.remove(fb);
        l.exit(this, "RemoveFloorbase", "void");
    }

    /**
     * Returns the WorkerList
     * @return
     */
    public List<Worker> GetWorkers()
    {
        Logger l = new Logger();
        l.enter(this, "GetWorkers");
        l.exit(this, "GetWorkers", "WorkerList");
        return workers;
    }

    /**
     * Returns the Crate List
     * @return
     */
    public List<Crate> GetCrates()
    {
        Logger l = new Logger();
        l.enter(this, "GetCrates");
        l.exit(this, "GetCrates", "CrateList");
        return crates;
    }

    /**
     * Returns the FloorBase List
     * @return
     */
    public List<FloorBase> GetFloorbases()
    {
        Logger l = new Logger();
        l.enter(this, "GetCrates");
        l.exit(this, "GetCrates", "FloorBaserList");
        return floorbases;
    }
    @Override
    public String toString() {
    	return "WareHouse";
    }
}
