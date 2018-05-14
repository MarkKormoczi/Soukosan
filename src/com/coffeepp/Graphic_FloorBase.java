package com.coffeepp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Graphic_FloorBase implements Drawable{
    private Image img;
    private int z_index;
    private FloorBase graphic;

    public Graphic_FloorBase(FloorBase gr){
        graphic=gr;

        z_index = 0;
    }
    public void SetImage(Image img)
    {
        img = img;
    }

    @Override
    public void Draw() throws Exception
    {

    }
}
