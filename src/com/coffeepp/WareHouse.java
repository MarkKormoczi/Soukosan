package com.coffeepp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents the Game location with floors crates and worksers.
 */
public class WareHouse {
    private List<Worker> workers = new ArrayList<Worker>();
    private List<Crate> crates = new ArrayList<Crate>();
    private List<FloorBase> floorbases = new ArrayList<FloorBase>(); //mindenki updateable
    private int badspots;
    /**
     * Updates all updatable items
     */
    public void Clear()
    {
        workers.clear();
        crates.clear();
        floorbases.clear();
    }
    public void UpdateAll()
    {

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
    }

    /**
     * Adds a worker the the Worker list.
     * @param w The Worker to be added
     */
    public void AddWorker(Worker w){
        workers.add(w);
    }

    /**
     * Adds a Crate to the Crate list
     * @param c The Crate to be added
     */
    public void AddCrate(Crate c){
        crates.add(c);
    }

    /**
     * Adds a Floorbase to the Floorbase list
     * @param fb The Floorbase to be added.
     */
    public void AddFloorbase(FloorBase fb){

        floorbases.add(fb);
    }

    /**
     * Removes a worker from the Worker List.
     * @param w The Worker to be removed.
     */
    public void RemoveWorker(Worker w){
        workers.remove(w);
    }

    /**
     * Removes a Crate from the Crate List.
     * @param c The Crate to be removed.
     */
    public void RemoveCrate(Crate c){
        crates.remove(c);
    }

    /**
     * Removes a Floorbase from the Floorbase List.
     * @param fb The Floorbase to be removed.
     */
    public void RemoveFloorbase(FloorBase fb){
        floorbases.remove(fb);
    }

    /**
     * Returns the WorkerList
     * @return
     */
    public List<Worker> GetWorkers()
    {
        return workers;
    }

    /**
     * Returns the Crate List
     * @return
     */
    public List<Crate> GetCrates()
    {
        return crates;
    }

    /**
     * Returns the FloorBase List
     * @return
     */

    public List<FloorBase> GetFloorbases()
    {
        return floorbases;
    }
    @Override
    public String toString() {
    	return "WareHouse";
    }
    public void InitBadSpots(int i)
    {
        badspots = i;
    }
    public void DecreaseBadSpot()
    {
        badspots--;
    }
    public boolean isAnyBadSpots()
    {
        return 0 == badspots;
    }
}
