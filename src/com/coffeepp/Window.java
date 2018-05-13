package com.coffeepp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class Window extends Application{
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private Game game;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    private Menu menu = new Menu();

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        titleText.setText("倉庫さん");
        list.add(titleText);

        //New Game text
        Text newGameText = new Text();
        newGameText.setFont(new Font(35));
        newGameText.setX(200);
        newGameText.setY(300);
        newGameText.setText("New Game");
        list.add(newGameText);

        //Load Game text
        Text loadGameText = new Text();
        loadGameText.setFont(new Font(35));
        loadGameText.setX(200);
        loadGameText.setY(350);
        loadGameText.setText("Load Game");
        list.add(loadGameText);
        EventHandler<MouseEvent> loadEventHandler = e -> {
            try {
                menu.loadGame(primaryStage, this);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        };
        loadGameText.addEventFilter(MouseEvent.MOUSE_CLICKED, loadEventHandler);

        //Exit text
        Text exitText = new Text();
        exitText.setFont(new Font(35));
        exitText.setX(200);
        exitText.setY(400);
        exitText.setText("Exit");
        list.add(exitText);
        EventHandler<MouseEvent> exitEventHandler = e -> Platform.exit();
        exitText.addEventFilter(MouseEvent.MOUSE_CLICKED, exitEventHandler);

        Scene scene = new Scene(root, 600, 660);
        primaryStage.setTitle("倉庫さん");
        primaryStage.setScene(scene);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardEventHandler());

        primaryStage.show();
    }

    public void run(String args[]){
        launch(args);
    }
}
