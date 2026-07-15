package com.esquinaweb.mouse;

import com.esquinaweb.ui.ModeContainer;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

import javafx.application.Platform;

public class MouseHook implements NativeMouseInputListener {
	
	private final ModeContainer modeContainer;
	
	public MouseHook(ModeContainer modeContainer) {

		this.modeContainer = modeContainer;

	}
	
	public void register() {

	    try {

	        GlobalScreen.addNativeMouseListener(this);

	        GlobalScreen.addNativeMouseMotionListener(this);

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getButton());
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		Platform.runLater(() -> {

		    modeContainer.mousePressed(arg0.getButton());

		});
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		Platform.runLater(() -> {

		    modeContainer.mouseReleased(arg0.getButton());

		});
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	



}
