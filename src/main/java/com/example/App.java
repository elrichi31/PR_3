package com.example;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        View v1 = new View();
        scene = new Scene(v1.createView(), 1080,750);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}