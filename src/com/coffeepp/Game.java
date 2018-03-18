package com.coffeepp;

public class Game {
    private int currentLevel;

    public int GetCurrentLevel()
    {
        return currentLevel;
    }
    public void NewGame()
    {

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
