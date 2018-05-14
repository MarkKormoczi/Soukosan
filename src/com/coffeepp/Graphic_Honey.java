package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Honey extends Graphic_Liquid {
    public Graphic_Honey(Liquid gr) {
        super(gr);
        setImg(Resources.getInstance().img_Honey);

    }
    public void Draw(ObservableList list)
    {super.Draw(list);}
}
