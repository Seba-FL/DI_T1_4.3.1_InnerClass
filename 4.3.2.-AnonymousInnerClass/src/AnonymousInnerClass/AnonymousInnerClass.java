/*
 * Autor : Sebastián Fernández López
 * Descripción : Anonymous Inner Class
 */
package AnonymousInnerClass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.VBox;

public class AnonymousInnerClass extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {
        HBox hbox = new HBox();
        Button btn_New = new Button();
        Button btn_Open = new Button();
        Button btn_Save = new Button();
        Button btn_Print = new Button();
        btn_New.setText("New");
        btn_Open.setText("Open");
        btn_Save.setText("Save");
        btn_Print.setText("Print");
       
        hbox.setMargin(btn_New, new Insets(0,10,0,0));
        hbox.setMargin(btn_Open, new Insets(0,10,0,0));
        hbox.setMargin(btn_Save, new Insets(0,10,0,0));
        hbox.setMargin(btn_Print, new Insets(0,10,0,0));
        hbox.getChildren().addAll(btn_New, btn_Open, btn_Save, btn_Print);
        hbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(hbox, 250, 50);
        
        // Imprime "Nuevo Proceso" al pulsar el botón 1
        btn_New.setOnAction(
        new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Nuevo Proceso");
            }
        });
        
        // Imprime "Abrir Proceso" al pulsar el botón 1
        btn_Open.setOnAction(
        new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Abrir Proceso");
            }
        });
        
        // Imprime "Guardar Proceso" al pulsar el botón 1
        btn_Save.setOnAction(
        new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Guardar Proceso");
            }
        });
        
        
        // Imprime "Imprimir Proceso" al pulsar el botón 1
        btn_Print.setOnAction(
        new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Imprimir Proceso");
            }
        });

        primaryStage.setTitle("Anonymous Inner Class");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
    
}
