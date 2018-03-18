package com.coffeepp;

public class Main {

    public static void main(String[] args) {
        System.out.print("Sokoban-san");
        Logger.loggerInit();

        //Tester class call
        Tester tester = new Tester();
        tester.startTester();

    }
}
