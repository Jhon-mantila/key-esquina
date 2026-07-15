package com.esquinaweb.model;

public class WindowConfig {
	
    private boolean alwaysOnTop = true;
    private boolean transparent = false;
    private boolean decorated = true;
    
    private double opacity = 1.0;

    public boolean isAlwaysOnTop() {
        return alwaysOnTop;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public boolean isDecorated() {
        return decorated;
    }
    

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }
    
}
