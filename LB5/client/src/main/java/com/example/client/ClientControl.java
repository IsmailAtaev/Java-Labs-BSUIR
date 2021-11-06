package com.example.client;
/**
 *
 *
 * */

import com.example.client.control.network.Network;
import com.example.client.model.animation.Shake;
import com.example.client.model.book.Book;
import com.example.client.model.check.Check;
import com.example.client.model.connect.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.util.ResourceBundle;


public class ClientControl {

    private Network network;
    // private Connect connectServer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TabPane allTabPane;

    @FXML
    private Tab addBookIcon;
    @FXML
    private Tab searchBookIcon;

    @FXML
    private AnchorPane addBookPane;
    @FXML
    private AnchorPane searchBook;

    /**
     * TableColumn
     */
    @FXML
    private TableColumn<Book, String> authorBook;
    @FXML
    private TableColumn<Book, String> nameBook;
    @FXML
    private TableColumn<Book, String> language;
    @FXML
    private TableColumn<Book, Integer> yearBook;
    @FXML
    private TableColumn<Book, Integer> countPage;
    @FXML
    private TableView<Book> tabViewBook = new TableView<Book>();

    /**
     * Button
     */
    @FXML
    private Button addButton;
    @FXML
    private Button xButton;
    @FXML
    private Button viewBooks;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button searchButton;


    /**
     * TextField
     */
    @FXML
    private TextField oldBookName_field;
    @FXML
    private TextField newAuthorName_field;
    @FXML
    private TextField newBookName_field;
    @FXML
    private TextField newLanguage_field;
    @FXML
    private TextField newYear_field;
    @FXML
    private TextField newPage_field;
    @FXML
    private TextField delete_field;
    @FXML
    private TextField authorSearch_field;
    @FXML
    private TextField nameBookSearch_field;
    @FXML
    private TextField author_filed;
    @FXML
    private TextField nameBook_field;
    @FXML
    private TextField language_field;
    @FXML
    private TextField year_field;
    @FXML
    private TextField page_field;


    public ClientControl() {
        this.network = new Network(new Connect("127.0.0.1", 8189));
    }

    @FXML
    void initialize() {

        addButton.setOnAction(actionEvent -> {
            if (Check.isNumber(year_field.getText().trim()) && Check.isNumber(page_field.getText().trim()) && Check.isString(author_filed.getText().trim()) && Check.isString(nameBook_field.getText().trim()) && Check.isString(language_field.getText().trim())) {
                network.sendBook("add", author_filed.getText().trim(), nameBook_field.getText().trim(), language_field.getText().trim(), year_field.getText(), page_field.getText());
                author_filed.setText("");
                nameBook_field.setText("");
                language_field.setText("");
                year_field.setText("");
                page_field.setText("");
            } else {
                Shake authorShake = new Shake(author_filed);
                Shake nameBookShake = new Shake(nameBook_field);
                Shake languageShake = new Shake(language_field);
                Shake yearShake = new Shake(year_field);
                Shake pageShake = new Shake(page_field);
                authorShake.playAnim();
                nameBookShake.playAnim();
                languageShake.playAnim();
                yearShake.playAnim();
                pageShake.playAnim();
            }
        });

        viewBooks.setOnAction(actionEvent -> {
            try {
                ObservableList<Book> observableList = FXCollections.observableArrayList(network.getListBook("view"));
                tabViewBook.setItems(observableList);
                tabViewBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("authorBook"));
                tabViewBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("nameBook"));
                tabViewBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("language"));
                tabViewBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("yearBook"));
                tabViewBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("countPage"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        searchButton.setOnAction(actionEvent -> {
            Shake shake = new Shake(oldBookName_field);
            if (Check.isString(oldBookName_field.getText().trim())) {
                Book book = network.searchBook("search", oldBookName_field.getText().trim());
                if (book != null && !book.equals(new Book("", "", "", 0, 0))) {
                    newAuthorName_field.setText(book.getAuthorBook());
                    newBookName_field.setText(book.getNameBook());
                    newLanguage_field.setText(book.getLanguage());
                    newYear_field.setText(String.valueOf(book.getYearBook()));
                    newPage_field.setText(String.valueOf(book.getCountPage()));
                } else {
                    shake.playAnim();
                }
            } else {
                shake.playAnim();
            }
        });

        editButton.setOnAction(actionEvent -> {
            Shake shake1 = new Shake(newAuthorName_field);
            Shake shake2 = new Shake(newBookName_field);
            Shake shake3 = new Shake(newLanguage_field);
            Shake shake4 = new Shake(newYear_field);
            Shake shake5 = new Shake(newPage_field);
            Shake shake = new Shake(oldBookName_field);
            if (Check.isString(oldBookName_field.getText().trim())) {
                if (Check.isString(newAuthorName_field.getText().trim()) && Check.isString(newBookName_field.getText().trim()) && Check.isString(newLanguage_field.getText().trim()) && Check.isNumber(newYear_field.getText().trim()) && Check.isNumber(newPage_field.getText().trim())) {
                    String flagEdit = network.editBook("edit", oldBookName_field.getText().trim(), newAuthorName_field.getText().trim(), newBookName_field.getText().trim(), newLanguage_field.getText().trim(), newYear_field.getText().trim().trim(), newPage_field.getText().trim());
                    oldBookName_field.setText("");
                    newAuthorName_field.setText("");
                    newBookName_field.setText("");
                    newLanguage_field.setText("");
                    newYear_field.setText("");
                    newPage_field.setText("");
                    if (flagEdit.equals("false")) {
                        shake.playAnim();
                        shake1.playAnim();
                        shake2.playAnim();
                        shake3.playAnim();
                        shake4.playAnim();
                        shake5.playAnim();
                    }
                } else {
                    shake1.playAnim();
                    shake2.playAnim();
                    shake3.playAnim();
                    shake4.playAnim();
                    shake5.playAnim();
                }
            } else {
                shake.playAnim();
            }
        });


        deleteButton.setOnAction(actionEvent -> {
            try {
                String flagDelete = network.delete("delete", delete_field.getText().trim());
                if (flagDelete.equals("false")) {
                    Shake shake = new Shake(delete_field);
                    shake.playAnim();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            delete_field.setText("");
        });

        xButton.setOnAction(actionEvent -> {
            network.close();
            System.exit(1); // exit code 1
        });
    }
}