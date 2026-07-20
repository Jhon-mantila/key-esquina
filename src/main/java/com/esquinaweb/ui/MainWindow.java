package com.esquinaweb.ui;

import javafx.scene.paint.Color;

import com.esquinaweb.config.ConfigManager;
import com.esquinaweb.keyboard.KeyboardHook;
import com.esquinaweb.model.Mode;
import com.esquinaweb.model.WindowConfig;
import com.esquinaweb.mouse.MouseHook;
import javafx.application.Platform;

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
	
	private boolean overlayMode = false;
	
    public void show(Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: transparent;");
        
        ConfigManager configManager = new ConfigManager();

        WindowConfig config = configManager.getConfig();

        ModeContainer modeContainer = new ModeContainer();
        
        menu = new HBox(10);

        menu.setAlignment(Pos.CENTER);

        Button historyButton = new Button("History");

        Button gamingButton = new Button("Gaming");

        Button configurationButton = new Button("⚙");
        
        Button overlayButton = new Button("👁");

        menu.getChildren().addAll(
                historyButton,
                gamingButton,
                configurationButton,
                overlayButton
        );
        
        ConfigurationDialog configurationDialog = new ConfigurationDialog(stage, configManager);
        
        historyButton.setOnAction(event -> {
        	System.out.println("History");
        	modeContainer.show(Mode.HISTORY);
            hideMenu();

        });

        gamingButton.setOnAction(event -> {
        	System.out.println("Gaming");
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
        
	        configurationButton.setOnAction(event -> {

	            configurationDialog.show(stage);

	            stage.setAlwaysOnTop(config.isAlwaysOnTop());
	            stage.setOpacity(config.getOpacity());

	        });
	        
	        
	        overlayButton.setOnAction(event -> {

	            toggleOverlay();

	        });
	        

	        KeyboardHook keyboardHook = new KeyboardHook(modeContainer);
	        MouseHook mouseHook = new MouseHook(modeContainer);

	        Platform.runLater(() -> {

	            keyboardHook.register();
	            mouseHook.register();

	        });
	        

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
    
    private void toggleOverlay() {

        overlayMode = !overlayMode;

        if (overlayMode) {

            hideMenu();

        } else {

            showMenu();

        }

    }
}
