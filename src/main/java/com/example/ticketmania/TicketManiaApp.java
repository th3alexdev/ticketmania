package com.example.ticketmania;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TicketManiaApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(TicketManiaApp.class.getResource("login.fxml"));
        Scene scene = new Scene(root.load(), 1280, 720);
        stage.setTitle("TicketMania");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}