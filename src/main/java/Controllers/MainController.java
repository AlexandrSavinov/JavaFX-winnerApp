package Controllers;


import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button close;
    @FXML
    private WebView WebV;

    String patchDescp ="/fxml/description.fxml";
    String patchContact ="/fxml/contacts.fxml";
    String patchMain ="/fxml/main.fxml";

    @FXML
    public void swipeScen() {
            System.out.println("swipePage");
    }

    @FXML
    public void swipeDescription(ActionEvent event) throws IOException {
        new SwipeScene(patchDescp,rootPane);
    }

    @FXML
    public void swipeContact(ActionEvent event) throws IOException {
        new SwipeScene(patchContact,rootPane);
    }

    FadeTransition fade = new FadeTransition(Duration.millis(1500));


    @FXML
    public void fadeIn(){
        if (!WebV.isVisible()) {
            WebV.setVisible(true);
            fade.playFromStart();
            close.setVisible(true);
        }
    }

    @FXML
    public void hideIn(){
        if (WebV.isVisible()) {
            WebV.setVisible(false);
            close.setVisible(false);

        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        close.setCursor(Cursor.HAND);

        WebV.setVisible(false);
        close.setVisible(false);

        WebEngine web = WebV.getEngine();
        String urlWeb="https://winner-insider.ru/#rec238149833";
        web.load(urlWeb);
    }


}
