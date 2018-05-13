package com.coffeepp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main{


    public static void main(String[] args) throws IOException{

        Window window = new Window();
        window.run(args);

        /*
        System.out.println("Sokoban-san");
        Logger.loggerInit();


        Game g = Game.getInstance();
        try {
            g.LoadMap("map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Tester class call
        //Tester tester = new Tester();
        //tester.startTester();

        Controller.setGame(g);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            Controller.Command(br.readLine());
        }
        */

    }
    @Override
    public String toString() {
        return "Main";
    }
}
