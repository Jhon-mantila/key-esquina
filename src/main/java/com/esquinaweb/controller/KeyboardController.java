package com.esquinaweb.controller;

import com.esquinaweb.keyboard.KeyboardHook;

import com.esquinaweb.ui.ModeContainer;
import com.esquinaweb.ui.modes.HistoryView;

import javafx.scene.input.KeyCode;

public class KeyboardController {

	private final ModeContainer modeContainer;
	private final KeyboardHook keyboardHook;
	
    public KeyboardController(ModeContainer modeContainer) {

    	this.modeContainer = modeContainer;
    	
        keyboardHook = new KeyboardHook(this);

    }

    public void keyPressed(KeyCode code) {

    	modeContainer.keyPressed(code);

    }

    public void keyReleased(KeyCode code) {

    	modeContainer.keyReleased(code);

    }
    
    public void start() {

        keyboardHook.register();

    }

}
