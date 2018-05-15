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
import java.util.*;
import java.util.List;

public class View {
    private Pane map;
    public  ArrayList<Drawable> drawables= new ArrayList<Drawable>();
    private Stage stage;
    private Scene scene;
    ObservableList list;
    private int cnt = 0;
    public void SetStage(Stage _stage, Window window)
    {
        stage = _stage;
        scene = new Scene(drawAll());
        stage.setScene(scene);


       // StartTimer(stage);
    }
    public void Update()
    {
        stage.setScene(new Scene(drawAll()));

    }
    public void StartTimer(Stage s)
    {

        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            public void run()
            {
                System.out.println(cnt++);
                //Update();
            }
        };
        timer.scheduleAtFixedRate(task, 500, 500);


    }
    public int compareTo(int o1, int o2) {
        int v1 = (o1);
        int v2 = (o2);
        if(v1 == v2) {
            return 0;
        }
        if(v1 < v2) {
            return 2; //return negative integer if first argument is less than second
        }
        return 1;
    }

    public Group drawAll(){
        Group root = new Group();
        ObservableList dList = root.getChildren();
       // drawables.sort(e->e.getZ());
        for (int i=0; i<drawables.size(); i++){

            if(drawables.get(i).getZ()==0)
            {
                try {
                    if(!drawables.get(i).Draw(dList))
                        drawables.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i=0; i < drawables.size(); i++){
            if(drawables.get(i).getZ()==1)
            {
                try {
                    if(!drawables.get(i).Draw(dList))
                        drawables.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i=0; i < drawables.size(); i++){
            if(drawables.get(i).getZ()==2)
            {
                try {
                    if(!drawables.get(i).Draw(dList))
                        drawables.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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

        //Points
        /*Text player1Points = new Text();
        player1Points.setFont(new Font(25));
        player1Points.setX(10);
        player1Points.setY(40);
        player1Points.setText("Player 1: " + Game.getInstance().getLayout().GetWorkers().get(0).GetPoints());
        dList.add(player1Points);

        if (Game.getInstance().getLayout().GetWorkers().size() > 1) {
            Text player2Points = new Text();
            player2Points.setFont(new Font(25));
            player2Points.setX(140);
            player2Points.setY(40);
            player2Points.setText("Player 2: " + Game.getInstance().getLayout().GetWorkers().get(1).GetPoints());
            dList.add(player2Points);
        }*/

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
