/*
Autor : Sebastián Fernández López
Descripción : InnerClass
*/
package InnerClass;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;

public class InnerClass extends Application {

    Circle circle = new Circle();
    
    // Variables
    int circuloCenterX = 100;
    int circuloCenterY = 100;
    int circuloRadius = 50;
    
    
    @Override
    public void start(Stage primaryStage) {
        /* Creamos nuestro círculo */

        circle.setCenterX(circuloCenterX);
        circle.setCenterY(circuloCenterY);
        circle.setRadius(circuloRadius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        // Creamos los botones que usaremos para poder mover nuestro círculo
        Button btnEnlarge = new Button("Enlarge");
        Button btnShrink = new Button("Shrink");

        // Añadimos a los botones la clase con la cual podemos mover el círculo
        btnEnlarge.setOnAction(new EnlargeHandler());
        btnShrink.setOnAction(new ShrinkHandler());

        // Creamos un HBox para poder piner nuestro botones en un una fila horizontal
        HBox hbox = new HBox(25);
        hbox.getChildren().addAll(btnEnlarge,btnShrink);
        hbox.setAlignment(Pos.CENTER);

        // Creamos el BorderPane y le añadimos el HBox para poder mostrarlo en pantalla
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circle);
        borderPane.setBottom(hbox);
        BorderPane.setAlignment(hbox, Pos.CENTER);
        Scene scene = new Scene(borderPane, 220, 170);
        primaryStage.setScene(scene);
        primaryStage.setTitle("InnerClass");
        primaryStage.show();
    }

    class EnlargeHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            circle.setRadius(circle.getRadius() + 2);
        }

    }

    class ShrinkHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            circle.setRadius(circle.getRadius() - 2);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}