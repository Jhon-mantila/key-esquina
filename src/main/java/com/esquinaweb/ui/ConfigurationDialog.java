package com.esquinaweb.ui;

import javafx.scene.control.Label;

import com.esquinaweb.config.ConfigManager;
import com.esquinaweb.model.WindowConfig;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;

public class ConfigurationDialog {

    private final ConfigManager configManager;
    private final WindowConfig config;
    private final Stage mainStage;

    public ConfigurationDialog(Stage mainStage, ConfigManager configManager) {

        this.mainStage = mainStage;
        this.configManager = configManager;
        this.config = configManager.getConfig();

    }
    public void show(Stage owner) {

        Stage stage = new Stage();

        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Configuración");

        CheckBox alwaysOnTop = new CheckBox("Siempre encima");
        alwaysOnTop.setStyle("-fx-font-size: 14px;");
        
        alwaysOnTop.setSelected(config.isAlwaysOnTop());
        
        alwaysOnTop.selectedProperty().addListener((obs, oldValue, newValue) -> {

            config.setAlwaysOnTop(newValue);
            mainStage.setAlwaysOnTop(newValue);

        });
        
        Label opacityLabel = new Label();
        
        opacityLabel.setStyle("-fx-font-size: 14px;");
        
        opacityLabel.setText(
                "Opacidad: " + (int)(config.getOpacity() * 100) + "%"
                
        );
        

        Slider opacity = new Slider(0.2, 1.0, config.getOpacity());
        
        opacity.valueProperty().addListener((obs, oldValue, newValue) -> {

            config.setOpacity(newValue.doubleValue());
            mainStage.setOpacity(newValue.doubleValue());
            
            opacityLabel.setText(
            	    "Opacidad: " + (int)(newValue.doubleValue() * 100) + "%"
            	);

        });
        

        Button save = new Button("Guardar");

        save.setOnAction(event -> {

            configManager.save();
            stage.close();

        });
        
        Button cancel = new Button("Cancelar");

        cancel.setOnAction(event -> {

            stage.close();

        });
        
        VBox root = new VBox(20);     
        
        
        root.setPadding(new Insets(20));
        
        HBox buttons = new HBox(10);
        
        buttons.setAlignment(Pos.CENTER_RIGHT);
        
        buttons.getChildren().addAll(
        	    save,
        	    cancel
        	);
        
        
        HBox opacityBox = new HBox(10);
        opacity.setPrefWidth(220);
        opacityBox.setAlignment(Pos.CENTER_LEFT);

        opacityBox.getChildren().addAll(
            opacity,
            opacityLabel
        );
        

        root.getChildren().addAll(
        	    alwaysOnTop,
        	    opacityBox,
        	    buttons
        );
        

        stage.setScene(new Scene(root));

        stage.showAndWait();

    }

}