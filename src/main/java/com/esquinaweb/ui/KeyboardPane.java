package com.esquinaweb.ui;

import com.esquinaweb.contracts.InputView;
import com.esquinaweb.ui.components.KeyView;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;


public class KeyboardPane extends VBox implements InputView {
	
	private final Map<KeyCode, KeyView> keys = new HashMap<>();
	
	private final KeyView mouseLeft = new KeyView("Mouse L",120,60);
	private final KeyView mouseRight = new KeyView("Mouse R",120,60);
	
	private final Label lastKeyLabel = new Label("Última tecla: Ninguna");
	
    public KeyboardPane() {

        setAlignment(Pos.CENTER);
        setSpacing(10);

        lastKeyLabel.setStyle("""
        	    -fx-text-fill: white;
        	    -fx-font-size: 18px;
        	    -fx-font-weight: bold;
        	    """);

        getChildren().add(lastKeyLabel);
        	
        // ---------------- Fila W ----------------

        getChildren().add(createMovementRow());

        // ---------------- Fila ASD ----------------

        getChildren().add(createActionRow());

        // ---------------- Fila Shift Space ----------------

        getChildren().add(createBottomRow());
        
        // ---------------- Fila Mouse ----------------

        getChildren().add(createMouseRow());
        
    }
    private KeyView createKey(KeyCode code, String text) {

        return createKey(code, text, 60, 60);

    }
    
    private KeyView createKey(KeyCode code, String text, double width, double height) {

        KeyView key = new KeyView(text, width, height);

        keys.put(code, key);

        return key;

    }
    
    public void keyPressed(KeyCode code){
    	
    	lastKeyLabel.setText("Última tecla: " + code.getName());
    	
        KeyView key = keys.get(code);

        if(key != null){

        	key.setKeyPressed(true);

        }

    }
    
    public void keyReleased(KeyCode code){

        KeyView key = keys.get(code);

        if(key != null){

        	key.setKeyPressed(false);

        }

    }
    
    private HBox createRow() {

        HBox row = new HBox(10);

        row.setAlignment(Pos.CENTER);

        return row;

    }
    
    private HBox createMovementRow() {

        HBox row = createRow();

        row.getChildren().add(
                createKey(KeyCode.W, "W")
        );

        return row;

    }
    
    private HBox createActionRow() {

        HBox row = createRow();

        row.getChildren().addAll(
                createKey(KeyCode.A, "A"),
                createKey(KeyCode.S, "S"),
                createKey(KeyCode.D, "D")
        );

        return row;

    }
    
    private HBox createBottomRow() {
    	
        HBox row = createRow();

        row.getChildren().addAll(
                createKey(KeyCode.SHIFT, "Shift", 120, 60),
                createKey(KeyCode.SPACE, "Space", 220, 60)
                );
        
        return row;
        
    }
    
    private HBox createMouseRow() {
    	
        HBox row = createRow();

        row.getChildren().addAll(
                mouseLeft,
                mouseRight
        );
        
        return row;
    }

}