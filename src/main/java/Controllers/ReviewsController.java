package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ReviewsController implements Initializable {

    IsLoginUser iu = new IsLoginUser();

    Set<String> set;

    String patchMain ="/fxml/main.fxml";

    @FXML
    private AnchorPane info;

    @FXML
    private Button button_rev;
    @FXML
    private Button login;

    @FXML
    private TextArea textArea;

    @FXML
    private Pane block;

    @FXML
    private TextField textLogin;

    @FXML
    private TextField textPassword;

    @FXML
    private Slider srollPanel;

    @FXML
    private Text Make;

    String value = "5";

    @FXML
    public void getMark(MouseEvent mouseEvent) {
        value =String.valueOf(((int) srollPanel.getValue()));
        Make.setText(value);
    }

    @FXML
    public void swipeMain() {
        SwipeScene swp = new SwipeScene(patchMain,info);
        System.out.println("swipePage");
    }


    @FXML
    public void getTextLogin(ActionEvent actionEvent) throws SQLException {
        String username = textLogin.getText();
        String password = textPassword.getText();


        ResultSet rs = new DBConnect().getListDB("Select username,password,filename From usr");
        while(rs.next()){

            if(rs.getString(1).equals(username) && rs.getString(2).equals(password)){
                set= new UserStore().addUser(username,password,rs.getString(3));

                block.setVisible(false);
                iu.setToggleMake(false);
                new DBConnect().closeConnectionFromDB();
            }

        }

    }
    DBConnect on = new DBConnect();


    @FXML
    public void FadeIn(ActionEvent actionEvent) throws SQLException {
        if (!block.isVisible() && iu.isToggleMake()) {
            block.setVisible(true);
        }


        if(!iu.isToggleMake()){

            if(!textArea.getText().isEmpty()) {
                System.out.println("false");
                Iterator it = set.iterator();
                String name = (String) it.next();
                String pas = (String) it.next();


                on.insertValuesFromDB(value, textArea.getText(), (String) it.next(), pas);
                on.closeConnectionFromDB();
            }else{
                System.out.println("TextArea is EMPTY!!!");
            }
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        block.setVisible(false);
    }



}
