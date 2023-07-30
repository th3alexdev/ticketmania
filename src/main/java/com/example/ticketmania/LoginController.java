package com.example.ticketmania;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TicketManiaController {
    @FXML
    private Parent root;
    private BorderPane login;
    private CheckBox showPass;
    private TextField user;
    private PasswordField passHidden;
    private TextField passText;
    private ImageView brand;
    private HBox errorMessage;



    /* -- */

    @FXML
    private void handleSubmit(ActionEvent event) {
        String username = user.getText();
        String password = showPass.isSelected() ? passText.getText() : passHidden.getText();

        if (isValidUser(username, password)) {
            System.out.println("Inicio de sesión exitoso");
        } else {
            errorMessage.setVisible(true);
            user.clear();
            passText.clear();
            passHidden.clear();
        }
    }

    private boolean isValidUser(String username, String password) {
        return username.equals("user") && password.equals("pass");
    }

    @FXML
    public void togglePasswordVisibility(ActionEvent event) {
        String password = passHidden.getText();

        if (showPass.isSelected()) {
            passText.setText(password);
            passText.setVisible(true);
            passHidden.setVisible(false);
        } else {
            passHidden.setText(password);
            passHidden.setVisible(true);
            passText.setVisible(false);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        this.togglePasswordVisibility(null);
    }

    public void cambiarEscena(ActionEvent event) {
        scene = new Scene(root, width, heigth);
        stage.setScene(scene);
        stage.show();
    }
}