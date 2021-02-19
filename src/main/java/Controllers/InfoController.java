package Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class InfoController {
    String mainPage ="/fxml/main.fxml";
    @FXML
    private AnchorPane info;

    public void mainPage(javafx.event.ActionEvent actionEvent) {
        new SwipeScene(mainPage,info);
    }
}
