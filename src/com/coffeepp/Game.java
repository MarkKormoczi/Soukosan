package com.coffeepp;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    private int currentLevel;
    private WareHouse layout;

    private static Game instance = null;
    public Game() {}

    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public WareHouse getLayout() {
        return layout;
    }

    public void setLayout(WareHouse layout) {
        this.layout = layout;
    }

    public int GetCurrentLevel()
    {
        return currentLevel;
    }
    public void NewGame() throws IOException {
        FileReader fr = new FileReader("D:/map.txt");
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        FloorBase[][] FloorMatrix = new FloorBase[100][100];
        //mátrix elemeinek NULL értékere állítása
        for(int i = 0; i < FloorMatrix.length; ++i)
            for(int j = 0; j < FloorMatrix[i].length; ++j)
                FloorMatrix[i][j] = null;

        //mátrix feltöltése
        int row =0;
        int mcol=0;
        while (line != null) {

           for(int col = 0; col< line.length(); col += 2)
           {
               char charfb = line.charAt(col);
                switch(charfb) {
                    case '0': FloorMatrix[row][mcol] = new Obstruction();
                    case '1': FloorMatrix[row][mcol] = new Floor();
                    case '2': FloorMatrix[row][mcol] = new TargetSpot();
                    case '3': FloorMatrix[row][mcol] = new Switch();
                    case '4': FloorMatrix[row][mcol] = new Trap();
                    case '5': FloorMatrix[row][mcol] = new Hole();
                }
               mcol++;
           }
           row++;
           mcol = 0;
            line = br.readLine();
        }
        br.close();
        System.out.print("\n");

        for(int i = 0; i < 10;i++)
        {
            for ( int j = 0; j<10; j++)
            {
                System.out.print(FloorMatrix[i][j]+" ");
            }
            System.out.print("\n");
        }

    }
    public void GameOver()
    {
        //Later
    }
    public void SetLevel(int level)
    {
        currentLevel=level;
    }
    @Override
    public String toString() {
    	return "Game";
    }
}
