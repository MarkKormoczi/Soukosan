package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class Graphic_Switch extends Graphic_FloorBase {
    private Image img2;
    public Graphic_Switch(FloorBase gr) {
        super(gr);
        SetImage(Resources.getInstance().img_SwitchOn);
        img2 = Resources.getInstance().img_SwitchOff;

    }
    public void Draw(ObservableList list)
    {
        super.Draw(list);
    }
}
