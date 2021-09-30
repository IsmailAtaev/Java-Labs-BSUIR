import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerMain {
    public static int clientConnect = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter port --> ");
        int port = scanner.nextInt();
        try {
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket s = ss.accept();
                clientConnect++;
                System.out.println("Client number " + clientConnect);
                InputStreamReader in = new InputStreamReader(s.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                System.out.println("client " + bf.readLine() + "\tClient connect --> " + clientConnect);
                PrintWriter pr = new PrintWriter(s.getOutputStream());
                pr.println(ServerMain.getReverseMessage(bf.readLine()));
                pr.flush();
                s.close();
                bf.close();
                in.close();
            }
        } catch (IOException ioException) {
            ioException.getStackTrace();
        }
    }

    public static synchronized String getReverseMessage(String message) {
        String[] arrStr = message.split(" ");

        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = arrStr.length; i > 0; i--) {
            stringArrayList.add(arrStr[i - 1]);
        }

        String getStr = new String();
        for (int j = 0; j < stringArrayList.size(); j++) {
            getStr += stringArrayList.get(j) + " ";
        }

        System.out.println("getStr " + getStr);
        System.out.println("word " + stringArrayList);
        return getStr;
    }
}