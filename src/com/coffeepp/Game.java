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
    public FloorBase[][] FloorMatrix;
    private int maxcol = 0;
    private int maxrow = 0;
    private View gameView;

    private int FPS = 60;
    private View view= new View();

    public static Game instance = null;

    /**
     * Private constructor bc singleton.
     */
    public Game() { }

    public View getView(){
        return view;
    }

    public void setFPS(int i){
        FPS = i;
    }

    /**
     * Singleton instance getter.
     * @return the only instance
     */
    public void ShowLevel() {
        for(int i = 0; i < maxrow;i++)
        {
            for ( int j = 0; j<maxcol; j++)
            {
                if(FloorMatrix[i][j].GetPosition() != null){
                    System.out.print(FloorMatrix[i][j].GetPosition().GetX()+",");
                System.out.print(FloorMatrix[i][j].GetPosition().GetY()+"\t");}
                else
                    System.out.println("asfasf ");
            }
            System.out.print("\n");
        }
    }
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
        return layout;
    }

    /**
     * Sets the current layout.
     * @return
     */
    public void setLayout(WareHouse layout) {
        this.layout = layout;
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
    public void NewGame()
    {
        try {
            LoadMap("map.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void LoadMap(String level) throws IOException {
        layout = new WareHouse();
        gameView = new View();

        // Commented out since file loading is not implemented into skeleton
        FileReader fr = new FileReader(level);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        maxcol = Integer.parseInt(line);
        System.out.println(maxcol);
        line = br.readLine();
        maxrow = Integer.parseInt(line);
        System.out.println(maxrow);
        line = br.readLine();

        FloorMatrix = new FloorBase[maxrow][maxcol];

        //FloorMatrix elemeinek NULL értékere állítása
        for (int i = 0; i < FloorMatrix.length; ++i)
            for (int j = 0; j < FloorMatrix[i].length; ++j)
                FloorMatrix[i][j] = null;

        //FloorMatrix feltoltese
        int row = 0;
        int mcol = 0;

        while (line != null) {
            //A palya tarolasa vegett 3-t kell leptetni és ezért kell az mcol valtozo is
            for (int col = 0; col < line.length(); col += 3) {
                char charfb = line.charAt(col);
                Graphic_FloorBase f = new Graphic_FloorBase();
                switch (charfb) {
                    case '0':
                        FloorMatrix[row][mcol] = new Obstruction();
                         f = new Graphic_Obstruction(FloorMatrix[row][mcol]);
                        break;
                    case '1':
                        FloorMatrix[row][mcol] = new Floor();
                         f = new Graphic_Floor(FloorMatrix[row][mcol]);
                        break;
                    case '2':
                        FloorMatrix[row][mcol] = new TargetSpot();
                         f = new Graphic_TargetSpot(FloorMatrix[row][mcol]);
                        break;
                    case '3':
                        FloorMatrix[row][mcol] = new Switch();
                         f = new Graphic_Switch(FloorMatrix[row][mcol]);
                        break;
                    case '4':
                        FloorMatrix[row][mcol] = new Trap();
                         f = new Graphic_Trap(FloorMatrix[row][mcol]);
                        break;
                    case '5':
                        FloorMatrix[row][mcol] = new Hole();
                         f = new Graphic_Hole(FloorMatrix[row][mcol]);
                        break;
                }
                gameView.addFloorBase(f);
                charfb = line.charAt(col + 1);

                Worker w;
                Crate c;
                Graphic_Movable m = new Graphic_Worker();
                switch (charfb) {
                    case 'K':
                        w = new Worker(61);
                        layout.AddWorker(w);
                        w.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].setEntity(w);
                        m = new Graphic_Worker(w);

                        break;
                    case 'T':
                        w = new Worker(121);
                        layout.AddWorker(w);
                        w.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].setEntity(w);
                        m = new Graphic_Worker(w);
                        break;
                    case 'A':
                        w = new Worker(161);
                        layout.AddWorker(w);
                        w.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].setEntity(w);
                        m = new Graphic_Worker(w);
                        break;
                    case 'S':
                        c = new Crate(30);
                        layout.AddCrate(c);
                        c.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].setEntity(c);
                        m = new Graphic_Crate(c);
                        break;
                    case 'M':
                        c = new Crate(60);
                        layout.AddCrate(c);
                        c.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].setEntity(c);
                        m = new Graphic_Crate(c);
                        break;
                    case 'L':
                        c = new Crate(80);
                        layout.AddCrate(c);
                        c.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].setEntity(c);
                        m = new Graphic_Crate(c);
                        break;
                }
                gameView.addMovable(m);

                charfb = line.charAt(col + 2);
                Graphic_Liquid l = new Graphic_Liquid();
                switch (charfb) {
                    case 'H':
                        FloorMatrix[row][mcol].setLiquid(new Liquid('H'));
                        l = new Graphic_Liquid(FloorMatrix[row][mcol].getLiquid());
                        break;
                    case 'O':
                        FloorMatrix[row][mcol].setLiquid(new Liquid('O'));
                        l = new Graphic_Liquid(FloorMatrix[row][mcol].getLiquid());
                        break;
                    case 'N':
                        FloorMatrix[row][mcol].setLiquid(new Liquid('N'));
                        l = new Graphic_Liquid(FloorMatrix[row][mcol].getLiquid());
                        break;
                    default:
                        FloorMatrix[row][mcol].setLiquid(new Liquid('N'));
                        l = new Graphic_Liquid(FloorMatrix[row][mcol].getLiquid());
                        break;
                }
                gameView.addLiquid(l);
                mcol++;
            }
            row++;
            mcol = 0;
            line = br.readLine();
        }
        br.close();
        System.out.print("\n");


        int colNum;
        int rowNum;
        for (rowNum = 0; rowNum < FloorMatrix.length; rowNum++) {
            for (colNum = 0; colNum < FloorMatrix[rowNum].length; colNum++) {
                // handle top edge , all northern neighbor is null
                if (FloorMatrix[rowNum][colNum] != null) {
                    if (rowNum == 0) {
                        FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.up);
                    } else {
                        FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum - 1][colNum], Direction.up);
                    }
                    // handle bottom edge , all southern neighbor is null
                    if (rowNum == FloorMatrix.length - 1) {
                        FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.down);
                    } else {
                        FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum + 1][colNum], Direction.down);
                    }
                    // handle left edge , all western neighbor is null
                    if (colNum == 0) {
                        FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.left);
                    } else {
                        FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum][colNum - 1], Direction.left);
                    }
                    // handle top edge , all eastern neighbor is null
                    if (colNum == FloorMatrix[rowNum].length - 1) {
                        FloorMatrix[rowNum][colNum].setNeighbor(null, Direction.right);
                    } else {
                        FloorMatrix[rowNum][colNum].setNeighbor(FloorMatrix[rowNum][colNum + 1], Direction.right);
                    }
                    FloorMatrix[rowNum][colNum].SetPosition(new Position(rowNum, colNum));
                    layout.AddFloorbase(FloorMatrix[rowNum][colNum]);
                }
            }
        }


    }


    /**
     * Ends the game.
     */
    public void GameOver()
    {
        //Later
    }

    /**
     * Sets the current level to be played.
     * @param level The desired level.
     */
    public void SetLevel(int level)
    {
        currentLevel=level;
    }
    @Override
    public String toString() {
    	return "Game";
    }
}
