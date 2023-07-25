package com.example.ticketmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;

public class TicketManiaController {
    @FXML
    private BorderPane login;


    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;

    @FXML
    private ImageView brand;

    @FXML
    private void handleSubmit(ActionEvent event) {
        String username = user.getText();
        String password = pass.getText();

        if (isValidUser(username, password)) {
            System.out.println("Inicio de sesión exitoso");
        } else {
            System.out.println("Credenciales inválidas. Inténtalo de nuevo.");
        }
    }

    private boolean isValidUser(String username, String password) {
        return username.equals("user") && password.equals("pass");
    }
}