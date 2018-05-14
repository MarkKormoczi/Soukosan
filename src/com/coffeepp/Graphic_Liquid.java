package com.coffeepp;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Graphic_Liquid implements Drawable {
    private Image img;
    private int z_index;
    private Liquid graphic;

    public Graphic_Liquid(Liquid gr){
        graphic=gr;
        try {
            img = new Image(new FileInputStream(new File("img/crate.png").getAbsolutePath())); //ez nem oké
        }
        catch (IOException e) {
        }
    }

    @Override
    public void Draw() {

    }
}
