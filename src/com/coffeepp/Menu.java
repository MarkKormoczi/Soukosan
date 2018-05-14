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

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Menu{
	private Pane pane;
	private ArrayList mapList;

	public Game newGame(Stage stage){
		//TODO
		View view = new View();
		Game game= Game.getInstance();



		return game;
	}

	public void loadGame(Stage stage, Window window) throws Exception {
		Group root = new Group();
		ObservableList list = root.getChildren();
        Game g = Game.getInstance();
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

		File folder = new File("maps/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				//Writes out 1 map
				String mapName = listOfFiles[i].getName();
				Text mapText = new Text();
				mapText.setFont(new Font(35));
				mapText.setX(100);
				mapText.setY(150 + (i * 80));
				mapText.setText(mapName);
				list.add(mapText);
                mapText.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        e -> g.getView().SetStage(stage, window));

		}}

		//Return text
		Text returnText = new Text();
		returnText.setFont(new Font(35));
		returnText.setX(470);
		returnText.setY(620);
		returnText.setText("Return");
		list.add(returnText);
		EventHandler<MouseEvent> returnEventHandler = e -> {
			try {
				window.start(stage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		};
		returnText.addEventFilter(MouseEvent.MOUSE_CLICKED, returnEventHandler);

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
