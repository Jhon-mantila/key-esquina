package com.esquinaweb.keyboard;

import com.esquinaweb.controller.KeyboardController;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

public class KeyboardHook implements NativeKeyListener {

	private final KeyboardController controller;
	
	public KeyboardHook(KeyboardController controller) {

	    this.controller = controller;

	}
	
    public void register() {

        try {

            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(this);

        } catch (NativeHookException e) {

            e.printStackTrace();

        }

    }
    
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
    	
    	KeyCode code = KeyCodeMapper.toKeyCode(e.getKeyCode());
    	
    	
    	if (code != null) {
    	    Platform.runLater(() -> {
    	        controller.keyPressed(code);
    	    });

    	}
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
    	
        KeyCode code = KeyCodeMapper.toKeyCode(e.getKeyCode());

        if (code != null) {

            Platform.runLater(() -> {
                controller.keyReleased(code);
            });

        }
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

}
