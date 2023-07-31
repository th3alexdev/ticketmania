package com.example.ticketmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TicketSelectionController {

    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;

    private Concert selectedConcert;

    public void goHome(ActionEvent event) {
        System.out.println("volver al inicio xd");
    }

    public void setConcert(Concert concert) {
        selectedConcert = concert;

        System.out.println("Detalles del concierto seleccionado desde TICKET SELECTION:");
        System.out.println(selectedConcert.showConcert());
    }
}