package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class DescriptionController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Pane in_pen;
   @FXML
    private Button btn_reviews;

    String patchDescp ="/fxml/description.fxml";
    String patchContact ="/fxml/contacts.fxml";
    String patchReviews ="/fxml/reviews.fxml";
    String patchMain ="/fxml/main.fxml";

    @FXML
    public void swipeMain() {
        SwipeScene swp = new SwipeScene(patchMain,parent);
        System.out.println("swipePage");
    }

    @FXML
    public void swipeDescription(ActionEvent event) throws IOException { ;
        System.out.println("decsp");
    }

    @FXML
    public void swipeContact() {
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
            ResultSet rs = new DBConnect().getListDB("SELECT * FROM message ORDER BY ID DESC LIMIT 3");
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
