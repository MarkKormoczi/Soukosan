package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class View {
    private Pane map;
    private ArrayList<Drawable> drawables;
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
                dr.Draw();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //még nincs kész
    public void addCrate(Crate m){
       // drawables.add(m);
    }

    public void addWorker(Worker w){
        //drawables.add(w);
    }

    public void addFloorBase(FloorBase fb){
        //drawables.add(fb);
    }

    public void addLiquid(Liquid l){
        //drawables.add(l);
    }

    public void removeMovable(Movable m){
        drawables.remove(m);
    }

    public void removeLiquid(Liquid l){
        drawables.remove(l);
    }

}
