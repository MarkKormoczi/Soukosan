package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_TargetSpot extends Graphic_FloorBase {
    public Graphic_TargetSpot(FloorBase gr) {
        super(gr);

        try {
            SetImage(new Image(new FileInputStream(new File("img/targetSpot.png").getAbsolutePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }    }

    public boolean Draw(ObservableList list) {
        super.Draw(list);
        return true;
    }
}
