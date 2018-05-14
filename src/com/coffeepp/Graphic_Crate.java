package com.coffeepp;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Graphic_Crate extends Graphic_Movable{
    private Crate graphic;
    private Image img;
    private int z_index=2;

    public Graphic_Crate(Crate gr){
        graphic=gr;
        try {
            img = new Image(new FileInputStream(new File("img/crate.png").getAbsolutePath()));
        }
        catch (IOException e) {
        }
    }

    @Override
    public void Draw() {
        int x= graphic.getPlace().GetPosition().GetX();
        int y= graphic.getPlace().GetPosition().GetY();
        //ImageView imageView = new ImageView(img);
        //imageView.setX(x);
        //imageView.setY(y);

    }

    public void Destroy(){
        graphic.Destroy();

    }
}
