
module com.example.lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires org.junit.jupiter.api;

    opens com.example.lab5 to javafx.fxml;
    exports com.example.lab5;
    exports com.example.lab5.book;
    opens com.example.lab5.book to javafx.fxml;
}