package com.coffeepp;

import javafx.collections.ObservableList;

public class Graphic_Floor extends Graphic_FloorBase {
    public Graphic_Floor(FloorBase gr) {
        super(gr);

            SetImage(Resources.getInstance().img_Floor);
    }

    public boolean Draw(ObservableList list)
    {
        super.Draw(list);
        return true;
    }
}
