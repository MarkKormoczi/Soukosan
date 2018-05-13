package com.coffeepp;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;

public class Graphic_FloorBase implements Drawable{
    private Image img;
    private int z_index;
    private FloorBase graphic;

    @Override
    public void Draw() throws Exception
    {
        Image img = new Image(new FileInputStream(new File("img/asd.jpg").getAbsolutePath()));
        ImageView imageView = new ImageView(img);
        imageView.setX(0);
        imageView.setY(0);
        //list.add(imageView);
    }
}
