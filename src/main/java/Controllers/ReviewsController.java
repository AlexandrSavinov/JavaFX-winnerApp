package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.util.ResourceBundle;


public class ReviewsController implements Initializable {

    IsLoginUser iu = new IsLoginUser();
    UserStore user = new UserStore();

    String patchMain ="/fxml/main.fxml";

    @FXML
    private AnchorPane info;

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
    @FXML
    private Text textEror;


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
                user.setParam(username,password,rs.getString(3));
                block.setVisible(false);
                iu.setToggleMake(false);
                System.out.println("nice login!");
            }else{
                textEror.setVisible(true);
                System.out.println("Uncorrected login or password!");
            }

        }

    }
    DBConnect on = new DBConnect();


    @FXML
    public void FadeIn(ActionEvent actionEvent) throws SQLException {
        if (!block.isVisible() && iu.isToggleMake()) {
            block.setVisible(true);
            textEror.setVisible(false);
        }


        if(!iu.isToggleMake()){

            if(!textArea.getText().isEmpty()) {
                System.out.println("false");

                String name = user.getName();
                String filename = user.getFilename();
                on.insertValuesFromDB(value, textArea.getText(), filename, name);
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
