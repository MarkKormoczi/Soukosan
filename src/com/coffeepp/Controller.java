package com.coffeepp;

import java.io.IOException;

public class Controller {
    static Game game;
    public Controller(){

    }

    public static void setGame (Game gameArg){game = gameArg;}
    public static void Command(String input_raw) throws IOException {
        String[] input = input_raw.trim().split("\\s+");
        switch(input[0].toLowerCase()){
            case "loadcommands": //Beolvassa és végrehajtja a fájlból beolvasott parancsokat
                //TODO Read commands from the file, for cycle
                break;

            case "loadlevel": //Betölti a megadott pályát
                String level = input[1]; //A betolteni kivant file neve
                game.LoadMap(level);
                break;

            case "moveworker": //A megadott irányba mozgatja a munkást
                int workerIndex = Integer.parseInt(input[1]);
                String direction = input[2];
                Worker currentWorker = game.getLayout().GetWorkers().get(workerIndex);
                switch (direction.toLowerCase()){
                    case "left": currentWorker.Move(Direction.left); break;
                    case "right": currentWorker.Move(Direction.right); break;
                    case "up": currentWorker.Move(Direction.up); break;
                    case "down": currentWorker.Move(Direction.down); break;
                }
                break;

            case "showlevel": //Kirajzolja a pályát
                game.ShowLevel();
                break;

            case "listfloorbases": //A betöltött pályán kilistázza a FloorBaseket
                for (FloorBase fb:game.getLayout().GetFloorbases()) {
                    if(fb != null){
                        if(fb.getEntity() != null)
                            System.out.println(fb.toString() + " and there is " + fb.getEntity().toString() + " on it.");
                        else
                            System.out.println(fb.toString());
                    }
                }
                break;

            case "listworkers": //A betöltött pályán kilistázza a munkásokat
                for (Worker w:game.getLayout().GetWorkers()) {
                    System.out.println(w.toString() + " Number " + game.getLayout().GetWorkers().indexOf(w));
                }
                break;

            case "listpoints": // Kilistázza a munkások pontjait
                for (Worker w:game.getLayout().GetWorkers()) {
                    System.out.println(w.toString() + ": " + w.GetPoints());
                }
                break;


        }
    }
}
