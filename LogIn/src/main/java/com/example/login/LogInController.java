package com.example.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.IOException;

public class LogInController {
    @FXML
    private GridPane pnLogin;
    @FXML
    private TextField userNameTF;
    @FXML
    private PasswordField passField;
    @FXML
    private Label isValid;
    @FXML
    private Parent homeview;

    @FXML
    protected void onSignInClick() throws IOException {
        homeview = FXMLLoader.load(LogInApplication.class.getResource("hello-view.fxml"));
        AnchorPane p = (AnchorPane) pnLogin.getParent();

        if(userNameTF.getText().equals("mars") && passField.getText().equals("mars") ||
            userNameTF.getText().equals("wada") && passField.getText().equals("wada") ||
            userNameTF.getText().equals("aaa") && passField.getText().equals("aaa")){

            p.getChildren().remove(pnLogin);
            System.out.println("Na click ko");
            p.getChildren().add(homeview);
        } else {
            isValid.setText("Invalid");
        }


    }
}