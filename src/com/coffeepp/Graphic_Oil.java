package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public class Graphic_Oil extends Graphic_Liquid {

    public Graphic_Oil(Liquid gr) {
        super(gr);
        setImg(Resources.getInstance().img_Oil);
    }
    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
