package com.coffeepp;

public class Liquid {
    private String name;
    private double modifier;

    public Liquid(char c)
    {
        switch(c)
        {
            case 'H':
                name = "Honey";
                modifier= 2;
                break;
            case 'O':
                name = "Oil";
                modifier = 0.5;
                break;
            default:
                name = "Nothing";
                modifier = 1;
                break;
        }
    }
    public void setName(String _name)
    {
        Logger l = new Logger();
        l.enter(this, "SetLiquidName");
        l.exit(this, "SetLiquidName", "void");
        name = _name;
    }
    public void setModifier(double _modifier)
    {
        Logger l = new Logger();
        l.enter(this, "SetLiquidName");
        l.exit(this, "SetLiquidName", "void");
        modifier = _modifier;
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
