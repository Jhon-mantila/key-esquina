package com.esquinaweb.contracts;

import javafx.scene.input.KeyCode;

public interface ModeView {

    void keyPressed(KeyCode code);

    void keyReleased(KeyCode code);
    
    void mousePressed(int button);

    void mouseReleased(int button);

}