package com.esquinaweb.ui;

import javafx.scene.paint.Color;

import com.esquinaweb.config.ConfigManager;
import com.esquinaweb.keyboard.KeyboardHook;
import com.esquinaweb.model.Mode;
import com.esquinaweb.model.WindowConfig;
import com.esquinaweb.mouse.MouseHook;

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
	
	private double offsetX;
	private double offsetY;
	
    public void show(Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: transparent;");
        
        ModeContainer modeContainer = new ModeContainer();
        
        ConfigManager configManager = new ConfigManager();

        WindowConfig config = configManager.getConfig();
        
        menu = new HBox(10);

        menu.setAlignment(Pos.CENTER);

        Button historyButton = new Button("History");

        Button gamingButton = new Button("Gaming");

        menu.getChildren().addAll(
                historyButton,
                gamingButton
        );
        
        
        historyButton.setOnAction(event -> {

        	modeContainer.show(Mode.HISTORY);
            hideMenu();

        });

        gamingButton.setOnAction(event -> {

        	modeContainer.show(Mode.GAMING);
            hideMenu();
        });
        
        root.setCenter(modeContainer);

        content = new VBox(20);
        content.setStyle("-fx-background-color: transparent;");
        
        content.setAlignment(Pos.CENTER);

        content.getChildren().addAll(
                menu,
                modeContainer
        );

        root.setCenter(content);
        
        Scene scene = new Scene(root, 800, 500);
        //config.setOpacity(0.2);
        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
        stage.setOpacity(config.getOpacity());
        
        
       
        
	        scene.setOnMousePressed(event -> {
	
	            offsetX = event.getSceneX();
	            offsetY = event.getSceneY();
	
	        });
	
	        scene.setOnMouseDragged(event -> {
	
	            stage.setX(event.getScreenX() - offsetX);
	            stage.setY(event.getScreenY() - offsetY);
	
	        });
        

        KeyboardHook keyboardHook = new KeyboardHook(modeContainer);

        keyboardHook.register();
        
        MouseHook mouseHook = new MouseHook(modeContainer);

        mouseHook.register();

        stage.setTitle("Key Esquina");
        stage.setScene(scene);
        
        stage.setAlwaysOnTop(config.isAlwaysOnTop());
        
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