package com.example.assignment2gc200521445;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


// API: https://rapidapi.com/letscrape-6bRBa3QguO5/api/jsearch

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/search_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Job Search");
        stage.getIcons().add(new Image("https://static.thenounproject.com/png/3266612-200.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}