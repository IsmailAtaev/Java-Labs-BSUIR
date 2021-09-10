package com.ataew.lab1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lab1Task2 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        String strBlock1 =  new String();
        String strBlock2 =  new String();
        ArrayList<String> blockArr3 = new ArrayList<>();
        ArrayList<String> blockArr4 = new ArrayList<>();

        String message =  new String();
        //block 1
        try(FileReader reader = new FileReader("file1.txt")){
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (bufferedReader.ready()) {
                message = bufferedReader.readLine();
            }
            bufferedReader.close();
            String[] array = message.split(" ");
            for (int i = 0; i< array.length; i++){
                arr.add(array[i]);
            }
            Collections.sort(arr);
           // System.out.println(arr);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // block 2
        try{
            File file =  new File("file2.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);

            for(int i =0; i < arr.size(); i++) {
                writer.write(arr.get(i) + " ");
            }
            writer.flush();
            writer.close();

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        //block 3
        try(FileReader reader3 = new FileReader("file1.txt")){
            BufferedReader bufferedReader = new BufferedReader(reader3);
            while (bufferedReader.ready()) {
                strBlock1 = bufferedReader.readLine();
            }
            bufferedReader.close();
            String[] array = strBlock1.split(" ");

            for (int i = 0; i< array.length ; i++){
                blockArr3.add(array[i]);
            }
            //Collections.sort(blockArr3);
            //System.out.println(" i am file 1\t\t" + blockArr3);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(FileReader reader4 = new FileReader("file2.txt")){
            BufferedReader bufferedReader = new BufferedReader(reader4);
            while (bufferedReader.ready()) {
                strBlock1 = bufferedReader.readLine();
            }
            bufferedReader.close();
            String[] array = strBlock1.split(" ");
            for (int i = 0; i< array.length; i++){
                blockArr4.add(array[i]);
            }
           // Collections.sort(blockArr4);
            //System.out.println(" i am file 2\t\t" + blockArr4);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try{
            File file1 =  new File("file3.txt");
            if(!file1.exists()){
                file1.createNewFile();
            }
            FileWriter writer = new FileWriter(file1);

            System.out.println(blockArr3.size());
            for(int i =0; i < blockArr3.size() && i < blockArr4.size(); i++) {
                writer.write(blockArr3.get(i) + "  " + blockArr4.get(i) + " (слово file1 + слово file2)\t");
            }
            writer.flush();
            writer.close();

        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}

/*<modules>
        <module>lab2</module>
        <module>untitled</module>
    </modules>
    */