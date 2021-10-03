package com.example.client;

/**
 * Sample Skeleton for 'clientUI.fxml' Controller Class
 */



import java.io.IOException;
import java.net.*;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientController {
    private final Logger logger = LogManager.getLogger(ServiceUDP.class.getName());
    private DatagramSocket ds;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="connectButton"
    private Button connectButton; // Value injected by FXMLLoader

    @FXML // fx:id="port_feild"
    private TextField port_feild; // Value injected by FXMLLoader

    @FXML // fx:id="a_feild"
    private TextField a_feild; // Value injected by FXMLLoader

    @FXML // fx:id="b_feild"
    private TextField b_feild; // Value injected by FXMLLoader

    @FXML // fx:id="c_feild"
    private TextField c_feild; // Value injected by FXMLLoader

    @FXML // fx:id="result_feild"
    private TextField result_feild; // Value injected by FXMLLoader

    @FXML
    // This method is called by the FXMLLoader when initialization is complete

    /**
     * @throws SocketException,UnknownHostException,IOException
     * */

    void initialize() {
        connectButton.setOnAction(actionEvent -> {
            try {
                ConnectDate connectDate = new ConnectDate(ServiceUDP.checkPort(port_feild.getText().trim()));
                ABCResult abcResult = new ABCResult(Check.checkInt(a_feild.getText()), Check.checkInt(b_feild.getText().trim()), Check.checkInt(c_feild.getText()));
                ServiceUDP serviceUDP = new ServiceUDP(connectDate, abcResult);
                serviceUDP.serviceSend();
                result_feild.setText(serviceUDP.serviceReceive());
            } catch (SocketException | UnknownHostException e) {
                logger.log(Level.ERROR, e.getMessage() + " class ClientController method initialize connectButton ");
            } catch (IOException e) {
                logger.log(Level.ERROR, e.getMessage() + " class ClientController method initialize connectButton ");
            }
        });

    }
}
  /* ds = new DatagramSocket();
                InetAddress ip = InetAddress.getLocalHost();
                /*byte[] sd = new byte[1024];
                String value = a_feild.getText()+ " ";
                value += b_feild.getText() + " ";
                value += c_feild.getText();

                sd = value.getBytes();
                DatagramPacket dp = new DatagramPacket(sd, sd.length, ip, Integer.valueOf(port));
                ds.send(dp);
                byte[] rd = new byte[1024];
                DatagramPacket packet = new DatagramPacket(rd, rd.length);
                ds.receive(packet);
                String str = new String(rd,0, packet.getLength());
                result_feild.setText(str);
                ds.close();*/