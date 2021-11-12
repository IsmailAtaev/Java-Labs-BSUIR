package com.example.dialog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class idController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id;

    @FXML
    private Button idBtn;

    @FXML
    private Button c;


    private  String ss;

    @FXML
    void getId(ActionEvent event) {
        ss = id.getText().trim();


    }
    @FXML
    void clos(ActionEvent event) {
        closeStage(event);
    }


    public String get(){
        return ss;
    }

    private void closeStage(ActionEvent event) {
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
