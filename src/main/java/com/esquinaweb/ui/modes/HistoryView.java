package com.esquinaweb.ui.modes;

import com.esquinaweb.contracts.ModeView;
import com.esquinaweb.ui.components.KeyView;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.input.KeyCode;

public class HistoryView extends HBox implements ModeView {
	
	private static final int MAX_HISTORY = 4;
	
	
    public HistoryView() {

        setSpacing(10);

        setAlignment(Pos.CENTER);

    }
    
    public void addKey(String text) {

        if(getChildren().size() >= MAX_HISTORY) {

            getChildren().removeFirst();

        }

        double width = text.startsWith("Mouse") ? 110 : 60;

        getChildren().add(new KeyView(text, width, 60));

    }
    
    public void keyPressed(KeyCode code) {

        addKey(code.getName());

    }

    public void keyReleased(KeyCode code) {

        // Por ahora no hacemos nada.

    }
    
    @Override
    public void mousePressed(int button) {

        switch (button) {
            case 1:
                addKey("Mouse L");
                break;
            case 2:
                addKey("Mouse M");
                break;
            case 3:
                addKey("Mouse R");
                break;
            default:
                addKey("Mouse " + button);
                break;
        }

    }

    @Override
    public void mouseReleased(int button) {

    }
}
