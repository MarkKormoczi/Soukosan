package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class View {
    private Pane map;
    private ArrayList<Drawable> drawables= new ArrayList<Drawable>();
    private Stage stage;
    ObservableList list;
    public void SetStage(Stage stage, Window window)
    {
        stage = stage;
        Group root = new Group();
        list = root.getChildren();
    }
    public void drawAll(){
        for (int i=0; i<drawables.size(); i++){
            Drawable dr= drawables.get(i);
            try {
                dr.Draw(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void LoadDrawables()
    {
        List<FloorBase> f = (List<FloorBase>) Game.getInstance().getLayout();
        for (int i = 0; i < f.size(); i++)
        {
           // drawables.add();
        }

    }

    public void addCrate(Graphic_Crate m){drawables.add(m);}

    public void addMovable(Graphic_Movable m) {
        drawables.add(m);
    }

    public void addWorker(Graphic_Worker w){
        drawables.add(w);
    }

    public void addFloorBase(Graphic_FloorBase fb){
        drawables.add(fb);
    }

    public void addLiquid(Graphic_Liquid l){
        drawables.add(l);
    }

    public void removeMovable(Graphic_Movable m){
        drawables.remove(m);
    }

    public void removeLiquid(Graphic_Liquid l){
        drawables.remove(l);
    }

}
