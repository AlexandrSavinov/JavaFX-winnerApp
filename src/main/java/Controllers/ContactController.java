package Controllers;

import Controllers.inerface.SwipeMethodToScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactController implements Initializable, SwipeMethodToScene {

    @FXML
    private AnchorPane anchorContacts;
    @FXML
    private Label labelPolit;

    @Override
    @FXML
    public void swipeMain(ActionEvent event) throws IOException {
        SwipeScene swipeScene = new SwipeScene(patchMain,anchorContacts);
        System.out.println("main");
    }

    @Override
    @FXML
    public void swipeDescription(ActionEvent event) throws IOException {
        SwipeScene swp = new SwipeScene(patchDescp,anchorContacts);
        System.out.println("decsp");
    }

    @Override
    @FXML
    public void swipeContact(ActionEvent event) throws IOException {
        System.out.println("contact");
    }

    @FXML
    public void openFile(ActionEvent actionEvent){
        new SwipeScene(patchInfo,anchorContacts);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
