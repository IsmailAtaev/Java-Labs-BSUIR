package com.serverTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    static int countClients = 0;

    public static void main(String[] args) throws IOException {

        ServerSocket sock = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            sock = new ServerSocket(1024);
            while (true) {
                Socket client = sock.accept();
                countClients++;
                System.out.println("===============================================");
                System.out.println("Client " + countClients + " connected ");
                is = client.getInputStream();
                os = client.getOutputStream();
                boolean flag = true;


                while (flag) {

                    byte[] bytes = new byte[1024];
                    is.read(bytes);
                    String str = new String(bytes, "UTF-8");
                    String[] numbers = str.split(" ");
                    String m = "";
                    bytes = new byte[1024];
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.println("клиент прислал число " + numbers[i]);
                        if (Integer.parseInt(numbers[i]) % 3 == 0) {
                            m += numbers[i] + " "; // записываютмя числа,которые деляется на 3
                        }
                    }

                    bytes = m.getBytes();
                    os.write(bytes);

                }
            }
        } catch (Exception e) {

        } finally {
            is.close();//закрытие входного потока
            os.close();//закрытие входного потока
            sock.close();//
        }
        System.out.println("Client " + countClients + " disconnected");
    }
}
