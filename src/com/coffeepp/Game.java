package com.coffeepp;
import java.io.FileReader;

public class Game {
    private int currentLevel;

    public int GetCurrentLevel()
    {
        return currentLevel;
    }
    public void NewGame()
    {
        FileReader fr = new FileReader("map.txt");

        for (int i = 0;)
        Floor f = new Floor();
        f
        fr.close();
    }
    public void GameOver()
    {

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
