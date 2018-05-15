package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Graphic_Switch extends Graphic_FloorBase {
    private Image img2;
    public Graphic_Switch(FloorBase gr) {
        super(gr);
        try {
            SetImage(new Image(new FileInputStream(new File("img/switchOn.png").getAbsolutePath())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        img2 = Resources.getInstance().img_SwitchOff;

    }
    public boolean Draw(ObservableList list)
    {
        super.Draw(list);
        return  true;
    }
}
