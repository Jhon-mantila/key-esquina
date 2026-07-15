package com.esquinaweb;

import com.esquinaweb.ui.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

    	stage.initStyle(StageStyle.TRANSPARENT);
    	
        new MainWindow().show(stage);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}