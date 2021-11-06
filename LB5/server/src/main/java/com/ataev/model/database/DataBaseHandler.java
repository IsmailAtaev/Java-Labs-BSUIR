package com.ataev.model.database;


import com.ataev.model.configs.Configs;
import com.ataev.model.configs.Const;
import com.example.client.model.book.Book;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author Ataev Ismayyl
 * бизнес логика отделена от хранения объектов, по всей возможности сделал
 * */

public class DataBaseHandler extends Configs {

    Connection dbConnection;

    /**
     * @return Connection
     * @throws ClassNotFoundException,SQLException
     */

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }


    public void editBookDB(String oldNameBook, Book book) {
        try {
            String update = "UPDATE " + Const.BOOKS_TABLE +
                    " SET " + Const.BOOKS_AUTHOR + "=?, " + Const.BOOKS_NAME + "=?, " + Const.BOOKS_LANGUAGE + "=?, " + Const.BOOKS_YEAR + "=?, " + Const.BOOKS_COUNTPAGE + "=? " +
                    " WHERE " + Const.BOOKS_NAME + "=?";

            PreparedStatement preparedStatement = getDbConnection().prepareStatement(update);

            preparedStatement.setString(1, book.getAuthorBook());
            preparedStatement.setString(2, book.getNameBook());
            preparedStatement.setString(3, book.getLanguage());
            preparedStatement.setInt(4, book.getYearBook());
            preparedStatement.setInt(5, book.getCountPage());
            preparedStatement.setString(6, oldNameBook);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {

        } catch (ClassNotFoundException e) {

        }
    }

    public void addBookDB(Book book) {
        String insert = "INSERT INTO " + Const.BOOKS_TABLE + "(" +
                Const.BOOKS_AUTHOR + "," + Const.BOOKS_NAME + "," +
                Const.BOOKS_LANGUAGE + "," + Const.BOOKS_YEAR + "," +
                Const.BOOKS_COUNTPAGE + ")" +
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, book.getAuthorBook());
            prSt.setString(2, book.getNameBook());
            prSt.setString(3, book.getLanguage());
            prSt.setString(4, String.valueOf(book.getYearBook()));
            prSt.setString(5, String.valueOf(book.getCountPage()));
            prSt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Book> getBookDB() {
        ArrayList<Book> arrayList = new ArrayList<>();
        try {
            String select = "SELECT * FROM " + Const.BOOKS_TABLE;
            Statement statement = getDbConnection().createStatement();
            ResultSet resSet = statement.executeQuery(select);
            while (resSet.next()) {
                Book book1 = new Book();
                book1.setAuthorBook(resSet.getString(2));
                book1.setNameBook(resSet.getString(3));
                book1.setLanguage(resSet.getString(4));
                book1.setYearBook(resSet.getInt(5));
                book1.setCountPage(resSet.getInt(6));
                arrayList.add(book1);
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
        return arrayList;
    }

    public void deleteDB(String deleteValue) {
        try {
            String DELETE = "DELETE FROM " + Const.BOOKS_TABLE + " WHERE " + Const.BOOKS_NAME + "='" + deleteValue + "'; ";
            PreparedStatement preparedStatementDelete = getDbConnection().prepareStatement(DELETE);
            preparedStatementDelete.executeUpdate();
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
    }


}
