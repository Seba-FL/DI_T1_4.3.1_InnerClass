/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg3.pkg6.pathtransition.in.animation;

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

    Circle circle = new Circle();
    Rectangle rectangulo = new Rectangle();

    @Override
    public void start(Stage primaryStage) {
        /* Creamos nuestro círculo */

        int radius = 50;
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        /* Creamos nuestro rectángulo */
        int rectHeight = 60;
        int rectWidth = 30;
        rectangulo.setHeight(rectHeight);
        rectangulo.setWidth(rectWidth);
        rectangulo.setStroke(Color.TRANSPARENT);
        rectangulo.setFill(Color.YELLOW);

        Pane pane = new Pane();
        int circleCenterX = 400 / 2;
        int circleCenterY = 350 / 2;
        circle.setCenterX(circleCenterX);
        circle.setCenterY(circleCenterY);
        int initialRectX = (400 / 2) - (rectWidth / 2) - radius;
        int initialRectY = (350 / 2) - (rectHeight / 2);
        //rectangulo.setX(initialRectX);
        //rectangulo.setY(initialRectY);

        /* Creamos la animación que hará que nuestro circulo se mueva */
        PathTransition pathTransition = new PathTransition();
        ArcTo arcTo = new ArcTo();
        arcTo.setX(circleCenterX - radius);
        arcTo.setY(circleCenterY + 0.01);
        arcTo.setRadiusX(radius);
        arcTo.setRadiusY(radius);
        arcTo.setSweepFlag(true);
        arcTo.setLargeArcFlag(true);
        Path path = new Path();
        path.getElements().addAll(new MoveTo(circleCenterX - radius, circleCenterY), arcTo, new ClosePath());
        path.setStroke(Color.BLUE);
        path.getStrokeDashArray().setAll(1d, 0d);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.setPath(path);
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setNode(rectangulo);
        pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);

        pane.setOnMousePressed(value
                -> {
            pathTransition.pause();
        });
        pane.setOnMouseReleased(value
                -> {
            pathTransition.play();
        });
        // Creamos el BorderPane y le añadimos el HBox para poder mostrarlo en pantalla
        Scene scene = new Scene(pane, 400, 350);
        pane.getChildren().addAll(path, rectangulo);
        
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
