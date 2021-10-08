package com.example.lab5;

/**
 * Sample Skeleton for 'bookUI.fxml' Controller Class
 */

import java.net.URL;
import java.security.spec.RSAOtherPrimeInfo;
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
    private TableColumn<Book, String> authorBook; // Value injected by FXMLLoader

    @FXML // fx:id="nameList"
    private TableColumn<Book, String> nameBook; // Value injected by FXMLLoader

    @FXML // fx:id="languageList"
    private TableColumn<Book, String> language; // Value injected by FXMLLoader

    @FXML // fx:id="yearList"
    private TableColumn<Book, Integer> yearBook; // Value injected by FXMLLoader

    @FXML // fx:id="pageList"
    private TableColumn<Book, Integer> countPage; // Value injected by FXMLLoader

    @FXML // fx:id="xButton"
    private Button xButton; // Value injected by FXMLLoader

    @FXML // fx:id="tabViewBook"
    private TableView<Book> tabViewBook = new TableView<Book>(); // Value injected by FXMLLoader

    @FXML // fx:id="viewBooks"
    private Button viewBooks; // Value injected by FXMLLoader

    @FXML // fx:id="editButton"
    private Button editButton; // Value injected by FXMLLoader

    @FXML // fx:id="oldBookName_field"
    private TextField oldBookName_field; // Value injected by FXMLLoader

    @FXML // fx:id="newAuthorName_field"
    private TextField newAuthorName_field; // Value injected by FXMLLoader

    @FXML // fx:id="newBookName_field"
    private TextField newBookName_field; // Value injected by FXMLLoader

    @FXML // fx:id="newLanguage_field"
    private TextField newLanguage_field; // Value injected by FXMLLoader

    @FXML // fx:id="newYear_field"
    private TextField newYear_field; // Value injected by FXMLLoader

    @FXML // fx:id="newPage_field"
    private TextField newPage_field; // Value injected by FXMLLoader


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

    }

    private void addBook() {

        DataBaseHandler dbHandler = new DataBaseHandler();
        Book book = new Book();

        if (Check.isString(author_filed.getText().trim()) && Check.isString(nameBook_field.getText().trim()) &&
                Check.isString(language_field.getText().trim()) && Check.isNumber(year_field.getText().trim()) &&
                Check.isNumber(page_field.getText().trim())) {

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

            // authorBook = new TableColumn<Book, String>("Author");
            // authorBook  = new TableColumn<Book, String>("Author");
            //authorBook.setCellValueFactory(new PropertyValueFactory<Book, String>("authorBook"));

            /*
            tabViewBook.getColumns().stream().filter(x -> x.getText() == "Author").findFirst().get().setCellValueFactory(new PropertyValueFactory("authorBook"));
            tabViewBook.getColumns().stream().filter(x -> x.getText() == "Name").findFirst().get().setCellValueFactory(new PropertyValueFactory("nameBook"));
            tabViewBook.getColumns().stream().filter(x -> x.getText() == "Language").findFirst().get().setCellValueFactory(new PropertyValueFactory("language"));
            tabViewBook.getColumns().stream().filter(x -> x.getText() == "Year").findFirst().get().setCellValueFactory(new PropertyValueFactory("yearBook"));
            tabViewBook.getColumns().stream().filter(x -> x.getText() == "page").findFirst().get().setCellValueFactory(new PropertyValueFactory("countPage"));
            */

            /* authorBook.setCellValueFactory(new PropertyValueFactory<Book, String>("authorBook"));
             nameBook.setCellValueFactory(new PropertyValueFactory<Book,String>("nameBook"));
             language.setCellValueFactory(new PropertyValueFactory<Book,String>("language"));
             yearBook.setCellValueFactory(new PropertyValueFactory<Book,Integer>("yearBook"));
             countPage.setCellValueFactory(new PropertyValueFactory<Book,Integer>("countPage"));

             tabViewBook.getColumns().addAll(authorBook,nameBook,language,yearBook,countPage);
             tabViewBook.setItems(bookObservableLis);
            /*  Book book = new Book();

            for(Field book1 : book.getClass().getDeclaredFields()) {
                System.out.println(book1.getName());
            }


             authorList = new TableColumn<Book, String>("Author");
             authorList.setCellValueFactory(celldata -> new ObservableValue<String>() { });
             tabViewBook.getColumns().add(authorList);*/

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void editBook() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        Book book = new Book();
        Book bookTemp = new Book();
        ArrayList<Book> arrayList = dbHandler.getBookDB();


        if (Check.isString(oldBookName_field.getText().trim())) {
            String old = oldBookName_field.getText().trim();

            for(int i = 0; i < arrayList.size(); i++){
                if(old.equals(arrayList.get(i).getNameBook())){
                    bookTemp = arrayList.get(i);
                    break;
                }
            }

            if (Check.isString(newAuthorName_field.getText().trim())) {
                book.setAuthorBook(newAuthorName_field.getText().trim());
            } else {
                book.setAuthorBook(bookTemp.getAuthorBook());
            }

            if(Check.isString(newBookName_field.getText().trim())){
                book.setNameBook(newBookName_field.getText().trim());
            } else {
                book.setNameBook(bookTemp.getNameBook());
            }

            if(Check.isString(newLanguage_field.getText().trim())){
                book.setLanguage(newLanguage_field.getText().trim());
            } else {
                book.setLanguage(bookTemp.getLanguage());
            }

            if(Check.isNumber(newYear_field.getText().trim())){
                book.setYearBook(Check.getNumber(newYear_field.getText().trim()));
            } else {
                book.setYearBook(bookTemp.getYearBook());
            }

            if(Check.isNumber(newPage_field.getText().trim())){
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
}
