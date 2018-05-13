package com.coffeepp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Menu{
	private Pane pane;
	private ArrayList mapList;

	public void newGame(){
		//TODO
	}

	public void loadGame(){
		//TODO
	}

	public void exit(){
		Platform.exit();
	}



	@Override
	public String toString() {
		return "Menu";
	}
}
