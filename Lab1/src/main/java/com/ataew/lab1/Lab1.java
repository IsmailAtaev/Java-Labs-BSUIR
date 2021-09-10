package com.ataew.lab1;

import java.util.ArrayList;
import java.util.Collections;

public class Lab1 {
    public static void main(String[] args) {
        String message = "Один раз я сидел, сидел и ни с того ни " +
                "с сего вдруг такое надумал, что даже сам удивился. " +
                "Я надумал, что вот как хорошо было бы, если бы все " +
                " вокруг на свете было устроено наоборот. Ну вот, " +
                "например, чтобы дети были во всех делах главные" +
                " и взрослые должны были бы их во всем, во всем слушаться. " +
                "В общем, чтобы взрослые были как дети, а дети как взрослые." +
                " Вот это было бы замечательно, очень было бы интересно.";

        String[] array = message.split(" ");
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i< array.length; i++){
            arr.add(array[i]);
        }
        //Arrays.sort(array);
        Collections.sort(arr);
        System.out.println(arr);


    }
}




class Dawlet {
    public static void main(String[] args) {
        String strArray[] = {"а", "б", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        String ignoreFlags[] = {"а", "е", "ё", "и", "о", "у", "ы", "э", "ю", "я"};
        int count = strArray.length - ignoreFlags.length;
        ArrayList<String> addLetter = new ArrayList<>();
        int a = 0;
        for (int i = 0; i < strArray.length; i++) {

            int elem = 0;

            int temp = a + (int) (Math.random() * count);

            for (int j = 0; j < ignoreFlags.length; j++) { //10
                if (strArray[i].equals(ignoreFlags[j])) {//1 1 1 2
                    continue;
                }else{
                    if (elem == 0) {
                        addLetter.add(strArray[i]);
                        elem++;
                    }
                }

            }
        }
        System.out.println(addLetter);

      /*  for (int j = 0; j < ignoreFlags.length; j++) {
            int temp = a + (int) (Math.random() * count);
            if (Dawlet.compare(ignoreFlags, strArray[temp]) == 0) {
            } else {
                addLetter.add(strArray[temp]);
                break;
            }
        }
        System.out.println(addLetter);
*/
    }


    public static int compare(String[] arr, String ss) {
        for (int i = 0; i < arr.length; i++) {
            if (ss.equals(arr[i])) {
                return 1;
            } else if (ss.equals(arr[i])) {
                return 0;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
