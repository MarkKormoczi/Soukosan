package com.coffeepp;

import javafx.collections.ObservableList;

public class Graphic_Honey extends Graphic_Liquid {
    public Graphic_Honey(Liquid gr) {
        super(gr);
        SetImage(Resources.getInstance().img_Honey);

    }
    public boolean Draw(ObservableList list)
    {
        super.Draw(list);
        return true;
    }
}
