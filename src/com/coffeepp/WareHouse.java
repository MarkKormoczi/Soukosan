package com.coffeepp;
import java.util.List;

public class WareHouse
{
    private List<Worker> workers;
    private List<Crate> crates;
    private List<FloorBase> floorbases;
    public void UpdateAll()
    {

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
}
