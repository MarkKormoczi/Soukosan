package com.coffeepp;

import javafx.collections.ObservableList;

public class Graphic_Hole extends Graphic_FloorBase {
    public Graphic_Hole(FloorBase gr) {
        super(gr);
        SetImage(Resources.getInstance().img_Hole);

    }
    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
