package com.coffeepp;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardEventHandler implements EventHandler<KeyEvent>{

    @Override
    public void handle(KeyEvent event) {
        int workerIndex= 0;
        if(event.getCode().isArrowKey())
            workerIndex = 1;

        if(event.getCode().equals(KeyCode.UP)) {
                Controller.WorkerControl(workerIndex, Direction.up);
        }
        if(event.getCode().equals(KeyCode.DOWN)) {
            Controller.WorkerControl(workerIndex, Direction.down);
        }
        if(event.getCode().equals(KeyCode.RIGHT)) {
            Controller.WorkerControl(workerIndex, Direction.right);
        }
        if(event.getCode().equals(KeyCode.LEFT)) {
            Controller.WorkerControl(workerIndex, Direction.left);
        }
        if(event.getCode().equals(KeyCode.W)) {
            Controller.WorkerControl(workerIndex, Direction.up);
        }
        if(event.getCode().equals(KeyCode.S)) {
            Controller.WorkerControl(workerIndex, Direction.down);
        }
        if(event.getCode().equals(KeyCode.A)) {
            Controller.WorkerControl(workerIndex, Direction.right);
        }
        if(event.getCode().equals(KeyCode.D)) {
            Controller.WorkerControl(workerIndex, Direction.left);
        }
    }
}
