package com.esquinaweb.ui;

import com.esquinaweb.contracts.ModeView;
import com.esquinaweb.ui.modes.GamingView;
import com.esquinaweb.ui.modes.HistoryView;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

public class ModeContainer extends StackPane {

    private final HistoryView historyView;
    private final GamingView gamingView;

    private ModeView currentMode;

    public ModeContainer() {

        historyView = new HistoryView();
        gamingView = new GamingView();

        showHistory();

    }

    public void showHistory() {

        currentMode = historyView;

        getChildren().setAll(historyView);

    }

    public void showGaming() {

        currentMode = gamingView;

        getChildren().setAll(gamingView);

    }

    public void keyPressed(KeyCode code) {

        currentMode.keyPressed(code);

    }

    public void keyReleased(KeyCode code) {

        currentMode.keyReleased(code);

    }

}