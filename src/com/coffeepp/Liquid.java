package com.coffeepp;

public class Liquid {
    String name;
    double modifier;
    public Liquid(char c)
    {
        switch(c)
        {
            case 'H':
                name = "Honey";
                modifier = 1.5;
                break;
            case 'O':
                name = "Oil";
                modifier = 0.5;
                break;
            default:
                name = "Nothing";
                modifier = 0;
                break;
        }
    }
    public String getName()
    {
        Logger l = new Logger();
        l.enter(this, "GetLiquidName");
        l.exit(this, "GetLiquidName", name);
        return name;
    }
    public double getModifier()
    {
        Logger l = new Logger();
        l.enter(this, "GetLiquidModifier");
        l.exit(this, "GetLiquidModifier", name);
        return modifier;
    }

    @Override
    public String toString() {
        return "Liquid";
    }
}
