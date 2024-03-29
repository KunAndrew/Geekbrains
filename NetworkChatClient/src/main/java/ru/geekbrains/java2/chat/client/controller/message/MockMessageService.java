package src.main.java.ru.geekbrains.java2.chat.client.controller.message;

import javafx.scene.control.TextArea;

public class MockMessageService implements ru.geekbrains.java2.chat.client.controller.message.IMessageService {

    private TextArea chatTextArea;

    public MockMessageService(TextArea chatTextArea) {
        this.chatTextArea = chatTextArea;
    }

    @Override
    public void sendMessage(String message) {
        System.out.printf("Message %s has been sent%n", message);
        chatTextArea.appendText(message + System.lineSeparator());
//        processRetrievedMessage(message);
    }

    @Override
    public void processRetrievedMessage(String message) {
        throw new UnsupportedOperationException();
//        chatTextArea.appendText(message + System.lineSeparator());
    }
}
