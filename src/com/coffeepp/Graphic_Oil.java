package com.coffeepp;

import javafx.collections.ObservableList;

public class Graphic_Oil extends Graphic_Liquid {

    public Graphic_Oil(Liquid gr) {
        super(gr);
        SetImage(Resources.getInstance().img_Oil);
    }
    public boolean Draw(ObservableList list)
    {
        super.Draw(list);
        return true;
    }
}
