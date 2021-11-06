package com.ataev.control.servercontroller;


import com.ataev.model.connect.Connect;
import com.ataev.model.database.DataBaseHandler;
import com.example.client.model.book.Book;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ServerController {

    private static int countClient = 0;

    private Connect connect;


    public ServerController(ServerSocket serverSocket) {
        this.connect = new Connect(serverSocket);
        countClient++;
    }

    public ServerController() {
    }

    public ServerController(Connect connect) {
        this.connect = connect;
        countClient++;
    }

    public synchronized void work(ServerSocket serverSocket) {
        this.connect = new Connect(serverSocket);
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        System.out.println("Client connect --> " + ++countClient);

        try {
            while (true) {
                switch (connect.readLine()) {
                    case "add":
                        dataBaseHandler.addBookDB(readClientBook());
                        break;
                    case "edit":
                        String old = connect.readLine();
                        ArrayList<Book> list1 = dataBaseHandler.getBookDB();
                        Integer flag1 = 0;
                        for (int i = 0; i < list1.size(); i++) {
                            if (old.equals(list1.get(i).getNameBook())) {
                                flag1 = 1;
                                break;
                            }
                            flag1 = 2;
                        }
                        if (flag1.equals(2) || flag1.equals(0)) {
                            connect.writeLine("false");
                        } else {
                            dataBaseHandler.editBookDB(old, readClientBook());
                            connect.writeLine("true");
                        }
                        break;
                    case "delete": {
                        String whatDelete = connect.readLine();
                        ArrayList<Book> list2 = dataBaseHandler.getBookDB();
                        Integer flag2 = 0;
                        for (int i = 0; i < list2.size(); i++) {
                            if (whatDelete.equals(list2.get(i).getNameBook())) {
                                flag2 = 1;
                                break;
                            }
                            flag2 = 2;
                        }
                        if (flag2.equals(2) || flag2.equals(0)) {
                            connect.writeLine("false");
                        } else {
                            dataBaseHandler.deleteDB(whatDelete);
                            connect.writeLine("true");
                        }
                        break;
                    }
                    case "view": {
                        connect.writeObjList(dataBaseHandler.getBookDB());
                        break;
                    }
                        case "search":
                        String oldName = connect.readLine();
                        ArrayList<Book> list = dataBaseHandler.getBookDB();
                        Integer flag = 0;
                        for (int i = 0; i < list.size(); i++) {
                            if (oldName.equals(list.get(i).getNameBook())) {
                                connect.writeLine(list.get(i).getAuthorBook());
                                connect.writeLine(list.get(i).getNameBook());
                                connect.writeLine(list.get(i).getLanguage());
                                connect.writeLine(String.valueOf(list.get(i).getYearBook()));
                                connect.writeLine(String.valueOf(list.get(i).getCountPage()));
                                flag = 1;
                                break;
                            }
                            flag = 2;
                        }
                        if (flag.equals(2) || flag.equals(0)) {
                            connect.writeLine("");
                            connect.writeLine("");
                            connect.writeLine("");
                            connect.writeLine("0");
                            connect.writeLine("0");
                        }
                        break;

                    default:
                        System.out.println("error problem ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }
    }

    private Book readClientBook() throws IOException {
        return new Book(connect.readLine(), connect.readLine(), connect.readLine(), Integer.parseInt(connect.readLine()), Integer.parseInt(connect.readLine()));
    }


}