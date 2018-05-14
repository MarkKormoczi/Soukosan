package com.coffeepp;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public abstract class Graphic_Movable implements Drawable{
    private Image img;
    private int z_index;
    public Graphic_Movable()
    {
        z_index = 2;
    }

    @Override
    public void Draw(Stage stage) {

    }
    public int getZ()
    {
        return z_index;
    }
    public Image getImg()
    {
        return img;
    }
}
