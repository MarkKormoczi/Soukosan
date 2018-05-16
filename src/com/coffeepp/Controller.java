package com.coffeepp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
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
                String fileName = input[1];
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintStream ps = new PrintStream(baos);
                PrintStream old = System.out;
                System.setOut(ps);

                TestProcessor tp = new TestProcessor(baos);
                tp.ProcessTest(fileName);

                System.out.flush();
                System.setOut(old);
                System.out.println(baos.toString());
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
                    case "left": currentWorker.Move(Direction.left);
                    Game.getInstance().getView().Update();
                    game.ShowLevel();
                        break;
                    case "right": currentWorker.Move(Direction.right);
                        game.ShowLevel();
                    Game.getInstance().getView().Update();
                        break;
                    case "up": currentWorker.Move(Direction.up);
                    Game.getInstance().getView().Update();game.ShowLevel();
                        break;
                    case "down": currentWorker.Move(Direction.down);
                    Game.getInstance().getView().Update();
                    game.ShowLevel();
                        break;
                }
                break;

            case "showlevel": //Kirajzolja a pályát
                game.ShowLevel();
                break;

            case "listfloorbases": //A betöltött pályán kilistázza a FloorBaseket
                for (FloorBase fb:game.getLayout().GetFloorbases()) {
                    if(fb != null){
                        // TODO WOREK REW
                        //if(fb.getEntity() != null)
                        //    System.out.println(fb.toString() + " and there is " + fb.getEntity().toString() + " on it.");
                        //else
                        //    System.out.println(fb.toString());
                    }
                }
                break;

            case "listworkers": //A betöltött pályán kilistázza a munkásokat
                for (Worker w:game.getLayout().GetWorkers()) {
                    System.out.println(w.toString() + " Number " + game.getLayout().GetWorkers().indexOf(w));
                }
                if(game.getLayout().GetWorkers().size() == 0)
                    System.out.println("No workers.");
                break;

            case "listswitchstates": //Kiirja a Switch-ek allapotat.
                for (FloorBase fb:game.getLayout().GetFloorbases()) {
                    if(fb instanceof Switch) {
                        if(((Switch) fb).getState())
                            System.out.println(fb.toString()+" enabled");
                        else
                            System.out.println(fb.toString()+" disabled");
                    }
                }
                break;

            case "listpoints": // Kilistázza a munkások pontjait
                for (Worker w:game.getLayout().GetWorkers()) {
                    System.out.println(w.toString() + ": " + w.GetPoints());
                }
                break;


        }
    }

    public static void WorkerControl(int workerIndex, Direction d){
        Worker currentWorker = null;
        if(Game.getInstance().getLayout().GetWorkers().size() >= workerIndex+1)
            currentWorker = Game.getInstance().getLayout().GetWorkers().get(workerIndex);
        if(currentWorker != null) {
            switch (d) {
                case left:
                    currentWorker.Move(Direction.left);
                    break;
                case right:
                    currentWorker.Move(Direction.right);
                    break;
                case up:
                    currentWorker.Move(Direction.up);
                    break;
                case down:
                    currentWorker.Move(Direction.down);
                    break;

            }
            Game.getInstance().getLayout().UpdateAll();
            Game.getInstance().getView().drawAll();
            Game.getInstance().getView().Update();

            System.out.println("Worker " + workerIndex + " Direction " + d.toString()+" "+ Game.getInstance().getLayout().GetWorkers().size());
        }
    }

    public static void LiquidControl(int workerIndex, Liquid l){
        Worker currentWorker = null;
        currentWorker = Game.getInstance().getLayout().GetWorkers().get(workerIndex);
        if (currentWorker != null) {
            if (l != null) {
                if(l.getName().equals("Oil"))
                    Game.getInstance().getView().addLiquid(new Graphic_Oil( currentWorker.LaysLiquid(l)));
                else
                    Game.getInstance().getView().addLiquid(new Graphic_Honey(currentWorker.LaysLiquid(l)));
            }
            else {
                Liquid liq= currentWorker.getPlace().getLiquid();
                currentWorker.RemoveLiquid();
                Game.getInstance().getView().removeLiquid(new Graphic_Liquid(liq));
            }

        }
    }
}
