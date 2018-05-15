package com.coffeepp;

import javafx.collections.ObservableList;
import javafx.stage.Stage;

public interface Drawable {

    public int getZ();
    public boolean Draw(ObservableList list) throws Exception;
}
