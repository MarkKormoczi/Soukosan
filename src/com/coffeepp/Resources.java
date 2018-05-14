package com.coffeepp;

import javafx.scene.image.Image;

import java.io.File;

public class Resources
{
    public static Resources instance = null;

    public static Resources getInstance() {
        if(instance == null) {
            instance = new Resources();
        }
        return instance;
    }
    public Image img_Floor;
    public Image img_Trap;
    public Image img_Hole;
    public Image img_Obstruction;
    public Image img_Crate;
    public Image img_SwitchOn;
    public Image img_SwitchOff;
    public Image img_TargetSpot;
    public Image img_Honey;
    public Image img_Oil;
    public Image[] worker2 = new Image[4];
    public Image[] worker1 = new Image[4];
    public Resources()
    {
        img_Floor       = new Image(new File("img/floor.png").getAbsolutePath());
        img_Trap        = new Image(new File("img/floor.png").getAbsolutePath());
        img_Hole        = new Image(new File("img/hole.png").getAbsolutePath());
        img_Obstruction = new Image(new File("img/obstruction.png").getAbsolutePath());
        img_Crate       = new Image(new File("img/crate.png").getAbsolutePath());
        img_SwitchOn    = new Image(new File("img/switchOn.png").getAbsolutePath());
        img_SwitchOff   = new Image(new File("img/switchOff.png").getAbsolutePath());
        img_TargetSpot  = new Image(new File("img/TargetSpot.png").getAbsolutePath());
        img_Honey       = new Image(new File("img/honey.png").getAbsolutePath());
        img_Oil         = new Image(new File("img/oil.jpg").getAbsolutePath());
        worker1[0]      = new Image(new File("img/workerleft.png").getAbsolutePath());
        worker1[1]      = new Image(new File("img/workerup.png").getAbsolutePath());
        worker1[2]      = new Image(new File("img/workerright.png").getAbsolutePath());
        worker1[3]      = new Image(new File("img/workerdown.png").getAbsolutePath());
        worker2[0]      = new Image(new File("img/workerleft_1.png").getAbsolutePath());
        worker2[1]      = new Image(new File("img/workerup_1.png").getAbsolutePath());
        worker2[2]      = new Image(new File("img/workerright_1.png").getAbsolutePath());
        worker2[3]      = new Image(new File("img/workerdown_1.png").getAbsolutePath());

    }
}
