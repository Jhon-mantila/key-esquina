package com.esquinaweb.ui;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import com.esquinaweb.controller.KeyboardController;

import javafx.geometry.Pos;
import javafx.stage.Stage;

public class MainWindow {

    public void show(Stage stage) {

        BorderPane root = new BorderPane();

        KeyboardPane keyboardPane = new KeyboardPane();
        HistoryPane historyPane = new HistoryPane();
        
        VBox content = new VBox(20);

        content.getChildren().addAll(
                keyboardPane,
                historyPane
        );

        root.setCenter(content);

        Scene scene = new Scene(root, 800, 500);
        
        KeyboardController controller = new KeyboardController(keyboardPane, historyPane);
        
        controller.start();
        
        scene.setOnKeyPressed(event -> {
        	 controller.keyPressed(event.getCode());
        });

        scene.setOnKeyReleased(event -> {

        	controller.keyReleased(event.getCode());

        });
        
        
        stage.setTitle("Key Esquina");

        stage.setScene(scene);

        stage.show();

    }

}