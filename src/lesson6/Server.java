package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    String str = null;
                    try {
                        str = in.readUTF();
                        System.out.println("Клиент: " + str);
                        if (str.equals("/end")) {
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while (true) {
                s = bufferedReader.readLine();
                out.writeUTF(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
