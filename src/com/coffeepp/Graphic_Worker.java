package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Graphic_Worker extends Graphic_Movable{
    private Worker graphic;
    private Image img;
    private int movedx, movedy;
    public Graphic_Worker()
    {
    }
    public Graphic_Worker(Worker w)
    {
        graphic = w;
        img= Resources.getInstance().worker1[0];
    }
    @Override
    public boolean Draw(ObservableList list) {
        if(graphic.getPlace() != null) {
            int x = graphic.getPlace().GetPosition().GetX();
            int y = graphic.getPlace().GetPosition().GetY();
            ImageView imageView = new ImageView(img);
            imageView.setX(x*80+10);
            imageView.setY(50+y*80+10);
            list.add(imageView);
            return true;
        }
        else
            return false;
    }
}
