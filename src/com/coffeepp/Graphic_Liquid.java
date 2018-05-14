package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Graphic_Liquid implements Drawable {
    private Image img;
    private int z_index;
    private Liquid graphic;

    public Graphic_Liquid(Liquid gr){
        graphic=gr;
            z_index = 1;
    }
    public Liquid getGraphic()
    {return graphic;}
    public Image getImg()
    {return img;}
    public void setImg(Image image)
    {img = image;}
    public int getZ()
    {
        return z_index;
    }
    @Override
    public void Draw(ObservableList list)
    {

        int x= graphic.GetPlace().GetPosition().GetX();
        int y= graphic.GetPlace().GetPosition().GetY();

        ImageView imageView = new ImageView(img);
        imageView.setX(x*60);
        imageView.setY(y*60);
        list.add(imageView);
    }
}
