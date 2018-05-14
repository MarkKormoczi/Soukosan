package com.coffeepp;

import javafx.stage.Stage;

public class Graphic_TargetSpot extends Graphic_FloorBase {
    public Graphic_TargetSpot(FloorBase gr) {
        super(gr);

        SetImage(Resources.getInstance().img_TargetSpot);
    }
    public void Draw(Stage stage)
    {
        super.Draw(stage);
    }
}
