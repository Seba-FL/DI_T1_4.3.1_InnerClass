/*
 * Autor : Sebastián Fernández López
 * Descripción : Timelines
 */
package timelines;

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Timelines extends Application {

    /* Incializamos variables */
    // Creacion de la pelota
    Circle ball = new Circle(15);

    // Velocidad de nuestra pelota 
    double velocidadBall_X = 2;
    double velocidadBall_Y = 2;
    
    // Variables de para dar la posición a nuestro label
    int lbText_X = 10;
    int lbText_Y = 10;
   
    // Creamos nuestro panel
    Pane gridPane = new Pane();
    Scene scene = new Scene(gridPane, 500, 350);
    
    @Override
    public void start(Stage primaryStage) {

        Label lb_Texto = new Label();
        lb_Texto.setTranslateX(lbText_X);
        lb_Texto.setTranslateY(lbText_Y);
        gridPane.getChildren().add(lb_Texto);

        // Creacion de la pelota
        ball.setStroke(Color.BLACK);
        gridPane.getChildren().add(ball);

        // Creamos el evento que mueve nuestra pelota
        EventHandler<ActionEvent> evento = e -> {
            // Mostramos a los FPS que va nuestra pelota
            PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
            lb_Texto.setText("FPS (Timelines) = " + perfTracker.getInstantFPS());
            if (ball.getTranslateX() < 0  || ball.getTranslateX() > 500) {
                velocidadBall_X = velocidadBall_X * -1;
            }
            ball.setTranslateX(ball.getTranslateX() + velocidadBall_X);
            if (ball.getTranslateY() < 0 || ball.getTranslateY() > 350) {
                velocidadBall_Y = velocidadBall_Y * -1;
            }
            ball.setTranslateY(ball.getTranslateY() + velocidadBall_Y);
        };

        Timeline animacion = new Timeline(new KeyFrame(Duration.millis(7), evento));
        animacion.setCycleCount(Timeline.INDEFINITE);
        animacion.play();

        primaryStage.setTitle("TimeLines");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
