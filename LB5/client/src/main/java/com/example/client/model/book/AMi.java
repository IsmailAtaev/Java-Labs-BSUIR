package com.example.client.model.book;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AMi {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 8189);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Book book = new Book("qq", "ww", "ee", 99, 77);

        System.out.println("connect client ");

        oos.writeObject(book);
        Book book1 = (Book) ois.readObject();
        System.out.println(book1);
        oos.close();
        socket.close();
        outputStream.close();
    }
}
