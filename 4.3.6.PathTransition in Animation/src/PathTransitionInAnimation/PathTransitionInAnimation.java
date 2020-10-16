/*
 * Autor : Sebastián Fernández López
 * Descripción : PathTransition In Animation
 */
package PathTransitionInAnimation;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author UsuarioDAM
 */
public class PathTransitionInAnimation extends Application {

    // Inicializamos variables
    Circle circle = new Circle();
    // Creamos las variables de nuestro círculo
    int radius = 50;
    int centerX = 100;
    int centerY = 100;
    // Creamos las variables para que nuestro circulo se muestre en el centro de la pantalla (Posicion Inicial)
    int circleCenterX = 400 / 2;
    int circleCenterY = 350 / 2;

    Rectangle rectangulo = new Rectangle();
    // Creamos las variables de nuestro rectángulo
    int rectHeight = 60;
    int rectWidth = 30;
    // Creamos las variables para que nuestro rectangulo se muestre en el centro de la pantalla (Posicion Inicial)
    int initialRectX = (400 / 2) - (rectWidth / 2) - radius;
    int initialRectY = (350 / 2) - (rectHeight / 2);
        
    @Override
    public void start(Stage primaryStage) 
    {
        // Creamo el rectángulo dándo formato a nuestro rectángulo
        rectangulo.setHeight(rectHeight);
        rectangulo.setWidth(rectWidth);
        rectangulo.setStroke(Color.TRANSPARENT);
        rectangulo.setFill(Color.ORANGE);
        
        // Creamos el Pane para añadir el círculo, al centro de nuestra pantalla
        Pane pane = new Pane();
        circle.setCenterX(circleCenterX);
        circle.setCenterY(circleCenterY);

        // Utilizamos ArcTo para crear el arco por el que irá nuestro rectángulo
        ArcTo arcTo = new ArcTo();
        arcTo.setX(circleCenterX - radius);
        arcTo.setY(circleCenterY + 0.01);
        arcTo.setRadiusX(radius);
        arcTo.setRadiusY(radius);
        arcTo.setSweepFlag(true);
        arcTo.setLargeArcFlag(true);
        
        // Añadimos un Path que contendrá las medidas de nuestro círculo
        Path path = new Path();
        path.getElements().addAll(new MoveTo(circleCenterX - radius, circleCenterY), arcTo, new ClosePath());
        
        // Añadimos las propiedades de nuestro círculo(color, tipo de línea...)
        path.setStroke(Color.BLACK);
        path.getStrokeDashArray().setAll(1d, 0d);
         
        // Añadimos nuestra PathTransition la cual le dará el movimiento
        PathTransition pathTransition = new PathTransition();
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.setPath(path);
        
        // Le añadimos la duración, que tardará nuestro rectangulo en dar la vuelta
        pathTransition.setDuration(Duration.millis(4000));
        // Le añadimos Timeline.Indefinite para que no para de dar vueltas nuestro rectangulo
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        // Le añadimos la orientación a nuestro rectángulo
        pathTransition.setNode(rectangulo);
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);

        // Añdimos un MoussePressed para que cuando pulsemos con nuestro ratón pare el movimiento
        pane.setOnMousePressed(value
                -> {
            pathTransition.pause();
        });
        
        // Añadimos un MouseReleased para que cuando dejemos de pulsar siga girando
        pane.setOnMouseReleased(value
                -> {
            pathTransition.play();
        });
        
        
        Scene scene = new Scene(pane, 400, 350);
        pane.getChildren().addAll(path, rectangulo);

         primaryStage.setTitle("Path Transition In Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
        pathTransition.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
