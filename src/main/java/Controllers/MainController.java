package Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.util.Duration;


public class MainController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button close;

    @FXML
    private Button opacity_bl;

    @FXML
    private WebView WebV;

    @FXML
    private Pane display_block;


    String patchDescp ="/fxml/description.fxml";
    String patchContact ="/fxml/contacts.fxml";
    String patchMain ="/fxml/main.fxml";

    @FXML
    public void swipeScen() {
            System.out.println("swipePage");
    }

    @FXML
    public void swipeDescription(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource(patchDescp));
        rootPane.getChildren().setAll(pane);
        System.out.println("decsp");
    }

    @FXML
    public void swipeContact(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource(patchContact));
        rootPane.getChildren().setAll(pane);

        System.out.println("contact");
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
