/*
Autor : Sebastián Fernández López
Descripción : FadeTransition
*/

package pkg4.pkg3.pkg7.fadetransitions;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class FadeTransitions extends Application {
    
    Ellipse ellipse = new Ellipse();
    double ellipseCenterX = 50.0f;
    double ellipseCenterY = 40.0f;
    double ellipseRadiusX = 50.0f;
    double ellipseRadiusY = 50.0f;
    int durationMillis = 5000;

    @Override
    public void start(Stage primaryStage) 
    {
        
        // Asignamos las medidas de nuestra ellipse
        ellipse.setCenterX(ellipseCenterX);
        ellipse.setCenterY(ellipseCenterY);
        ellipse.setRadiusX(ellipseRadiusX);
        ellipse.setRadiusY(ellipseCenterY);
        ellipse.setFill(Color.RED);
        
        // Creamos un gridPane donde pondremos incluiremos a nuestra ellipse y le daremos un a posisción
        GridPane gridPane = new GridPane();
        gridPane.getChildren().addAll(ellipse);
        gridPane.setAlignment(Pos.CENTER);
        
        FadeTransition ft = new FadeTransition(Duration.millis(durationMillis), ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        
        ft.play();
        
        gridPane.setOnMousePressed(value
                -> {
            ft.pause();
        });
        gridPane.setOnMouseReleased(value
                -> {
            ft.play();
        });
        
        
        Scene scene = new Scene(gridPane, 300, 250);
        primaryStage.setTitle("Fade Transitions");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
        
}
