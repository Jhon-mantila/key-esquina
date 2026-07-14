package com.esquinaweb.ui;

import com.esquinaweb.contracts.ModeView;
import com.esquinaweb.ui.modes.GamingView;
import com.esquinaweb.ui.modes.HistoryView;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import com.esquinaweb.model.Mode;

public class ModeContainer extends StackPane {

    private final HistoryView historyView;
    private final GamingView gamingView;

    private ModeView currentMode;

    public ModeContainer() {

        historyView = new HistoryView();
        gamingView = new GamingView();

        show(Mode.HISTORY);

    }

    public void show(Mode mode) {

        switch (mode) {

            case HISTORY:

                currentMode = historyView;

                getChildren().setAll(historyView);

                break;

            case GAMING:

                currentMode = gamingView;

                getChildren().setAll(gamingView);

                break;

        }

    }

    public void keyPressed(KeyCode code) {

        currentMode.keyPressed(code);

    }

    public void keyReleased(KeyCode code) {

        currentMode.keyReleased(code);

    }

}