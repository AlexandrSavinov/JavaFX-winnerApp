package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SwipeScene {

    public SwipeScene(String patch, AnchorPane rootPane){
        AnchorPane pane = null;
        try {
            pane = FXMLLoader.load(getClass().getResource(patch));
        } catch (IOException e) {
            e.printStackTrace();
        }
        rootPane.getChildren().setAll(pane);
    }

}
