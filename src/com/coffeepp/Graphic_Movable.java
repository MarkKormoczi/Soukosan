package com.coffeepp;

import javafx.scene.image.Image;

public abstract class Graphic_Movable implements Drawable{
    private Image img;
    private int z_index;
    public Graphic_Movable()
    {
        z_index = 2;
    }
    @Override
    public void Draw() {

    }
}
