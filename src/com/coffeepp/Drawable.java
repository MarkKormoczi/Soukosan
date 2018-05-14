package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.stage.Stage;

public interface Drawable {

    public int getZ();
    public void Draw(ObservableList list) throws Exception;
}
