package com.coffeepp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
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

    }
    @Override
    public String toString() {
        return "Main";
    }
}
