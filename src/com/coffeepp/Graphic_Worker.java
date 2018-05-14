package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Graphic_Worker extends Graphic_Movable{
    private Worker graphic;


    public Graphic_Worker()
    {
    }
    public Graphic_Worker(Worker w)
    {

         graphic = w;
    }
    @Override
    public void Draw(ObservableList list) {

        int x= graphic.getPlace().GetPosition().GetX();
        int y= graphic.getPlace().GetPosition().GetY();

        ImageView imageView = new ImageView(getImg());
        imageView.setX(x);
        imageView.setY(y);
        list.add(imageView);

    }
}
