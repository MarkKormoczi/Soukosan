package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class View {
    private Pane map;
    private ArrayList<Drawable> drawables= new ArrayList<Drawable>();
    private Stage stage;
    private Scene scene;
    ObservableList list;
    public void SetStage(Stage stage, Window window)
    {
        stage = stage;
        Group root = new Group();
        list = root.getChildren();
        scene = new Scene(root, 600,660);
        stage.setScene(drawAll());
        stage.show();
    }
    public Scene drawAll(){
        Group root = new Group();
        ObservableList dList = root.getChildren();
        for (int i=0; i<drawables.size(); i++){
            Drawable dr= drawables.get(i);
            try {
                dr.Draw(dList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Scene(root, 600,660);

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
