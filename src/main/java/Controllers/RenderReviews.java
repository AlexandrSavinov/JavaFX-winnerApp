package Controllers;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


import java.sql.ResultSet;
import java.sql.SQLException;

public class RenderReviews {
    public static void RenderPaneReviews(Pane pane,ResultSet rs, Integer scope) throws SQLException {

        Pane vBox = new Pane();
        vBox.setStyle("-fx-background-color: white");
        vBox.setLayoutY(230);
        vBox.setPrefHeight(381);
        vBox.setPrefWidth(384);
        vBox.setLayoutX(50+scope);

        Text name = new Text();
        name.setStyle("-fx-font-size: 22px;");
        name.setTextAlignment(TextAlignment.CENTER);
        name.setText(rs.getString(6));
        name.setLayoutX(122);
        name.setLayoutY(120);
        name.setStrokeType(StrokeType.valueOf("OUTSIDE"));
        name.setWrappingWidth(136);

        Text u = new Text("Имя пользователя");
        u.setStyle("-fx-font-size: 18px;-fx-font-family: Impact;");
        u.setTextAlignment(TextAlignment.CENTER);
        u.setLayoutX(122);
        u.setLayoutY(70);
        u.setStrokeType(StrokeType.valueOf("OUTSIDE"));
        u.setWrappingWidth(136);

        //layoutY="177.0" prefHeight="204.0" prefWidth="384.0" style="-fx-background-color: gray;"
        Pane in_txt_pane = new Pane();
        in_txt_pane.setLayoutY(177);
        in_txt_pane.setPrefHeight(204);
        in_txt_pane.setPrefWidth(384);

        Label text = new Label();
        text.setText(rs.getString(3));
        text.setWrapText(true);
        text.setTranslateX(17);
        text.setMaxWidth(335);
        text.setTextAlignment(TextAlignment.JUSTIFY);

        ScrollPane sp = new ScrollPane(text);
        sp.setPrefViewportHeight(200);
        sp.setPrefViewportWidth(367);

        in_txt_pane.getChildren().addAll(sp);

        //fx:id="tag" layoutX="127.0" layoutY="158.0" strokeType="OUTSIDE"
        // strokeWidth="0.0" styleClass="tag" text="tag" textAlignment="CENTER" wrappingWidth="125.60345458984375">
        Text tag = new Text();
        tag.setStyle("-fx-font-size: 20px;");
        tag.setText(rs.getString(2)+" /5");
        tag.setLayoutX(163);
        tag.setLayoutY(158);
        tag.setTextAlignment(TextAlignment.CENTER);
        tag.setWrappingWidth(125);

        Text t = new Text("Оценка:");
        t.setStyle("-fx-font-size: 18px;-fx-font-family: Impact;");
        t.setLayoutX(110);
        t.setLayoutY(158);
        t.setTextAlignment(TextAlignment.CENTER);
        t.setWrappingWidth(125);

//                layoutX="150.0" layoutY="20.0" prefHeight="78.0" prefWidth="79.0" styleClass="logotip" />
        Label logo = new Label();
//                logo.setStyle("-fx-background-image: url(logo.png);" +
//                        "-fx-background-position: center");
        logo.setLayoutY(20);
        logo.setLayoutX(150);
        logo.setPrefWidth(79);

        vBox.getChildren().addAll(name,u,in_txt_pane,tag,t,logo);
        pane.getChildren().addAll(vBox);

        System.out.println(rs.getString(5));
        System.out.println(rs.getString(6));
        System.out.println(rs.getString(2));
        System.out.println(rs.getString(3));
        System.out.println("--+++--");
    }
}
