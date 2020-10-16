/*
Autor : Sebastián Fernández López
Descripción : Expresiones Lambda ActionEvent
 */
package ExpresionesLambdaActionEvent;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class ExpresionesLambdaActionEvent extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Expresiones Lambda. ActionEvent.");
        primaryStage.show();

        //Creamos ahora el diseño de nuestra ventana a mostrar
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        //Añadimos las etiquetas necesarias para dar la bienvenida
        Text scenetitle = new Text("Calculadora Préstamo");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.setAlignment(Pos.CENTER);

        //Añadimos los campos necesarios para recoger los datos para poder hacer los cálculos
        Label lb_AIR = new Label("Annual Interest Rate : ");
        grid.add(lb_AIR, 0, 1);

        TextField tf_AIR = new TextField();
        grid.add(tf_AIR, 1, 1);

        Label lb_NOY = new Label("Number of Years : ");
        grid.add(lb_NOY, 0, 2);

        TextField tf_NOY = new TextField();
        grid.add(tf_NOY, 1, 2);

        Label lb_LA = new Label("Loan Amount :");
        grid.add(lb_LA, 0, 3);

        TextField tf_LA = new TextField();
        grid.add(tf_LA, 1, 3);

        Label lb_MP = new Label("Monthly Payment :");
        grid.add(lb_MP, 0, 4);

        TextField tf_MP = new TextField();
        grid.add(tf_MP, 1, 4);

        Label lb_TP = new Label("Total Payment :");
        grid.add(lb_TP, 0, 5);

        TextField tf_TP = new TextField();
        grid.add(tf_TP, 1, 5);

        // Creamos el botón para poder pulsar y calcular
        Button btn = new Button("Calculate");
        HBox hbBtn = new HBox(10);

        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 6);

        // Creamos la expresion Lambda
        btn.setOnAction(event -> {

            float i; //Annual Interest Rate
            float n; // Numbers Of Years
            float h; // Loan Amount
            float m; //Monthly Payment
            float tp; // Total Payment
            float r; // Rate

            i = Float.valueOf(tf_AIR.getText());
            n = Float.valueOf(tf_NOY.getText());
            h = Float.valueOf(tf_LA.getText());

            r = i / (100 * 12);
            m = (float) ((h * r) / (1 - Math.pow((1 + r), -12 * n)));
            tp = (float) (m * (12 * n));

            //MPtextField.setText("Error");
            tf_MP.setText("$" + new DecimalFormat("#.##").format(m));
            tf_TP.setText("$" + new DecimalFormat("#.##").format(tp));

        });

        Scene scene = new Scene(grid, 400, 375);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
