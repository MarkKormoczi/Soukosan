package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Trap extends Graphic_FloorBase {
    public Graphic_Trap(FloorBase gr) {
        super(gr);

            SetImage(Resources.getInstance().img_Floor);
    }
    public boolean Draw(ObservableList list)
    {
        if(getFloorBase().isActive())
        {
            SetImage(Resources.getInstance().img_Hole);
        }
        else
        {
            SetImage(Resources.getInstance().img_Floor);
        }
        super.Draw(list);
        return true;
    }
}
