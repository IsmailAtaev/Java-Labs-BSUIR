package com.example.dialog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {



   private String s;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add.fxml"));
        Parent parent = fxmlLoader.load();
        idController dialogController = fxmlLoader.getController();
        //dialogController.getI(s);
        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        s = dialogController.get();
        System.out.println(s);
    }




}