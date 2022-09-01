package com.flipflop.flipflop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    public Connection database;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);
        stage.setTitle("FlipFlop - Production Quality Analyser");
        stage.initStyle(StageStyle.DECORATED); // not necessary 'UNDECORATED can remove the top menu bar
        stage.setScene(scene);
        stage.show();
        DatabaseConnection connection = new DatabaseConnection();
        database = connection.getDatabaseConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}