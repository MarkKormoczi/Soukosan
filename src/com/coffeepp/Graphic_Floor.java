package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Floor extends Graphic_FloorBase {
    public Graphic_Floor(FloorBase gr) {
        super(gr);

            SetImage(Resources.getInstance().img_Floor);
    }

    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
