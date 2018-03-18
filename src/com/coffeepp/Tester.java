package com.coffeepp;

import java.util.Scanner;

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

            System.out.println("You chose: " + input + "\n\n");


        }

    }
    @Override
    public String toString() {
    	return "Tester";
    }
}
