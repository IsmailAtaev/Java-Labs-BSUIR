package com.example.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8189);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter client word ");
        String str1 = scanner.nextLine();

        pr.println(str1);
        pr.flush();


        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server " + str);
    }
}
