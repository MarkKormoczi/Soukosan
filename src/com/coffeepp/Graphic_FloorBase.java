package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Graphic_FloorBase implements Drawable{
    private Image img;
    private int z_index;
    private FloorBase graphic;

    public Graphic_FloorBase(FloorBase gr){
        graphic=gr;
        z_index = 0;
    }
    public Graphic_FloorBase(){}

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
    public boolean Draw(ObservableList list) {

        int x= graphic.GetPosition().GetX();
        int y= graphic.GetPosition().GetY();

        ImageView imageView = new ImageView(img);
        imageView.setX(x*80);
        imageView.setY(50+y*80);
        list.add(imageView);
        return true;
    }
}
