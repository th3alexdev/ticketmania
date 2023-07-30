package com.example.ticketmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import com.example.ticketmania.Concert;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.example.ticketmania.ConcertViewController;

public class ConcertsListController {

    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Stage stage;


    private List<Concert> allConcerts;
    private int concertId = -1;
    public ConcertsListController() {
        allConcerts = new ArrayList<>();
        Concert concert1 = new Concert(
                "La Última Misión Tour",
                "Wisin y Yandel",
                "12 AGOS",
                "Sábado 12 Agosto",
                "07:00 PM",
                "..\\assets\\events\\Wisin y Yandel_3.jpg");
        allConcerts.add(concert1);
    }

    @FXML
    public void setConcert(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getId();

        switch (buttonId) {
            case ("buttonConcert1"):
                concertId = 1;
                break;

            case ("buttonConcert2"):
                concertId = 2;
                break;

            case ("buttonConcert3"):
                concertId = 3;
                break;

            case ("buttonConcert4"):
                concertId = 4;
                break;

            case ("buttonConcert5"):
                concertId = 5;
                break;

            default:
                concertId = 6;
                break;
        }
    }


    @FXML
    public void moveNextPage(ActionEvent event) {

        Concert selectedConcert = null;

        for (Concert concert : allConcerts) {
            if (concert.getId() == concertId) {
                selectedConcert = concert;
                // System.out.println("Concierto seleccionado desde CONCERT LIST:");
                // System.out.println(concert.showConcert());


                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("concertView.fxml"));
                    root = loader.load();

                    ConcertViewController concertViewController = loader.getController();
                    concertViewController.setConcert(selectedConcert);

                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene currentScene = stage.getScene();
                    double width = currentScene.getWidth();
                    double heigth = currentScene.getHeight();

                    scene = new Scene(root, width, heigth);
                    stage.setScene(scene);
                    stage.show();
                } catch (NullPointerException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}