package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Graphic_Crate extends Graphic_Movable{
    private Crate graphic;
    private Image img;
    private int z_index=2;

    public Graphic_Crate(Crate gr){
        graphic=gr;
            img = Resources.getInstance().img_Crate;
    }

    @Override
    public boolean Draw(ObservableList list)
    {
        if(graphic.getPlace() != null) {
            int x = graphic.getPlace().GetPosition().GetX();
            int y = graphic.getPlace().GetPosition().GetY();

            ImageView imageView = new ImageView(img);
            imageView.setX(x * 80);
            imageView.setY(50 + y * 80);
            list.add(imageView);
            return true;
        }
        else
            return false;
    }

    public void Destroy(){
        graphic.Destroy();

    }
}
