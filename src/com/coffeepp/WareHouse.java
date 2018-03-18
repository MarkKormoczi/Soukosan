package com.coffeepp;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WareHouse
{
    private List<Worker> workers;
    private List<Crate> crates;
    private List<FloorBase> floorbases; //mindenki updateable

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

    public void AddWorker(Worker w){
        workers.add(w);
    }

    public void AddCrate(Crate c){
        crates.add(c);
    }

    public void AddFloorbase(FloorBase fb){
        floorbases.add(fb);
    }
    public void RemoveWorker(Worker w){
        workers.remove(w);
    }

    public void RemoveCrate(Crate c){
        crates.remove(c);
    }

    public void RemoveFloorbase(FloorBase fb){
        floorbases.remove(fb);
    }

    public List<Worker> GetWorkers()
    {
        return workers;
    }
    public List<Crate> GetCrates()
    {
        return crates;
    }
    public List<FloorBase> GetFloorbases()
    {
        return floorbases;
    }
    @Override
    public String toString() {
    	return "WareHouse";
    }
}
