package com.example.client.control.network;


/**
 * @author Atayev Ismayyl
 *
 *
 * */

import com.example.client.model.book.Book;
import com.example.client.model.connect.Connect;
import java.io.IOException;
import java.util.ArrayList;

public class Network {

    private Connect connect;

    public Network(Connect connect) {
        this.connect = connect;
    }

    public void sendBook(String button, String author, String bookName, String language, String year, String countPage) {
        try {
            connect.writeLine(button);
            connect.writeLine(author);
            connect.writeLine(bookName);
            connect.writeLine(language);
            connect.writeLine(year);
            connect.writeLine(countPage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getListBook(String button) throws IOException, ClassNotFoundException {
        connect.writeLine(button);
        return connect.readObjList();
    }


    public Book searchBook(String button, String oldName) {
        Book book = new Book();
        try {
            connect.writeLine(button);
            connect.writeLine(oldName);

            book.setAuthorBook(connect.readLine());
            book.setNameBook(connect.readLine());
            book.setLanguage(connect.readLine());
            book.setYearBook(Integer.parseInt(connect.readLine()));
            book.setCountPage(Integer.parseInt(connect.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    public String editBook(String button, String oldName, String author, String bookName, String language, String year, String countPage) {
        String flagEdit = new String("");
        try {
            connect.writeLine(button);
            connect.writeLine(oldName);

            connect.writeLine(author);
            connect.writeLine(bookName);
            connect.writeLine(language);
            connect.writeLine(year);
            connect.writeLine(countPage);

            flagEdit = connect.readLine();
        } catch (IOException e) {
        }
        return flagEdit;
    }

    public void close(){
        connect.close();
    }

    public String delete(String buttonDelete, String nameBookDelete) throws IOException {
        connect.writeLine(buttonDelete);
        connect.writeLine(nameBookDelete);
        return connect.readLine();
    }
}