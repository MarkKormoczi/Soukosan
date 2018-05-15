package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Hole extends Graphic_FloorBase {
    public Graphic_Hole(FloorBase gr) {
        super(gr);
        SetImage(Resources.getInstance().img_Hole);
    }
    public boolean Draw(ObservableList list)
    {
        super.Draw(list);
        return true;
    }
}
