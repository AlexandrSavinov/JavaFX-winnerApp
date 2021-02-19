package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ContactController implements Initializable {

    @FXML
    private AnchorPane anchorContacts;
    @FXML
    private Label labelPolit;

    String patchDescp ="/fxml/description.fxml";
    String patchInfo ="/fxml/info.fxml";
    String patchMain ="/fxml/main.fxml";

    @FXML
    public void swipeMain(ActionEvent event) {
        SwipeScene swipeScene = new SwipeScene(patchMain,anchorContacts);
        System.out.println("main");
    }

    @FXML
    public void swipeDescription(ActionEvent event) throws IOException {
        SwipeScene swp = new SwipeScene(patchDescp,anchorContacts);
        System.out.println("decsp");
    }

    @FXML
    public void swipeContact() {
//        SwipeScene swp = new SwipeScene(patchContact,anchorContacts);
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
