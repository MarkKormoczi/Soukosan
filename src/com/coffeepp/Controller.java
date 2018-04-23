package com.coffeepp;

public class Controller {
    static Game game;
    public Controller(Game game){
        this.game = game;
    }

    public static void Command(String input_raw){
        String[] input = input_raw.trim().split("\\s+");
        switch(input[0]){
            case "loadCommands": //Beolvassa és végrehajtja a fájlból beolvasott parancsokat
                //TODO Read commands from the file, for cycle
                break;

            case "newGame": //Betölti az első pályát
                break;

            case "loadLevel": //Betölti a megadott pályát
                String level = input[1]; //A betolteni kivant file neve
                //TODO write the loading from a file
                break;

            case "saveLevel": //Elmenti egy .txt fájlba az adott pálya állását
                //TODO same as previous but writes to file
                break;

            case "moveWorker": //A megadott irányba mozgatja a munkást
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

            case "showLevel": //Kirajzolja a pályát
                //TODO draw the map
                break;

            case "listFloorBases": //A betöltött pályán kilistázza a FloorBaseket
                for (FloorBase fb:game.getLayout().GetFloorbases()) {
                    System.out.println(fb.toString() + " " + fb.getEntity().toString() + " " );
                    fb.getEntity().toString();
                }
                break;

            case "listWorkers": //A betöltött pályán kilistázza a munkásokat
                break;

            case "listPoints": // Kilistázza a munkások pontjait
                break;

                //???
            case "winGame": //Minden láda a TargetSpoton található
                break;

                //???
            case "gameOver": //Egy ládát összetörünk és vége a játéknak
                break;



        }
    }
}
