package Controllers;

import Controllers.inerface.SwipeMethodToScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DescriptionController implements Initializable, SwipeMethodToScene {

    @FXML
    private AnchorPane parent;
    @FXML
    private Pane in_pen;
    @FXML
    private Button btn_reviews;

    @Override
    @FXML
    public void swipeMain(ActionEvent event) throws IOException {
        SwipeScene swp = new SwipeScene(patchMain,parent);
        System.out.println("swipePage");
    }

    @Override
    @FXML
    public void swipeDescription(ActionEvent event) throws IOException { ;
        System.out.println("decsp");
    }

    @Override
    @FXML
    public void swipeContact(ActionEvent event) throws IOException {
        SwipeScene swp = new SwipeScene(patchContact,parent);
        System.out.println("contact");
    }

    @FXML
    public void swipeReviews(){
        SwipeScene swp = new SwipeScene(patchReviews,parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_reviews.setCursor(Cursor.HAND);
        int scope=0;

        try {
            ResultSet rs = DBConnect.getDBConnet().getListDB("SELECT * FROM message ORDER BY ID DESC LIMIT 3");
            while (rs.next()) {
                RenderReviews.RenderPaneReviews(in_pen,rs,scope);
                scope+=500;
            }
            System.out.println("end");

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
