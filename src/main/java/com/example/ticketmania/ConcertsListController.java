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
    public Concert selectedConcert = null;
    public int concertId = -1;


    public ConcertsListController() {
        allConcerts = new ArrayList<>();
        Concert concert1 = new Concert(
                "La Última Misión Tour",
                "Wisin y Yandel",
                12,
                "AGOS",
                "Sábado 12 Agosto",
                "07:00 PM",
                "/com/example/assets/events/wisin_y_yandel.png",
                      new int[]{1, 2, 3, 4, 5, 6}); // areas
        Concert concert2 = new Concert(
                "Indeleble",
                "Los Mesoneros",
                18,
                "AGOS",
                "Viernes 18 Agosto",
                "04:00 PM",
                "/com/example/assets/events/los_mesoneros.png",
                      new int[]{1, 2, 3, 4, 5, 6}); // areas
        Concert concert3 = new Concert(
                "Tour Me Verás Volver",
                "Soda Stereo",
                1,
                "SEP",
                "Viernes 1 Septiembre",
                "08:15 PM",
                "/com/example/assets/events/soda_stereo.png",
                       new int[]{1, 2, 3, 4, 5, 6}); // areas
        Concert concert4 = new Concert(
                "Vivir Mi Vida",
                "Mark Anthony",
                13,
                "AGOS",
                "Domingo 13 Agosto",
                "07:00 PM",
                "/com/example/assets/events/mark_anthony.png",
                        new int[]{1, 2, 3, 4, 5, 6}); // areas
        Concert concert5 = new Concert(
                "En Cambio Tour 2023",
                "Reik",
                4,
                "AGOS",
                "Viernes 4 Agosto",
                "07:00 PM",
                "/com/example/assets/events/reik.png",
                         new int[]{1, 2, 3, 4, 5, 6}); // areas
        Concert concert6 = new Concert(
                "LA CU4RTA HOJA",
                "Pablo Alborán",
                18,
                "AGOS",
                "Viernes 18 Agosto",
                "07:00 PM",
                "/com/example/assets/events/pablo_alboran.png",
                         new int[]{1, 2, 3, 4, 5, 6}); // areas

        allConcerts.add(concert1);
        allConcerts.add(concert2);
        allConcerts.add(concert3);
        allConcerts.add(concert4);
        allConcerts.add(concert5);
        allConcerts.add(concert6);
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

    public void resetVariables() {
        selectedConcert = null;
        concertId = -1;
    }

    @FXML
    public void moveNextPage(ActionEvent event) {
        selectedConcert = null;
        System.out.println(selectedConcert);
        System.out.println(concertId);

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