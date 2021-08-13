package pl.bartlomiej_swies.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pl.bartlomiej_swies.view.ViewFactory;

public class MessageWindowController extends BaseController {

    @FXML
    private Label messageLabel;

    public MessageWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void messageButtonAction() {

    }
}
