package com.esquinaweb.contracts;

import javafx.scene.input.KeyCode;

public interface InputView {
    void keyPressed(KeyCode code);

    void keyReleased(KeyCode code);
}
