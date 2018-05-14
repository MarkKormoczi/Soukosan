package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class View {
    private Pane map;
    private ArrayList<Drawable> drawables= new ArrayList<Drawable>();
    private Scene scene;
    ObservableList list;
    public void SetStage(Stage stage, Window window) throws FileNotFoundException {

        Group root = new Group();
        list = root.getChildren();
        scene = new Scene(root, 600,660);
        stage.setTitle("Soukosan");
        stage.setScene(scene);
        stage.show();
        drawAll(stage);
    }
    public void drawAll(Stage stage){
        for (int i=0; i<drawables.size(); i++){
            Drawable dr= drawables.get(i);
            try {
                dr.Draw(list);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.setTitle("Soukosan");
            stage.setScene(scene);
            stage.show();
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
