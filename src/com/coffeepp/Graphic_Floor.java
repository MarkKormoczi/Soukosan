package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public class Graphic_Floor extends Graphic_FloorBase {
    public Graphic_Floor(FloorBase gr) {
        super(gr);

        SetImage(Resources.getInstance().img_Floor);
    }

    public void Draw(ObservableList list)
    {
        int x= getGraphic().GetPosition().GetX();
        int y= getGraphic().GetPosition().GetY();

        ImageView imageView = new ImageView(getImg());
        imageView.setX(x);
        imageView.setY(y);
        list.add(imageView);
    }
}
