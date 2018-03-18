package com.coffeepp;
import java.io.FileReader;

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
    public void NewGame()
    {
        this.layout = new WareHouse();
        FileReader fr = new FileReader("map.txt");

        for (int i = 0;)
        Floor f = new Floor();
        f
        fr.close();
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
