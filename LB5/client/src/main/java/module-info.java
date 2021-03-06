module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.client to javafx.fxml;
    exports com.example.client;
    exports com.example.client.model.book;
    opens com.example.client.model.book to javafx.fxml;

}