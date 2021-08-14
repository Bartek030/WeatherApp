package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pl.bartlomiej_swies.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MessageWindowController extends BaseController implements Initializable {

    private final String message;

    @FXML
    private Label messageLabel;

    @FXML
    void messageButtonAction() {
        Stage stage = (Stage) messageLabel.getScene().getWindow();
        stage.close();
    }

    public MessageWindowController(ViewFactory viewFactory, String fxmlName, String message) {
        super(viewFactory, fxmlName);
        this.message = message;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageLabel.setText(message);
    }
}
