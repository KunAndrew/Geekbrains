package src.main.java.ru.geekbrains.java2.chat.client.controller.message;

public class ServerConnectionException extends RuntimeException {

    public ServerConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
