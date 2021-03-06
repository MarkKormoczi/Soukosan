package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public abstract class Graphic_Movable implements Drawable{
    private Image img;
    private int z_index;
    public Graphic_Movable()
    {
        z_index = 2;
    }

    @Override
    public boolean Draw(ObservableList list) {
        return true;
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
