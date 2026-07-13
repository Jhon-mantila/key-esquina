package com.esquinaweb.ui;

import com.esquinaweb.controller.KeyboardController;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class MainWindow {

	private HBox menu;
	private VBox content;
	
    public void show(Stage stage) {

        BorderPane root = new BorderPane();

        ModeContainer modeContainer = new ModeContainer();
        
        menu = new HBox(10);

        menu.setAlignment(Pos.CENTER);

        Button historyButton = new Button("History");

        Button gamingButton = new Button("Gaming");

        menu.getChildren().addAll(
                historyButton,
                gamingButton
        );
        
        
        historyButton.setOnAction(event -> {

            modeContainer.showHistory();
            hideMenu();

        });

        gamingButton.setOnAction(event -> {

            modeContainer.showGaming();
            hideMenu();
        });
        
        root.setCenter(modeContainer);

        content = new VBox(20);

        content.setAlignment(Pos.CENTER);

        content.getChildren().addAll(
                menu,
                modeContainer
        );

        root.setCenter(content);
        
        Scene scene = new Scene(root, 800, 500);

        KeyboardController controller =
                new KeyboardController(modeContainer);

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
    
    public void showMenu() {

        menu.setVisible(true);
        menu.setManaged(true);

    }

    public void hideMenu() {

        menu.setVisible(false);
        menu.setManaged(false);

    }
}