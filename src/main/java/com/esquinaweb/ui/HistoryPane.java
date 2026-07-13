package com.esquinaweb.ui;

import com.esquinaweb.ui.components.KeyView;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class HistoryPane extends HBox {
	
	private static final int MAX_HISTORY = 4;
	
    public HistoryPane() {

        setSpacing(10);

        setAlignment(Pos.CENTER);

    }
    
    public void addKey(String text) {

        if(getChildren().size() >= MAX_HISTORY) {

            getChildren().removeFirst();

        }

        getChildren().add(new KeyView(text));

    }
}
