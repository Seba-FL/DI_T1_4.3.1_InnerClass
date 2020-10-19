/*
 * Autor: Sebastian Fernández López
 * Descripcion : Login
 */
package pkg4.pkg4.pkg5.login;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Login extends Application {

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Login");
        Group group = new Group();
        Scene scene = new Scene(group, 400, 300, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.show();

        Stage myDialog = new MyDialog(primaryStage);
        myDialog.sizeToScene();
        myDialog.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

class MyDialog extends Stage {

    // Variables
    int paddingInsets = 5;
    int hGap = 5;
    int vGap = 5;
    
    public MyDialog(Stage owner) {
        super();
        initOwner(owner);
        setTitle("Login");
        Group group = new Group();
        Scene scene = new Scene(group, 250, 150, Color.WHITE);
        setScene(scene);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(paddingInsets));
        gridPane.setHgap(hGap);
        gridPane.setVgap(vGap);

        Label lb_User = new Label("Usuario: ");
        gridPane.add(lb_User, 0, 1);

        Label lb_Pswd = new Label("Contraseña: ");
        gridPane.add(lb_Pswd, 0, 2);
        final TextField tf_User = new TextField("Admin");
        gridPane.add(tf_User, 1, 1);

        final PasswordField pswdFd = new PasswordField();
        pswdFd.setText("password");
        gridPane.add(pswdFd, 1, 2);

        Button btn_Cambiar = new Button("Change");
        btn_Cambiar.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });
        gridPane.add(btn_Cambiar, 1, 3);
        GridPane.setHalignment(btn_Cambiar, HPos.RIGHT);
        group.getChildren().add(gridPane);
    }
}
