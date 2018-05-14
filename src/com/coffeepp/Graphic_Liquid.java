package com.coffeepp;

import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Graphic_Liquid implements Drawable {
    private Image Oil;
    private Image Honey;
    private int z_index;
    private Liquid graphic;

    public Graphic_Liquid(Liquid gr){
        graphic=gr;
            Honey = Resources.getInstance().img_Honey;
            Oil = Resources.getInstance().img_Oil;
            z_index = 1;
    }
    public Graphic_Liquid()
    {}
    public int getZ()
    {
        return z_index;
    }
    @Override
    public void Draw(Stage stage) {

    }
}
