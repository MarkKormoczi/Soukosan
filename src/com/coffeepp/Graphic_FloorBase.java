package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    public Graphic_FloorBase(){
    }
    public void SetImage(Image img)
    {
        img = img;
    }
    public int getZ()
    {
        return z_index;
    }
    @Override
    public void Draw(Stage stage) {
        Group root = new Group();
        ObservableList list = root.getChildren();

        int x= graphic.GetPosition().GetX();
        int y= graphic.GetPosition().GetY();

        ImageView imageView = new ImageView(img);
        imageView.setX(x*60);
        imageView.setY(y*60);
        list.add(imageView);
        stage.show();
    }
}
