package com.coffeepp;

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
                    "\t6 Step to Floorbase\n" +
                    "\t7 Update cycle\n" +
                    "\t8 Switch\n" +
                    "\t9 Add point\n" +
                    "\t10 Destroy Crate\n" +
                    "\t11 Destroy Worker\n" +
                    "\t12 New game\n" +
                    "\t13 Game over\n" +
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
                        case "2.1":
                            Floor f1_1 = new Floor();
                            Floor f2_1 = new Floor();
                            Worker w1_1 = new Worker();
                            f1_1.setNeighbor(f2_1, Direction.right);
                            f2_1.setNeighbor(f1_1, Direction.left);

                            f1_1.setEntity(w1_1);
                            w1_1.setPlace(f1_1);

                            w1_1.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Floor.\n");
                            break;

                        case "2.2":
                            Floor f1_2 = new Floor();
                            Obstruction f2_2 = new Obstruction();
                            Worker w1_2 = new Worker();
                            f1_2.setNeighbor(f2_2, Direction.right);
                            f2_2.setNeighbor(f1_2, Direction.left);

                            f1_2.setEntity(w1_2);
                            w1_2.setPlace(f1_2);

                            w1_2.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Obstruction.\n");
                            break;

                        case "2.3":
                            Floor f1_3 = new Floor();
                            Hole f2_3 = new Hole();
                            Worker w1_3 = new Worker();
                            f1_3.setNeighbor(f2_3, Direction.right);
                            f2_3.setNeighbor(f1_3, Direction.left);

                            f1_3.setEntity(w1_3);
                            w1_3.setPlace(f1_3);

                            w1_3.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker moved to Hole.\n");
                            break;

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

                            w1_2.Move(Direction.right); //Worker moves in given direction

                            System.out.println("Worker pushed Crate unsuccessfully.\n");
                            break;

                        default:
                            System.out.println("Invalid command.\n");


                    }
                    break;

                case "4": // Worker pushed





            }

        }

    }
    @Override
    public String toString() {
    	return "Tester";
    }
}
