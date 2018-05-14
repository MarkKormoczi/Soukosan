package com.coffeepp;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class View {
    private Pane map;
    public  ArrayList<Drawable> drawables= new ArrayList<Drawable>();
    private Stage stage;
    private Scene scene;
    ObservableList list;
    public void SetStage(Stage stage, Window window)
    {
        stage = stage;
        scene = new Scene(drawAll(), 600,660);
        stage.setScene(scene);
        stage.show();
        StartGame();
    }
    public void StartGame()
    {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            }
        };
    }
    public Group drawAll(){
        Group root = new Group();
        ObservableList dList = root.getChildren();

        for (int i=0; i<drawables.size(); i++){
            Drawable dr= drawables.get(i);
            try {
                dr.Draw(dList);
                System.out.println(drawables.get(i).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //
        //Exit text
        Text exitText = new Text();
        exitText.setFont(new Font(35));
        exitText.setX(200);
        exitText.setY(400);
        exitText.setText("Test Text");
        dList.add(exitText);
        EventHandler<MouseEvent> exitEventHandler = e -> Platform.exit();
        exitText.addEventFilter(MouseEvent.MOUSE_CLICKED, exitEventHandler);
        //

        return root;

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
