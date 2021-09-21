package com.example.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    public Socket s;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sendButton;

    @FXML
    private TextField putWord_feild;

    @FXML
    private TextField getWord_field;

    @FXML
    private Button connectButton;

    @FXML
    private TextField ipAdress_field;

    @FXML
    private TextField port_field;

    @FXML
    void initialize() {
        connectButton.setOnAction(event -> {
            try {
                String ipAdress = ipAdress_field.getText().trim();
                String port = port_field.getText().trim();
                if (ipAdress.equals("") || port.equals("")) {
                    throw new IllegalArgumentException(" do not enter ipAdress or Port please enter good value");
                }

                this.s = new Socket(ipAdress, Integer.valueOf(port));
                PrintWriter pr = new PrintWriter(this.s.getOutputStream());
                pr.println("connect (IP " + ipAdress + " Port " + port + " )");
                pr.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException argumentException) {
                argumentException.getMessage();
            }
        });


        sendButton.setOnAction(event -> {
            try {
                String str = getWord_field.getText();

                PrintWriter pr = new PrintWriter(this.s.getOutputStream());
                pr.println(str);
                pr.flush();

                InputStreamReader in = new InputStreamReader(this.s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String strPut = bf.readLine();
                putWord_feild.setText(strPut);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.getStackTrace();
            }
        });
    }
}

/*  assert sendButton != null : "fx:id=\"sendButton\" was not injected: check your FXML file 'ClientUI.fxml'.";
        assert getWord_field != null : "fx:id=\"getWord_field\" was not injected: check your FXML file 'ClientUI.fxml'.";
        assert connectButton != null : "fx:id=\"connectButton\" was not injected: check your FXML file 'ClientUI.fxml'.";
        assert ipAdress_field != null : "fx:id=\"ipAdress_field\" was not injected: check your FXML file 'ClientUI.fxml'.";
        assert port_field != null : "fx:id=\"port_field\" was not injected: check your FXML file 'ClientUI.fxml'.";
*/