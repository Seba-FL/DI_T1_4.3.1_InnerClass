/*
 * Autor : Sebastián Fernández López 
 * Descripción : Using GridPane To Layout A Login Dialog
 */
package UsingGridPaneToLayoutALoginDialog;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class UsingGridPaneToLayoutALoginDialog extends Application {
    
    // Variables
    int paddingInsets = 5;
    int hGap = 5;
    int vGap = 5;
    
    @Override
    public void start(Stage primaryStage) 
    {
        primaryStage.setTitle("Diseños de Controles");
        Group group = new Group();
        Scene scene = new Scene(group, 370, 120, Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(paddingInsets));
        gridPane.setHgap(hGap);
        gridPane.setVgap(vGap);

        Label lb_Name = new Label("Nombre");
        TextField tf_Name = new TextField();
        Label lb_Apellidos = new Label("Apellidos");
        TextField tf_Apellidos = new TextField();
        Button btn_Save = new Button("Guardar");
        
        // First name label
        GridPane.setHalignment(lb_Name, HPos.RIGHT);
        gridPane.add(lb_Name, 0, 0);
        
        
        // Last name label
        GridPane.setHalignment(lb_Apellidos, HPos.RIGHT);
        gridPane.add(lb_Apellidos, 0, 1);
        
        // First name field
        GridPane.setHalignment(tf_Name, HPos.LEFT);       
        gridPane.add(tf_Name, 1, 0);
        
        // Last name field
        GridPane.setHalignment(tf_Apellidos, HPos.LEFT);
        gridPane.add(tf_Apellidos, 1, 1);

        // Save button
        GridPane.setHalignment(btn_Save, HPos.RIGHT);
        gridPane.add(btn_Save, 1, 2);
        
        group.getChildren().add(gridPane);        
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
}
