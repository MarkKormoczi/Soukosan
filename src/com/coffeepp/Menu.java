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
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Menu{
	private Pane pane;
	private ArrayList mapList;

	public void newGame(Stage stage){
		//TODO
	}

	public void loadGame(Stage stage) throws Exception {
		Group root = new Group();
		ObservableList list = root.getChildren();

		//Background
		Image image = new Image(new FileInputStream(new File("img/back.jpg").getAbsolutePath()));
		ImageView imageView = new ImageView(image);
		imageView.setX(0);
		imageView.setY(0);
		list.add(imageView);

		//Title text
		Text titleText = new Text();
		titleText.setFont(new Font(45));
		titleText.setX(30);
		titleText.setY(70);
		titleText.setText("Load game");
		list.add(titleText);

		Scene scene = new Scene(root, 600, 660);
		stage.setTitle("倉庫さん");
		stage.setScene(scene);
		stage.show();
	}

	public void exit(){
		Platform.exit();
	}


	public Menu(){

	}



	@Override
	public String toString() {
		return "Menu";
	}
}
