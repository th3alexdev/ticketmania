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
import javafx.scene.layout.HBox;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class LoginController {
    @FXML
    private Parent root;
    @FXML
    private HBox errorMessage;
    @FXML
    private TextField passText;
    @FXML
    private PasswordField passHidden;
    @FXML
    private TextField user;
    @FXML
    private CheckBox showPass;
    @FXML
    private BorderPane login;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;

    @FXML
    private Button submit;

    /* -- */

    @FXML
    private void handleSubmit(ActionEvent event) {
        String username = user.getText();
        String password = showPass.isSelected() ? passText.getText() : passHidden.getText();

        if (isValidUser(username, password)) {
            System.out.println("Inicio de sesión exitoso");
            login(event);
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

   public void login(ActionEvent event) {
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
       } catch (NullPointerException | IOException e) {
           System.out.println(e);
       }
   }
}