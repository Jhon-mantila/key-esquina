package com.esquinaweb.mouse;

import com.esquinaweb.controller.MouseController;
import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.mouse.NativeMouseEvent;
import com.github.kwhat.jnativehook.mouse.NativeMouseInputListener;

public class MouseHook implements NativeMouseInputListener {
	
	private final MouseController controller;
	
	public MouseHook(MouseController controller) {

	    this.controller = controller;

	}
	
	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void register() {

	    try {

	        GlobalScreen.addNativeMouseListener(this);

	        GlobalScreen.addNativeMouseMotionListener(this);

	    } catch (Exception e) {

	        e.printStackTrace();

	    }

	}


}
