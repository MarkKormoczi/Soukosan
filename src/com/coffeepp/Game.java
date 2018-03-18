package com.coffeepp;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Game {
    private int currentLevel;
    private WareHouse layout;

    private static Game instance = null;
    private Game() {}

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
        FileReader fr = new FileReader("map.txt");
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
        while (line != null) {
           row++;
           for(int col = 0; col< line.length(); col += 2)
           {
               char charfb = line.charAt(col);
                switch(charfb) {
                    case '0': FloorMatrix[row][col] = new Obstruction();
                    case '1': FloorMatrix[row][col] = new Floor();
                    case '2': FloorMatrix[row][col] = new TargetSpot();
                    case '3': FloorMatrix[row][col] = new Switch();
                    case '4': FloorMatrix[row][col] = new Trap();
                    case '5': FloorMatrix[row][col] = new Hole();
                }
           }
            line = br.readLine();
        }
        br.close();

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
