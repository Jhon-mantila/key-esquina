package com.esquinaweb.ui;

import java.util.HashMap;
import java.util.Map;

import com.esquinaweb.contracts.ModeView;
import com.esquinaweb.ui.modes.GamingView;
import com.esquinaweb.ui.modes.HistoryView;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import com.esquinaweb.model.Mode;

public class ModeContainer extends StackPane {
	
	private final Map<Mode, ModeView> modes = new HashMap<>();
	private Mode currentMode;
	
    //private ModeView currentMode;

    public ModeContainer() {

    	modes.put(Mode.HISTORY, new HistoryView());
    	modes.put(Mode.GAMING, new GamingView());


        show(Mode.HISTORY);

    }

    public void show(Mode mode) {

    	currentMode = mode;

    	getChildren().setAll((javafx.scene.Node) modes.get(mode));

    }

    public void keyPressed(KeyCode code) {

    	modes.get(currentMode).keyPressed(code);

    }

    public void keyReleased(KeyCode code) {

    	modes.get(currentMode).keyReleased(code);

    }
    
    public void mousePressed(int button) {

    	modes.get(currentMode).mousePressed(button);

    }

    public void mouseReleased(int button) {

    	modes.get(currentMode).mouseReleased(button);

    }

}
