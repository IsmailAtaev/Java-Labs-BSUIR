package com.example.lab5;

/**
 * Sample Skeleton for 'bookUI.fxml' Controller Class
 */


import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.example.lab5.book.Book;
import com.example.lab5.database_handler.DataBaseHandler;
import javafx.beans.value.ObservableValue;
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
    private TabPane allTabPane; // Value injected by FXMLLoader

    @FXML // fx:id="addBookIcon"
    private Tab addBookIcon; // Value injected by FXMLLoader

    @FXML // fx:id="addBookPane"
    private AnchorPane addBookPane; // Value injected by FXMLLoader

    @FXML // fx:id="addButton"
    private Button addButton; // Value injected by FXMLLoader

    @FXML // fx:id="author_filed"
    private TextField author_filed; // Value injected by FXMLLoader

    @FXML // fx:id="nameBook_field"
    private TextField nameBook_field; // Value injected by FXMLLoader

    @FXML // fx:id="language_field"
    private TextField language_field; // Value injected by FXMLLoader

    @FXML // fx:id="year_field"
    private TextField year_field; // Value injected by FXMLLoader

    @FXML // fx:id="page_field"
    private TextField page_field; // Value injected by FXMLLoader

    @FXML // fx:id="searchBookIcon"
    private Tab searchBookIcon; // Value injected by FXMLLoader

    @FXML // fx:id="searchBook"
    private AnchorPane searchBook; // Value injected by FXMLLoader

    @FXML // fx:id="searchButton"
    private Button searchButton; // Value injected by FXMLLoader

    @FXML // fx:id="authorSearch_field"
    private TextField authorSearch_field; // Value injected by FXMLLoader

    @FXML // fx:id="nameBookSearch_field"
    private TextField nameBookSearch_field; // Value injected by FXMLLoader

    @FXML // fx:id="N"
    private TableColumn<Integer, Integer> N; // Value injected by FXMLLoader

    @FXML // fx:id="authorList"
    private TableColumn<Book, String> authorList; // Value injected by FXMLLoader

    @FXML // fx:id="nameList"
    private TableColumn<Book, String> nameList; // Value injected by FXMLLoader

    @FXML // fx:id="languageList"
    private TableColumn<Book, String> languageList; // Value injected by FXMLLoader

    @FXML // fx:id="yearList"
    private TableColumn<Book, Integer> yearList; // Value injected by FXMLLoader

    @FXML // fx:id="pageList"
    private TableColumn<Book, Integer> pageList; // Value injected by FXMLLoader

    @FXML // fx:id="xButton"
    private Button xButton; // Value injected by FXMLLoader

    @FXML // fx:id="tabViewBook"
    private TableView<Book> tabViewBook; // Value injected by FXMLLoader

    @FXML // fx:id="viewBooks"
    private Button viewBooks; // Value injected by FXMLLoader



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

        addButton.setOnAction(actionEvent -> { addBook();});
        viewBooks.setOnAction(actionEvent -> { getBookList();});
        xButton.setOnAction(actionEvent -> {System.exit(01);});
        // allTabPane.getSelectionModel().select(addBookIcon);
    }

    private void addBook() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Book book = new Book();
        book.setAuthorBook(author_filed.getText().trim());
        book.setNameBook(nameBook_field.getText().trim());
        book.setLanguage(language_field.getText().trim());
        book.setYearBook(Integer.valueOf(year_field.getText()));
        book.setCountPage(Integer.valueOf(page_field.getText()));
        dbHandler.addBookDB(book);
    }
    private void getBookList() {

        try {
            DataBaseHandler dbHandler = new DataBaseHandler();
            ArrayList<Book> bookArrayList = dbHandler.getBookDB();
            ObservableList<Book> bookObservableList = FXCollections.observableArrayList(bookArrayList);
            tabViewBook.setItems(bookObservableList);


          /*  Book book = new Book();

            for(Field book1 : book.getClass().getDeclaredFields()) {
                System.out.println(book1.getName());
            }
*/
            //authorList = new TableColumn<Book, String>("Aughtor");
        //    authorList.setCellValueFactory(celldata -> new ObservableValue<String>() { });
       //     tabViewBook.getColumns().add(authorList);



        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
