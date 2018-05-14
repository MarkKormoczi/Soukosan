package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Obstruction extends Graphic_FloorBase {
    public Graphic_Obstruction(FloorBase gr) {
        super(gr);
        SetImage(Resources.getInstance().img_Obstruction);

    }
      public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
