package com.coffeepp;

import javafx.event.EventHandler;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class View {
    private Pane map;
    public  ArrayList<Drawable> drawables= new ArrayList<Drawable>();
    private Stage stage;
    private Stage menu;
    private Scene scene;
    private boolean gameover = false;
    private boolean gamewon = false;


    ObservableList list;
    Window window;
    public void SetStage(Stage _stage, Window _window) throws IOException {

        window = _window;
        menu = _stage;
        stage = _stage;

        scene = new Scene(drawAll());
        stage.setScene(scene);
        Restart();

    }
    public void Update()
    {
        stage.setScene(new Scene(drawAll()));

    }
    public void Restart() throws IOException {
        drawables.clear();
        list.clear();
        gameover = false;
        Game.getInstance().Restart();
        Update();
    }
    public void ToMenu( )
    {
        gameover = true;
        Update();
    }
    public void GameWon( )
    {
        gamewon = true;
        Update();
    }

    public Group drawAll(){
        Group root = new Group();
         list = root.getChildren();
        for (int i=0; i<drawables.size(); i++){

            if(drawables.get(i).getZ()==0)
            {
                try {
                    if(!drawables.get(i).Draw(list))
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
                    if(!drawables.get(i).Draw(list))
                        drawables.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i=0; i < drawables.size(); i++){
            if(drawables.get(i).getZ() == 2)
            {
                try {
                    if(!drawables.get(i).Draw(list))
                        drawables.remove(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Text back = new Text();
        back.setFont(new Font(20));
        back.setX(stage.getWidth()-137);
        back.setY(17);
        back.setText("Back to menu");
        list.add(back);
        EventHandler<MouseEvent> exitEventHandler = e -> {
            try {

                drawables.clear();
                window.start(menu);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        };
        back.addEventFilter(MouseEvent.MOUSE_CLICKED, exitEventHandler);

        Text restart = new Text();
        restart.setFont(new Font(20));
        restart.setX(stage.getWidth()-125);
        restart.setY(45);
        restart.setText("Restart level");
        list.add(restart);
        EventHandler<MouseEvent> restartEventHandler = e -> {
            try {
                Restart();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        };

        restart.addEventFilter(MouseEvent.MOUSE_CLICKED, restartEventHandler);
        if(gameover)
        {
            Text exitText = new Text();
            exitText.setFont(new Font(50));
            exitText.setX(stage.getWidth()/2-160);
            exitText.setY(stage.getHeight()/2 -100);
            exitText.setText("  Game Over\nBack to menu");
            list.add(exitText);
            exitText.addEventFilter(MouseEvent.MOUSE_CLICKED, exitEventHandler);

            Text restartText = new Text();
            restartText .setFont(new Font(50));
            restartText .setX(stage.getWidth()/2-82);
            restartText .setY(stage.getHeight()/2+50);
            restartText .setText("Restart");
            list.add(restartText );
            restartText .addEventFilter(MouseEvent.MOUSE_CLICKED, restartEventHandler);
        }
        if(gamewon)
        {
            Text nextlevel = new Text();
            nextlevel.setFont(new Font(50));
            nextlevel.setX(stage.getWidth()/2-160);
            nextlevel.setY(stage.getHeight()/2 -100);
            nextlevel.setText("  Nice work\nNext Level");
            list.add(nextlevel);
            EventHandler<MouseEvent> nextlevelEventHandler = e -> {

                try {
                    File folder = new File("maps/");
                    File[] listOfFiles = folder.listFiles();
                    gamewon=false;
                    Game.getInstance().LoadMap(listOfFiles[Game.getInstance().getLevelnumber()].getAbsolutePath());
                    Update();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            };
            nextlevel.addEventFilter(MouseEvent.MOUSE_CLICKED, nextlevelEventHandler);

            Text exittext = new Text();
            exittext.setFont(new Font(50));
            exittext .setX(stage.getWidth()/2-82);
            exittext .setY(stage.getHeight()/2+50);
            exittext .setText("Back to menu");
            list.add(exittext );
            exittext .addEventFilter(MouseEvent.MOUSE_CLICKED, exitEventHandler);
        }
        //
        //Exit text


        //

        //Points
            if (Game.getInstance().getLayout().GetWorkers().size() > 0)
            {
                int offset_x=0;
                int offset_y=1;
                for(int i = 0; i< Game.getInstance().getLayout().GetWorkers().size(); ++i ) {
                    if(i%3==0)
                    {
                        offset_x++;
                        offset_y =1;
                    }
                    Text playerPoints = new Text();
                    playerPoints.setFont(new Font(15));
                    playerPoints.setX((offset_x-1)*80);
                    playerPoints.setY((offset_y)*15);
                    offset_y++;
                    playerPoints.setText("Player "+(i+1)+": "+ Game.getInstance().getLayout().GetWorkers().get(i).GetPoints());
                    list.add(playerPoints);
                }
            }
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
