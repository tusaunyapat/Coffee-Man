package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scenes.StartScene;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Coffee Man");

        Scene sceneStart = new StartScene(primaryStage);

        primaryStage.setScene(sceneStart);
        primaryStage.show();
        MusicController.playMusic();

    }


}
