package com.test;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class JavaFXSkel extends Application {

    public static void main(String[] args) {
        System.out.println(" Зaпycк приложе ния JavaFX ");
        Application.launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(100);   // устан
        Group group = new Group();
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }
}
