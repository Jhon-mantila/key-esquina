package com.esquinaweb.ui.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class KeyView extends StackPane {

	private final Label textLabel;
    
    private boolean pressed;
    
    public KeyView(String text, double width, double height) {

    	textLabel = new Label(text);
        
    	textLabel.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 18px;
                -fx-font-weight: bold;
            """);

        setAlignment(Pos.CENTER);

        setPrefSize(width, height);

        setNormal();

        getChildren().add(textLabel);
        
        textLabel.setAlignment(Pos.CENTER);

    }
    
    public KeyView(String text) {

        this(text,60,60);

    }
    
    public KeyView(String text, double size) {

        this(text, size, size);

    }

    private void setPressedStyle() {

        setStyle("""
            -fx-background-color:#58a6ff;
            -fx-background-radius:10;
            -fx-border-radius:10;
            -fx-border-color:white;
            """);

    }
    

    private void setNormal() {

        setStyle("""
            -fx-background-color:#2f2f2f;
            -fx-background-radius:10;
            -fx-border-radius:10;
            -fx-border-color:#666666;
            """);

    }
    
    
    public void setKeyPressed(boolean pressed) {

        this.pressed = pressed;

        if (pressed) {
            setPressedStyle();
        } else {
            setNormal();
        }

    }
    
    public boolean isKeyPressed() {

        return pressed;

    }
    
    public void setText(String text) {

    	textLabel.setText(text);

    }
    
    public String getText() {

        return textLabel.getText();

    }

}