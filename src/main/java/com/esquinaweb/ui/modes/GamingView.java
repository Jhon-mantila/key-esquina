package com.esquinaweb.ui.modes;

import java.util.HashMap;
import java.util.Map;

import com.esquinaweb.contracts.ModeView;
import com.esquinaweb.ui.components.KeyView;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;

public class GamingView extends VBox implements ModeView{
	
	private final Map<KeyCode, KeyView> keyViews = new HashMap<>();
	
    private final KeyView shiftKey = new KeyView("Shift",120,60);

    private final KeyView ctrlKey = new KeyView("Ctrl",120,60);

    private final KeyView actionKey = new KeyView("...",150,80);

    private final KeyView mouseLeft = new KeyView("Mouse L",120,60);

    private final KeyView mouseRight =  new KeyView("Mouse R",120,60);
    

    public GamingView() {

        setAlignment(Pos.CENTER);

        setSpacing(20);

        HBox top = createRow();

        top.getChildren().addAll(
                shiftKey,
                ctrlKey
        );
        
        HBox center = createRow();

        center.getChildren().add(actionKey);
        
        HBox bottom = createRow();

        bottom.getChildren().addAll(
                mouseLeft,
                mouseRight
        );

        getChildren().addAll(
                top,
                center,
                bottom
        );
        
        keyViews.put(KeyCode.SHIFT, shiftKey);
        keyViews.put(KeyCode.CONTROL, ctrlKey);

    }

    private HBox createRow() {

        HBox row = new HBox(20);

        row.setAlignment(Pos.CENTER);

        return row;

    }
    
    public void setAction(String text) {

        actionKey.setText(text);

    }

    public void setShiftPressed(boolean pressed) {

        shiftKey.setKeyPressed(pressed);

    }
    
    @Override
    public void keyPressed(KeyCode code) {

        KeyView key = keyViews.get(code);

        if (key != null) {

            key.setKeyPressed(true);
            return;

        }

        actionKey.setText(code.getName());
        actionKey.setKeyPressed(true);

    }

    @Override
    public void keyReleased(KeyCode code) {

        KeyView key = keyViews.get(code);

        if (key != null) {

            key.setKeyPressed(false);
            return;

        }

        actionKey.setKeyPressed(false);

    }
    
    public void mouseLeftPressed(boolean pressed) {

        mouseLeft.setKeyPressed(pressed);

    }

    public void mouseRightPressed(boolean pressed) {

        mouseRight.setKeyPressed(pressed);

    }
}