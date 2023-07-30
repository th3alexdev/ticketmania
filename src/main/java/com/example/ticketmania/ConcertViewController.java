package com.example.ticketmania;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class ConcertViewController {

    private Concert selectedConcert;

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

    public void setConcert(Concert concert) {
        selectedConcert = concert;

        artistView.setText(selectedConcert.getArtistName());
        nameView.setText(selectedConcert.getConcertName());
        timeView.setText(selectedConcert.getTime());
        fullDateView.setText(selectedConcert.getFullDate());
        priceView.setText(String.valueOf(selectedConcert.getPrice()));
        locationView.setText(selectedConcert.getLocation());

        System.out.println("Detalles del concierto seleccionado desde CONCERT VIEW:");
        System.out.println(selectedConcert.showConcert());
    }
}