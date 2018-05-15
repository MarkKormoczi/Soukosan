package com.coffeepp;

import javafx.collections.ObservableList;

public class Graphic_Obstruction extends Graphic_FloorBase {
    public Graphic_Obstruction(FloorBase gr) {
        super(gr);
        SetImage(Resources.getInstance().img_Obstruction);

    }
      public boolean Draw(ObservableList list)
    {
        super.Draw(list);
        return true;
    }
}
