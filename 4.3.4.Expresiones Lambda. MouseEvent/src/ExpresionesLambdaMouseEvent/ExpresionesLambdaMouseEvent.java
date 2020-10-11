/*
Autor : Sebastián Fernández López
Descripción : Expresiones Lambda MouseEvent
 */
package ExpresionesLambdaMouseEvent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author UsuarioDAM
 */
public class ExpresionesLambdaMouseEvent extends Application {

    // Variables
    int anchoP = 300;
    int altoP = 250;

    @Override
    public void start(Stage primaryStage) {
        // Creamos el panel donde podremos ver la frase insertada y moverla con el ratón
        Pane root = new Pane();

        // Le damos las medidas que tendrá nuestro tablero
        Scene scene = new Scene(root, anchoP, altoP);

        // Añadimos la frase que quermos que aparezca en nuestra pantalla
        Text text = new Text("Programing is fun");
        root.getChildren().add(text);

        text.setTextAlignment(TextAlignment.CENTER);
        text.setX(50);
        text.setY(50);

        // Aplicamos la expresion Lambda
        text.setOnMouseDragged(event
                -> {
            double x = event.getX();
            double y = event.getY();
            text.setX(Double.max(0, Double.min(x, anchoP - 95)));
            text.setY(Double.max(0, Double.min(y, altoP)));
        });

        // Mostramos la pantalla
        primaryStage.setTitle("4.3.5.Expresiones Lambda. MouseEvent");
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
