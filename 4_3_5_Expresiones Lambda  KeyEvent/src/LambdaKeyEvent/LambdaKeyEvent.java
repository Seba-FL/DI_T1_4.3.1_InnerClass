/*
Autor : Sebastián Fernández López
Descripción : Expresiones Lambda keyEvent
 */
package LambdaKeyEvent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LambdaKeyEvent extends Application {

    // Variables
    int anchoP = 300;
    int altoP = 250;
    int setX = 50;
    int setY = 50;

    @Override
    public void start(Stage primaryStage) {
        Text letra = new Text(50, 50, "A");
        letra.setX(setX);
        letra.setY(setY);

        Pane root = new Pane();
        root.getChildren().add(letra);

        letra.setFocusTraversable(true);
        letra.setOnKeyPressed(event
                -> {

            switch (event.getCode()) {
                case UP:
                    letra.setY(letra.getY() - 10);
                    break;
                case DOWN:
                    letra.setY(letra.getY() + 10);
                    break;
                case RIGHT:
                    letra.setX(letra.getX() + 10);
                    break;
                case LEFT:
                    letra.setX(letra.getX() - 10);
                    break;

            }
            double x = letra.getX();
            double y = letra.getY();

            letra.setX(Double.max(0, Double.min(x, anchoP - 10)));
            letra.setY(Double.max(10, Double.min(y, altoP)));

        });
        Scene scene = new Scene(root, anchoP, altoP);

        primaryStage.setTitle("4.3.5.Expresiones Lambda. KeyEvent");
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
