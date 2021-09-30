/**
 * Sample Skeleton for 'serverUI.fxml' Controller Class
 */

package com.example.server;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ServerController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="inputPortButton"
    private Button inputPortButton; // Value injected by FXMLLoader

    @FXML // fx:id="port_feild"
    private TextField port_feild; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        inputPortButton.setOnAction(actionEvent -> {
            System.out.println(" hello ");
        });
    }
}
