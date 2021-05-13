package Controllers.inerface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;


public interface SwipeMethodToScene {
    String patchDescp = "/fxml/description.fxml";
    String patchInfo = "/fxml/info.fxml";
    String patchMain = "/fxml/main.fxml";
    String patchReviews ="/fxml/reviews.fxml";
    String patchContact ="/fxml/contacts.fxml";

    void swipeMain(ActionEvent event) throws IOException;

    void swipeDescription(ActionEvent event) throws IOException;

    void swipeContact(ActionEvent event) throws IOException;
}
