package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Graphic_Liquid implements Drawable {
    private Image img;
    private int z_index;
    private Liquid graphic;

    public Graphic_Liquid(Liquid gr){
        graphic=gr;
            z_index = 1;
    }
    public void SetImage(Image image)
    {
        img = image;
    }
    @Override
    public int getZ()
    {
        return z_index;
    }
    @Override
    public boolean Draw(ObservableList list)
    {
        int x= graphic.GetPlace().GetPosition().GetX();
        int y= graphic.GetPlace().GetPosition().GetY();

        ImageView imageView = new ImageView(img);
        imageView.setX(x*80);
        imageView.setY(50+y*80);
        list.add(imageView);
        return true;
    }
}
