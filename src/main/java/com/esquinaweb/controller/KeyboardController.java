package com.esquinaweb.controller;

import com.esquinaweb.keyboard.KeyboardHook;
import com.esquinaweb.ui.HistoryPane;
import com.esquinaweb.ui.KeyboardPane;

import javafx.scene.input.KeyCode;

public class KeyboardController {

    private final KeyboardPane keyboardPane;
    private final HistoryPane historyPane;
    private final KeyboardHook keyboardHook;
    
    public KeyboardController(
            KeyboardPane keyboardPane,
            HistoryPane historyPane) {

        this.keyboardPane = keyboardPane;
        this.historyPane = historyPane;
        
        keyboardHook = new KeyboardHook(this);

    }

    public void keyPressed(KeyCode code) {

        keyboardPane.keyPressed(code);

        historyPane.addKey(code.getName());

    }

    public void keyReleased(KeyCode code) {

        keyboardPane.keyReleased(code);

    }
    
    public void start() {

        keyboardHook.register();

    }

}
