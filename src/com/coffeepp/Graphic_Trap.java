package com.coffeepp;

import javafx.collections.ObservableList;

public class Graphic_Trap extends Graphic_FloorBase {
    public Graphic_Trap(FloorBase gr) {
        super(gr);

        SetImage(Resources.getInstance().img_Trap);
    }
    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
