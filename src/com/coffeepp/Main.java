package com.coffeepp;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        System.out.print("Sokoban-san");
        Logger.loggerInit();


        Game g = Game.getInstance();
        try {
            g.NewGame("map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Tester class call
        //Tester tester = new Tester();
        //tester.startTester();

        Controller.setGame(g);
        //From console
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
