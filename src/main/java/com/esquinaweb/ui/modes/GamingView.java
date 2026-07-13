package com.esquinaweb.ui.modes;

import com.esquinaweb.contracts.ModeView;
import com.esquinaweb.ui.components.KeyView;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.KeyCode;

public class GamingView extends VBox implements ModeView{

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

        switch (code) {

            case SHIFT:
                shiftKey.setKeyPressed(true);
                break;

            case CONTROL:
                ctrlKey.setKeyPressed(true);
                break;

            default:
                actionKey.setText(code.getName());
                actionKey.setKeyPressed(true);
                break;
        }

    }

    @Override
    public void keyReleased(KeyCode code) {

        switch (code) {

            case SHIFT:
                shiftKey.setKeyPressed(false);
                break;

            case CONTROL:
                ctrlKey.setKeyPressed(false);
                break;

            default:
                actionKey.setKeyPressed(false);
                break;
        }

    }
}