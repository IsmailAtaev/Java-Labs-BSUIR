package JDBCTesting;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "ismail123";
        String connectionUrl = "jdbc:mysql://localhost:3306/test";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl,userName,password)){
            Statement statement = connection.createStatement();
           // statement.executeUpdate("INSERT INTO Books (name) VALUE('Inferno')");
          //  statement.executeUpdate("INSERT INTO Books set name = 'Solomon key'");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Books");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString("name"));
                System.out.println("--------------------------------------");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
