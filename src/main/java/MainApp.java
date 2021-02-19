import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;


public class MainApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws Exception {

        String fxmlFile = "/fxml/main.fxml";

        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) loader.load(getClass().getResource(fxmlFile));

        stage.setTitle("winner-insider");
        Scene sc = new Scene(root,1800,900);

        stage.getIcons().add(new Image("img/logo.png"));
        stage.setResizable(false);
        stage.setScene(sc);

        stage.show();

    }
}
