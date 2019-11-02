package lesson6;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            while (true) {
                s = bufferedReader.readLine();
                out.writeUTF(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String strFromServer = null;
                    try {
                        strFromServer = in.readUTF();
                        System.out.println("Сообщение от сервера: " + strFromServer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (strFromServer.equalsIgnoreCase("/end")) {
                        break;
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new Client();
    }
}