package com.example.ticketmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import com.example.ticketmania.ConcertsListController;
import java.io.InputStream;

public class ConcertViewController {

    private Concert selectedConcert;

    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;

    @FXML
    private ImageView posterView;

    @FXML
    private Label artistView;

    @FXML
    private Label nameView;

    @FXML
    private Label timeView;

    @FXML
    private Label fullDateView;

    @FXML
    private Label priceView;

    @FXML
    private Label locationView;

    @FXML
    private Label dayView;

    @FXML
    private Label monthView;

    public void setConcert(Concert concert) {
        selectedConcert = concert;

        artistView.setText(selectedConcert.getArtistName());
        nameView.setText(selectedConcert.getConcertName());
        timeView.setText(selectedConcert.getTime());
        fullDateView.setText(selectedConcert.getFullDate() + ", " +  selectedConcert.getTime());
        priceView.setText(String.valueOf(selectedConcert.getPrice()));
        timeView.setText(selectedConcert.getTime());
        locationView.setText(selectedConcert.getLocation());
        dayView.setText(String.valueOf(selectedConcert.getDay()));
        monthView.setText(selectedConcert.getMonth());
        try {
            InputStream stream = getClass().getResourceAsStream(selectedConcert.getPoster());
            Image image = new Image(stream);
            posterView.setImage(image);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }


        System.out.println("Detalles del concierto seleccionado desde CONCERT VIEW:");
        System.out.println(selectedConcert.showConcert());
    }

    public void goHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("concertsList.fxml"));
            root = loader.load();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene currentScene = stage.getScene();
            double width = currentScene.getWidth();
            double heigth = currentScene.getHeight();

            scene = new Scene(root, width, heigth);
            stage.setScene(scene);
            stage.show();

            ConcertsListController concertsListController = new ConcertsListController();
            concertsListController.resetVariables();

        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
    }
    
    
}