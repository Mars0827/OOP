package com.example.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HomeController {

    @FXML
    private AnchorPane pnLogOut;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Parent logIn;



    @FXML
    protected void onLogOutClick() throws IOException {
        logIn = FXMLLoader.load(LogInApplication.class.getResource("hello-view.fxml"));
        AnchorPane p = (AnchorPane) logIn.getParent();

        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(getClass().getResource("hello.css").getPath()));
            bw.close();
        }catch (IOException e){}

        Parent pnMain = FXMLLoader.load(LogInApplication.class.getResource("login-view.fxml"));
        AnchorPane pane = (AnchorPane) pnLogOut.getParent();
        pane.getChildren().remove(pnLogOut);
        pane.getChildren().add(pnMain);

    }


}

