package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Graphic_Worker extends Graphic_Movable{
    private Worker graphic;
    private Image[] img = new Image[4];

    public Graphic_Worker()
    {
    }
    public Graphic_Worker(Worker w)
    {
        graphic = w;
        img[0] = Resources.getInstance().worker1[0];
        img[1] = Resources.getInstance().worker1[1];
        img[2] = Resources.getInstance().worker1[2];
        img[3] = Resources.getInstance().worker1[3];
    }
    @Override
    public void Draw(ObservableList list) {
        if(graphic.getPlace() != null) {
            int x = graphic.getPlace().GetPosition().GetX();
            int y = graphic.getPlace().GetPosition().GetY();

            ImageView imageView = new ImageView(img[0]);
            imageView.setX(x*80+10);
            imageView.setY(50+y*80+10);
            list.add(imageView);
        }
    }
}
