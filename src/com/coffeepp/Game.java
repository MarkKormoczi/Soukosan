package com.coffeepp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Responsible for starting the game, level loading, and general game control.
 */
public class Game {
    private int currentLevel;
    private WareHouse layout;

    public static Game instance = null;

    /**
     * Private constructor bc singleton.
     */
    private Game() {}

    /**
     * Singleton instance getter.
     * @return the only instance
     */
    public static Game getInstance() {
        if(instance == null) {
            instance = new Game();
        }
        return instance;
    }

    /**
     * Returns the current layout.
     * @return
     */
    public WareHouse getLayout() {
        Logger l = new Logger();
        l.enter(this, "getLayout");
        l.exit(this, "getLayout", layout.toString());
        return layout;
    }

    /**
     * Sets the current layout.
     * @return
     */
    public void setLayout(WareHouse layout) {
        Logger l = new Logger();
        l.enter(this, "setLayout");
        this.layout = layout;
        l.exit(this, "setLayout", "void");
    }

    /**
     * Returns the current level
     * @return
     */
    public int GetCurrentLevel()
    {
        Logger l = new Logger();
        l.enter(this, "setLayout");
        l.exit(this, "setLayout", Integer.toString(currentLevel));
        return currentLevel;
    }

    /**
     * Loads and starts a new game.
     * @throws IOException
     */
    public void NewGame() throws IOException {
        Logger l = new Logger();
        l.enter(this, "NewGame");

        layout = new WareHouse();

        // Commented out since file loading is not implemented into skeleton
        FileReader fr = new FileReader("map.txt");
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        FloorBase[][] FloorMatrix = new FloorBase[100][100];
        //FloorMatrix elemeinek NULL értékere állítása
        for(int i = 0; i < FloorMatrix.length; ++i)
            for(int j = 0; j < FloorMatrix[i].length; ++j)
                FloorMatrix[i][j] = null;

        //FloorMatrix feltoltese
        int row =0;
        int mcol=0;
        while (line != null) {
            //A palya tarolasa vegett 2-t kell leptetni és ezért kell az mcol valtozo is
           for(int col = 0; col< line.length(); col += 3)
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
               switch (charfb)
               {
                   case 'H':
                       FloorMatrix[row][mcol].setLiquid('H');
                       break;
                   case 'O':
                       FloorMatrix[row][mcol].setLiquid('O');
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
        for ( rowNum = 0; rowNum < FloorMatrix.length; rowNum ++){
            for ( colNum = 0; colNum < FloorMatrix[rowNum].length; colNum ++){
                // handle top edge , all northern neighbor is null
                if( FloorMatrix[rowNum][colNum] != null)
                {
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
                    System.out.print(FloorMatrix[rowNum][colNum]);
                    layout.AddFloorbase(FloorMatrix[rowNum][colNum]);
                }
            }
        }
        l.exit(this, "NewGame", "void");
    }

    /**
     * Ends the game.
     */
    public void GameOver()
    {
        Logger l = new Logger();
        l.enter(this, "GameOver");
        l.exit(this, "GameOver", "void");
        //Later
    }

    /**
     * Sets the current level to be played.
     * @param level The desired level.
     */
    public void SetLevel(int level)
    {
        Logger l = new Logger();
        l.enter(this, "SetLevel");
        currentLevel=level;
        l.exit(this, "SetLevel", "void");
    }
    @Override
    public String toString() {
    	return "Game";
    }
}
