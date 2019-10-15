package lesson4.javafx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import javax.swing.*;

public class FXMLDocumentController {

    @FXML
    private TextField textField;
    @FXML
    private TextFlow textFlow;

    private ObservableList list;
    private JList<String> listmodel;


    @FXML
    private void handleButtonAction(ActionEvent event) {
        list = textFlow.getChildren();
        Text text1 = new Text(textField.getText());
        Text text2 = new Text("\n");
        list.addAll(text1, text2);
        textField.clear();
    }


    public void handleTextAction(KeyEvent keyevent) {
        if (keyevent.getCode().equals(KeyCode.ENTER)) {
            ObservableList list = textFlow.getChildren();
            String text = textField.getText();
            Text text1 = new Text(text);
            Text text2 = new Text("\n");
            list.addAll(text1, text2);
            textField.clear();
        }
    }
}