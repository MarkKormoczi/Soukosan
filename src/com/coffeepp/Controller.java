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

            case "addCrate": //Hozzáad egy FloorBase-hez egy ládát

                break;

            case "addWorker": //Hozzáad egy FloorBase-hez egy munkást
                break;

            case "moveWorker": //A megadott irányba mozgatja a munkást
                break;

            case "addPoint": //Pontot ad a munkásnak
                break;

            case "destroyCrate": //Egy ládát lyukba tolunk és az eltűnik
                break;

            case "destroyWorker": //A munkás egy lyukra lép és elpusztul
                break;

            case "pushCrate": //A megadott irányba mozog a munkás, és eltolja az ott található ládát
                break;

            case "cratePushCrate": //A láda ami éppen mozog egy irányban eltol egy másik ládát ami az útjában áll
                break;

            case "cratePushWorker": //Munkás eltol egy ládát ami mögött egy munkás áll és így a munkást is tolja
                break;

            case "workerLaysLiquid": //A munkás a jelenlegi pozíciójára kiönt valamilyen folyadékot
                break;

            case "workerRemovesLiquid": //A munkás a jelenlegi pozícióján feltakarítja a folyadékot, ha van
                break;

            case "showLevel": //Kirajzolja a pályát

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
