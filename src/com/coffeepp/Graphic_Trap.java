package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Trap extends Graphic_FloorBase {
    public Graphic_Trap(FloorBase gr) {
        super(gr);

        try {
            SetImage(new Image(new FileInputStream(new File("img/floor.png").getAbsolutePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }    }
    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
