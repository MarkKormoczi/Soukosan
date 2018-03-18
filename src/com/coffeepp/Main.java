package com.coffeepp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.print("Sokoban-san");
        Logger.loggerInit();


        Game g = new Game();
        try {
            g.NewGame();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Tester class call
        Tester tester = new Tester();
        tester.startTester();

    }
    @Override
    public String toString() {
    	return "Main";
    }
}
