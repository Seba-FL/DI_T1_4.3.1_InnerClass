/*
 * Autor : Sebastián Fernández López 
 * Descripción : SetDialogModality
 */
package SetDialogModality;

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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SetDialogModality extends Application {

    // Inicializamos variables
    int paddingInsets = 5;
    int hGap = 5;
    int vGap = 5;

    @Override
    public void start(final Stage primaryStage) {

        primaryStage.setTitle("Dialog");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.WHITE);

        primaryStage.setScene(scene);
        primaryStage.show();

        Stage myDialog = new MyDialog(primaryStage);
        myDialog.sizeToScene();
        myDialog.show();

    }

    class MyDialog extends Stage {

        public MyDialog(Stage owner) {
            super();
            initOwner(owner);
            setTitle("Cuadro De Diálogo");
            initModality(Modality.APPLICATION_MODAL);
            Group group = new Group();
            Scene scene = new Scene(group, 250, 150, Color.WHITE);
            setScene(scene);

            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(paddingInsets));
            gridPane.setHgap(hGap);
            gridPane.setVgap(vGap);

            Label lb_User = new Label("Usuario ");
            gridPane.add(lb_User, 0, 1);

            Label lb_Pswd = new Label("Contraseña ");
            gridPane.add(lb_Pswd, 0, 2);
            final TextField tf_Admin = new TextField("Admin");
            gridPane.add(tf_Admin, 1, 1);

            final PasswordField pswd_Fd = new PasswordField();
            pswd_Fd.setText("password");
            gridPane.add(pswd_Fd, 1, 2);

            Button btn_Cambiar = new Button("Cambiar");
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

    public static void main(String[] args) {
        launch(args);
    }
}
