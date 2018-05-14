package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Oil extends Graphic_Liquid {

    public Graphic_Oil(Liquid gr) {
        super(gr);
        setImg(Resources.getInstance().img_Oil);
    }
    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
