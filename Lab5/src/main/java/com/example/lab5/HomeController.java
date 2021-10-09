package com.example.lab5;

/**
 * Sample Skeleton for 'bookUI.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.lab5.animations.Shake;
import com.example.lab5.book.Book;
import com.example.lab5.check.Check;
import com.example.lab5.database_handler.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class HomeController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="allTabPane"
    private TabPane allTabPane;

    @FXML // fx:id="addBookIcon"
    private Tab addBookIcon;

    @FXML // fx:id="addBookPane"
    private AnchorPane addBookPane;

    @FXML // fx:id="addButton"
    private Button addButton;

    @FXML // fx:id="author_filed"
    private TextField author_filed;

    @FXML // fx:id="nameBook_field"
    private TextField nameBook_field;

    @FXML // fx:id="language_field"
    private TextField language_field;

    @FXML // fx:id="year_field"
    private TextField year_field;

    @FXML // fx:id="page_field"
    private TextField page_field;

    @FXML // fx:id="searchBookIcon"
    private Tab searchBookIcon;

    @FXML // fx:id="searchBook"
    private AnchorPane searchBook;

    @FXML // fx:id="searchButton"
    private Button searchButton;

    @FXML // fx:id="authorSearch_field"
    private TextField authorSearch_field;

    @FXML // fx:id="nameBookSearch_field"
    private TextField nameBookSearch_field;

    @FXML // fx:id="authorList"
    private TableColumn<Book, String> authorBook;

    @FXML // fx:id="nameList"
    private TableColumn<Book, String> nameBook;

    @FXML // fx:id="languageList"
    private TableColumn<Book, String> language;

    @FXML // fx:id="yearList"
    private TableColumn<Book, Integer> yearBook;

    @FXML // fx:id="pageList"
    private TableColumn<Book, Integer> countPage;

    @FXML // fx:id="xButton"
    private Button xButton;

    @FXML // fx:id="tabViewBook"
    private TableView<Book> tabViewBook = new TableView<Book>();

    @FXML // fx:id="viewBooks"
    private Button viewBooks;

    @FXML // fx:id="editButton"
    private Button editButton;

    @FXML // fx:id="oldBookName_field"
    private TextField oldBookName_field;

    @FXML // fx:id="newAuthorName_field"
    private TextField newAuthorName_field;

    @FXML // fx:id="newBookName_field"
    private TextField newBookName_field;

    @FXML // fx:id="newLanguage_field"
    private TextField newLanguage_field;

    @FXML // fx:id="newYear_field"
    private TextField newYear_field;

    @FXML // fx:id="newPage_field"
    private TextField newPage_field;

    @FXML // fx:id="deleteButton"
    private Button deleteButton;

    @FXML // fx:id="delete_field"
    private TextField delete_field;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        addButton.setOnAction(actionEvent -> {
            addBook();
        });

        viewBooks.setOnAction(actionEvent -> {
            getBookList();
        });

        xButton.setOnAction(actionEvent -> {
            System.exit(1);
        });

        editButton.setOnAction(actionEvent -> {
            editBook();
        });

        deleteButton.setOnAction(actionEvent -> {
            deleteBook();
        });

    }

    private void addBook() {

        DataBaseHandler dbHandler = new DataBaseHandler();
        Book book = new Book();

        if (Check.isString(author_filed.getText().trim()) && Check.isString(nameBook_field.getText().trim()) &&
                Check.isString(language_field.getText().trim()) && Check.isNumber(year_field.getText().trim()) && Check.isNumber(page_field.getText().trim())) {

            book.setAuthorBook(author_filed.getText().trim());
            book.setNameBook(nameBook_field.getText().trim());
            book.setLanguage(language_field.getText().trim());
            book.setYearBook(Integer.parseInt(year_field.getText()));
            book.setCountPage(Integer.parseInt(page_field.getText()));
            dbHandler.addBookDB(book);

        } else {

            Shake author = new Shake(author_filed);
            Shake nameBook = new Shake(nameBook_field);
            Shake language = new Shake(language_field);
            Shake year = new Shake(year_field);
            Shake page = new Shake(page_field);

            author.playAnim();
            nameBook.playAnim();
            language.playAnim();
            year.playAnim();
            page.playAnim();
        }
    }

    private void getBookList() {
        try {
            DataBaseHandler dbHandler = new DataBaseHandler();
            ObservableList<Book> observableList = FXCollections.observableArrayList(dbHandler.getBookDB());
            tabViewBook.setItems(observableList);
            tabViewBook.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("authorBook"));
            tabViewBook.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("nameBook"));
            tabViewBook.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("language"));
            tabViewBook.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("yearBook"));
            tabViewBook.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("countPage"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void editBook() {

        DataBaseHandler dbHandler = new DataBaseHandler();
        ArrayList<Book> arrayList = dbHandler.getBookDB();
        Book book = new Book();
        Book bookTemp = new Book();

        if (Check.isString(oldBookName_field.getText().trim())) {
            String old = oldBookName_field.getText().trim();

            for (int i = 0; i < arrayList.size(); i++) {
                if (old.equals(arrayList.get(i).getNameBook())) {
                    bookTemp = arrayList.get(i);
                    break;
                }
            }

            if (Check.isString(newAuthorName_field.getText().trim())) {
                book.setAuthorBook(newAuthorName_field.getText().trim());
            } else {
                book.setAuthorBook(bookTemp.getAuthorBook());
            }

            if (Check.isString(newBookName_field.getText().trim())) {
                book.setNameBook(newBookName_field.getText().trim());
            } else {
                book.setNameBook(bookTemp.getNameBook());
            }

            if (Check.isString(newLanguage_field.getText().trim())) {
                book.setLanguage(newLanguage_field.getText().trim());
            } else {
                book.setLanguage(bookTemp.getLanguage());
            }

            if (Check.isNumber(newYear_field.getText().trim())) {
                book.setYearBook(Check.getNumber(newYear_field.getText().trim()));
            } else {
                book.setYearBook(bookTemp.getYearBook());
            }

            if (Check.isNumber(newPage_field.getText().trim())) {
                book.setCountPage(Check.getNumber(newPage_field.getText().trim()));
            } else {
                book.setCountPage(bookTemp.getCountPage());
            }

            dbHandler.editBookDB(old, book);

        } else {
            Shake shake = new Shake(oldBookName_field);
            shake.playAnim();
        }
    }

    private void deleteBook() {
        if (Check.isString(delete_field.getText().trim())) {
            DataBaseHandler dataBaseHandler = new DataBaseHandler();
            dataBaseHandler.deleteDB(delete_field.getText().trim());
        } else {
            Shake shakeDelete = new Shake(delete_field);
            shakeDelete.playAnim();
        }
    }

}
