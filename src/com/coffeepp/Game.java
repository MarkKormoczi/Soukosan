package com.coffeepp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private int currentLevel;
    private WareHouse layout;

    public static Game instance = null;
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
                    case '0': FloorMatrix[row][mcol] = new Obstruction(); break;
                    case '1': FloorMatrix[row][mcol] = new Floor();break;
                    case '2': FloorMatrix[row][mcol] = new TargetSpot();break;
                    case '3': FloorMatrix[row][mcol] = new Switch();break;
                    case '4': FloorMatrix[row][mcol] = new Trap();break;
                    case '5': FloorMatrix[row][mcol] = new Hole();break;
                }
                charfb = line.charAt(col+1);
                switch (charfb)
                {
                    case 'W':
                        FloorMatrix[row][mcol].setEntity(new Worker());
                        break;
                    case 'C':
                        FloorMatrix[row][mcol].setEntity(new Crate());
                        break;
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
                System.out.print(FloorMatrix[i][j]+"\t");
            }
            System.out.print("\n");
        }

        int colNum;
        int rowNum;
        for ( rowNum = 0; rowNum < 100; rowNum ++){
            for ( colNum = 0; colNum < 100; colNum ++){
                // handle top edge , all northern neighbor is null
                if ( rowNum == 0 ) {
                    FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.up);
                } else {
                    FloorMatrix[rowNum][colNum].setNeighbor( FloorMatrix[rowNum-1][colNum], Direction.up);
                }
                // handle bottom edge , all southern neighbor is null
                if ( rowNum == FloorMatrix.length-1) {
                    FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.down);
                } else {
                    FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum+1][colNum], Direction.down);
                }
                // handle left edge , all western neighbor is null
                if ( colNum == 0 ) {
                    FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.left);
                } else {
                    FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum][colNum-1], Direction.left);
                }
                // handle top edge , all eastern neighbor is null
                if ( colNum == FloorMatrix[rowNum].length-1) {
                    FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.right);
                } else {
                    FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum][colNum+1], Direction.right);
                }
            }
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
