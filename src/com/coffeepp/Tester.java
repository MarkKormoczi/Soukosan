package com.coffeepp;

import java.lang.annotation.Target;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

/**
 * @author Mark
 *Tester class, responsible for testing the listed cases.
 */

public class Tester {
    Scanner sc = new Scanner(System.in);
    public Tester(){


    }

    //Initialize a tester
    public void startTester(){
        while(true){
            System.out.print("Choose test case: \n" +
                    "\t1 Initialize a map\n" +
                    "\t2 Worker moves\n" +
                    "\t3 Worker pushes Crate\n" +
                    "\t4 Worker pushed\n" +
                    "\t5 Crate pushed\n" +
                    "\t6 Update cycle\n" +
                    "\t7 Add point\n" +
                    "\t8 Destroy Crate\n" +
                    "\t9 Destroy Worker\n" +
                    "\t10 New game\n" +
                    "\t11 Game over\n" +
                    "\n\nEnter your choice: ");

            String input = sc.nextLine();

            switch(input){
                case "1": //During the first test case, the steps of the map creation is logged
                    //Default 3x3 map plus border around it, with a Worker in the middle
                    Game game3x3 = Game.getInstance();
                    WareHouse wh3x3 = new WareHouse();
                    Worker player3x3 = new Worker();
                    FloorBase[][] floorBases3x3 = new FloorBase[4][4];
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (i == 0 || i == 3 || j == 0 || j == 3) floorBases3x3[i][j] = new Obstruction();
                            else floorBases3x3[i][j] = new Floor();

                            if (i > 0) floorBases3x3[i][j].setNeighbor(floorBases3x3[i - 1][j], Direction.left);
                            if (i < 3) floorBases3x3[i][j].setNeighbor(floorBases3x3[i + 1][j], Direction.right);
                            if (j > 0) floorBases3x3[i][j].setNeighbor(floorBases3x3[i][j - 1], Direction.down);
                            if (j < 3) floorBases3x3[i][j].setNeighbor(floorBases3x3[i][j + 1], Direction.up);

                            wh3x3.AddFloorbase(floorBases3x3[i][j]);
                        }
                    }
                    wh3x3.AddWorker(player3x3);
                    System.out.println("Map created.\n");
                    break;
                case "2":
                    System.out.print("\n~Empty fields in every test case\n" +
                            "\t2.1 Worker moves to Floor\n" +
                            "\t2.2 Worker moves to Obstruction\n" +
                            "\t2.3 Worker moves to Hole\n" +
                            "\t2.4 Worker moves to Enabled Trap\n" +
                            "\t2.5 Worker moves to Switch\n" +
                            "\n\nEnter your choice: ");

                    String altInput = sc.nextLine();

                    switch (altInput){
                        case "2.1": {
                            Floor f1 = new Floor();
                            Floor f2 = new Floor();
                            Worker w1 = new Worker();
                            f1.setNeighbor(f2, Direction.right);
                            f2.setNeighbor(f1, Direction.left);

                            f1.setEntity(w1);
                            w1.setPlace(f1);

                            w1.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Floor.\n");
                            break;
                        }
                        case "2.2": {
                            Floor f1 = new Floor();
                            Obstruction f2 = new Obstruction();
                            Worker w1 = new Worker();
                            f1.setNeighbor(f2, Direction.right);
                            f2.setNeighbor(f1, Direction.left);

                            f1.setEntity(w1);
                            w1.setPlace(f1);

                            w1.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Obstruction.\n");
                            break;
                        }
                        case "2.3": {
                            Floor f1 = new Floor();
                            Hole f2 = new Hole();
                            Worker w1 = new Worker();
                            f1.setNeighbor(f2, Direction.right);
                            f2.setNeighbor(f1, Direction.left);

                            f1.setEntity(w1);
                            w1.setPlace(f1);

                            w1.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Hole.\n");
                            break;
                        }
                        case "2.4":
                            Floor f1_4 = new Floor();
                            Trap f2_4 = new Trap();
                            f2_4.setState(true); //Enabling trap
                            Worker w1_4 = new Worker();
                            f1_4.setNeighbor(f2_4, Direction.right);
                            f2_4.setNeighbor(f1_4, Direction.left);

                            f1_4.setEntity(w1_4);
                            w1_4.setPlace(f1_4);

                            w1_4.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Enabled Trap.\n");
                            break;

                        case "2.5":
                            Floor f1_5 = new Floor();
                            Switch f2_5 = new Switch();
                            Worker w1_5 = new Worker();
                            f1_5.setNeighbor(f2_5, Direction.right);
                            f2_5.setNeighbor(f1_5, Direction.left);

                            f1_5.setEntity(w1_5);
                            w1_5.setPlace(f1_5);

                            w1_5.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Switch.\n");
                            break;

                        default:
                            System.out.println("Invalid command.\n");


                    }
                    break;
                case "3": //Worker pushed Crate
                    System.out.print(
                            "\t3.1 Successful\n" +
                            "\t3.2 Hits Obstruction\n" +
                            "\n\nEnter your choice: ");

                    String altInput_2 = sc.nextLine();

                    switch (altInput_2){
                        case "3.1": //Simply pushes Crate to another Floor
                            Floor f1_1 = new Floor();
                            Floor f2_1 = new Floor();
                            Floor f3_1 = new Floor();
                            Worker w1_1 = new Worker();
                            Crate c_1 = new Crate();
                            f1_1.setNeighbor(f2_1, Direction.right);
                            f2_1.setNeighbor(f1_1, Direction.left);
                            f2_1.setNeighbor(f3_1, Direction.right);
                            f3_1.setNeighbor(f2_1, Direction.left);

                            f1_1.setEntity(w1_1);
                            f2_1.setEntity(c_1);
                            w1_1.setPlace(f1_1);
                            c_1.setPlace(f2_1);

                            w1_1.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker pushed Crate successfully.\n");
                            break;

                        case "3.2": //Crate hits Obstruction
                            Floor f1_2 = new Floor();
                            Floor f2_2 = new Floor();
                            Obstruction f3_2 = new Obstruction();
                            Worker w1_2 = new Worker();
                            Crate c_2 = new Crate();
                            f1_2.setNeighbor(f2_2, Direction.right);
                            f2_2.setNeighbor(f1_2, Direction.left);
                            f2_2.setNeighbor(f3_2, Direction.right);
                            f3_2.setNeighbor(f2_2, Direction.left);

                            f1_2.setEntity(w1_2);
                            f2_2.setEntity(c_2);
                            w1_2.setPlace(f1_2);
                            c_2.setPlace(f2_2);

                            w1_2.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker pushed Crate unsuccessfully.\n");
                            break;

                        default:
                            System.out.println("Invalid command.\n");


                    }
                    break;

                case "4":{// Worker pushed to Obstruction and dies brutally
                    Worker w1 = new Worker();
                    Floor f1 = new Floor();
                    Crate c1 = new Crate();
                    Obstruction f2 = new Obstruction();
                    f1.setNeighbor(f2, Direction.right);
                    f2.setNeighbor(f1, Direction.left);

                    f1.setEntity(w1);
                    w1.setPlace(f1);

                    w1.Push(c1, Direction.left); // Poor guy got casted into a bloodpool on the Obstruction

                    System.out.println("Worker got pushed to the wall. The end.\n");
                    break;
                }

                case "5":{//Crate pushed
                    Crate c1 = new Crate();
                    Crate c2 = new Crate();
                    Floor f1 = new Floor();
                    Floor f2 = new Floor();
                    Floor f3 = new Floor();
                    Floor f4 = new Floor();
                    f1.setNeighbor(f2, Direction.right);
                    f2.setNeighbor(f1, Direction.left);
                    f2.setNeighbor(f3, Direction.right);
                    f3.setNeighbor(f2, Direction.left);
                    f3.setNeighbor(f4, Direction.right);
                    f4.setNeighbor(f3, Direction.left);

                    f1.setEntity(c2); //Pushing Crate
                    c2.setPlace(f1);

                    f2.setEntity(c1); //Pushed Crate
                    c1.setPlace(f2);

                    c1.Push(c2, Direction.right);
                    break;
                }
                case "6":{ // Update cycle
                    Game game = Game.getInstance();
                    game.getLayout().UpdateAll();
                    System.out.println("Updated.");
                    break;
                }
                case "7":{//Add point - Worker pushed Crate, pushes Crate to TargetSpot
                    Floor f1 = new Floor();
                    Floor f2 = new Floor();
                    Floor f3 = new Floor();
                    TargetSpot f4 = new TargetSpot();

                    f1.setNeighbor(f2, Direction.right);

                    f2.setNeighbor(f1, Direction.left);
                    f2.setNeighbor(f3, Direction.right);

                    f3.setNeighbor(f2, Direction.left);
                    f3.setNeighbor(f4, Direction.right);

                    f4.setNeighbor(f3, Direction.left);

                    Worker w = new Worker(); //Add Worker
                    f1.setEntity(w);
                    w.setPlace(f1);

                    Crate c1 = new Crate(); // Add Crate
                    f2.setEntity(c1);
                    c1.setPlace(f2);

                    Crate c2 = new Crate(); // Add Crate
                    f3.setEntity(c2);
                    c2.setPlace(f3);

                    w.Move(Direction.right);
                    System.out.println("Crate moved, point added.");
                    break;

                }

                case "8":{//Destroy Crate
                    Worker monika = new Worker();
                    Crate ink = new Crate();
                    Floor floor = new Floor();
                    Floor floor2 = new Floor();
                    Hole puddle = new Hole();

                    floor.setNeighbor(puddle, Direction.right);
                    puddle.setNeighbor(floor, Direction.left);

                    floor2.setNeighbor(floor, Direction.right);
                    floor.setNeighbor(floor2, Direction.left);

                    floor.setEntity(ink);
                    ink.setPlace(floor);

                    monika.setPlace(floor2);
                    floor2.setEntity(monika);

                    ink.Push(monika, Direction.right);
                    System.out.println("The ink flows down into a dark puddle.");
                    break;

                }
                case "9":{//Seppuku
                    Worker w = new Worker();
                    w.Destroy();
                    System.out.print("Life is meaningless - Worker#1023");
                    break;
                }
                case "10":{//New game
                    Game game = Game.getInstance();
                    game.SetLevel(1);
                    System.out.print("Level set");
                    break;
                }
                case "11":{//Game over when a Crate gets destroyed... rip Crate 2018-2018
                    Floor f1 = new Floor();
                    Floor f2 = new Floor();
                    Hole f3 = new Hole();

                    f1.setNeighbor(f2, Direction.right);
                    f2.setNeighbor(f3, Direction.right);
                    f3.setNeighbor(f2, Direction.left);
                    f2.setNeighbor(f1, Direction.left);

                    Worker w = new Worker(); //Add Worker
                    f1.setEntity(w);
                    w.setPlace(f1);

                    Crate c1 = new Crate(); // Add Crate
                    f2.setEntity(c1);
                    c1.setPlace(f2);

                    c1.Push(w, Direction.right);
                    System.out.println("Game over... I'm sorry.");
                }
                default:
                    System.out.println("Invalid command.\n");

            }

        }

    }
    @Override
    public String toString() {
    	return "Tester";
    }
}
