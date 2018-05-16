package com.coffeepp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Responsible for starting the game, level loading, and general game control.
 */
public class Game {
    private int levelnumber=0;
    private String currentLevel;
    private WareHouse layout;
    public FloorBase[][] FloorMatrix;
    private int maxcol = 0;
    private int maxrow = 0;
    private View gameView = new View();
    private boolean gameover = false;
    public Resources resources;

    private int FPS = 60;

    public static Game instance = null;

    /**
     * Private constructor bc singleton.
     */
    public Game() { }

    public View getView(){
        return gameView;
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
                //if(FloorMatrix[i][j].getEntity() != null){
                //    System.out.print(FloorMatrix[i][j].getEntity()+"\t");
                //}
                //else
                //    System.out.println(FloorMatrix[i][j].toString());
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
        levelnumber++;
        currentLevel = level;
        gameover = false;
        layout = new WareHouse();
        resources = Resources.getInstance();
        // Commented out since file loading is not implemented into skeleton
        FileReader fr = new FileReader(level);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        maxcol = Integer.parseInt(line);
        line = br.readLine();
        maxrow = Integer.parseInt(line);
        line = br.readLine();

        FloorMatrix = new FloorBase[maxrow+2][maxcol+2];

        //FloorMatrix elemeinek NULL értékere állítása
        for (int i = 0; i < FloorMatrix.length; ++i)
            for (int j = 0; j < FloorMatrix[i].length; ++j)
            {if(j == 0 || i == 0 || j == FloorMatrix[i].length-1 || i == FloorMatrix.length-1){
                FloorMatrix[i][j] = new Obstruction();
                Graphic_FloorBase g = new Graphic_Obstruction(FloorMatrix[i][j]);
                gameView.addFloorBase(g);
                Liquid l = new Liquid('N');
                FloorMatrix[i][j].setLiquid(l);
                l.SetPlace(FloorMatrix[i][j]);}
            }

        //FloorMatrix feltoltese
        int row = 1;
        int mcol = 1;

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
                Graphic_Movable m;
                switch (charfb) {
                    case 'K':
                        w = new Worker(61);
                        layout.AddWorker(w);
                        w.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].addEntity(w);
                        m = new Graphic_Worker(w);
                        gameView.addMovable(m);

                        break;
                    case 'T':
                        w = new Worker(121);
                        layout.AddWorker(w);
                        w.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].addEntity(w);
                        m = new Graphic_Worker(w);
                        gameView.addMovable(m);
                        break;
                    case 'A':
                        w = new Worker(161);
                        layout.AddWorker(w);
                        w.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].addEntity(w);
                        m = new Graphic_Worker(w);
                        gameView.addMovable(m);
                        break;
                    case 'S':
                        c = new Crate(30);
                        layout.AddCrate(c);
                        c.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].addEntity(c);
                        m = new Graphic_Crate(c);
                        gameView.addMovable(m);
                        break;
                    case 'M':
                        c = new Crate(60);
                        layout.AddCrate(c);
                        c.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].addEntity(c);
                        m = new Graphic_Crate(c);
                        gameView.addMovable(m);
                        break;
                    case 'L':
                        c = new Crate(80);
                        layout.AddCrate(c);
                        c.setPlace(FloorMatrix[row][mcol]);
                        FloorMatrix[row][mcol].addEntity(c);
                        m = new Graphic_Crate(c);
                        gameView.addMovable(m);
                        break;
                }

                charfb = line.charAt(col + 2);
                Graphic_Liquid gl;
                Liquid l;
                switch (charfb) {
                    case 'H':
                        l = new Liquid('H');
                        FloorMatrix[row][mcol].setLiquid(l);
                        l.SetPlace(FloorMatrix[row][mcol]);
                        gl = new Graphic_Honey(FloorMatrix[row][mcol].getLiquid());
                        gameView.addLiquid(gl);
                        break;
                    case 'O':
                        l = new Liquid('O');
                        FloorMatrix[row][mcol].setLiquid(l);
                        l.SetPlace(FloorMatrix[row][mcol]);
                        gl = new Graphic_Oil(FloorMatrix[row][mcol].getLiquid());
                        gameView.addLiquid(gl);
                        break;
                    case 'N':
                        l = new Liquid('N');
                        FloorMatrix[row][mcol].setLiquid(l);
                        l.SetPlace(FloorMatrix[row][mcol]);
                        gl = new Graphic_Liquid(FloorMatrix[row][mcol].getLiquid());
                        gameView.addLiquid(gl);
                        break;
                    default:
                        break;
                }
                mcol++;
            }
            row++;
            mcol = 1;
            line = br.readLine();
        }
        br.close();


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
                    FloorMatrix[rowNum][colNum].SetPosition(new Position(colNum, rowNum));
                    layout.AddFloorbase(FloorMatrix[rowNum][colNum]);
                }
            }
        }
        layout.InitBadSpots(layout.GetCrates().size());
    }


    /**
     * Ends the game.
     */
    public void GameOver()
    {
        gameover = true;
        layout.Clear();
        gameView.ToMenu();
    }
    public void WinGame() throws IOException {
        if(layout.isAnyBadSpots())
        {
            gameView.list.clear();
            gameView.drawables.clear();
            layout.Clear();
            gameView.GameWon();
        }
    }
    public int getLevelnumber()
    {
        return levelnumber;
    }
    @Override
    public String toString() {
    	return "Game";
    }
    public void Restart() throws IOException {

        layout.Clear();
        LoadMap(currentLevel);
    }
    public boolean isGameOver() {
    return gameover;
    }
}
