package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Ejemplo de login.
 * 
 * Similar al ejemplo anterior pero sin FXML.
 * 
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ej10Login extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("App " + this.getClass().getSimpleName());
    
    // Layout GridPane: nos permite crear una matriz/cuadricula
    GridPane root = new GridPane();
    root.setHgap(10);   // separación entre columnas
    root.setVgap(10);   // separación entre filas
    root.setPadding(new Insets(10, 10, 10, 10));

    // controles
    root.add(new Label("Nombre de usuario"), 0, 0);

    TextField user = new TextField();
    root.add(user, 1, 0);

    root.add(new Label("Contraseña"), 0, 1);

    PasswordField password = new PasswordField();
    root.add(password, 1, 1);

    Button button = new Button("Ok");
    button.setAlignment(Pos.CENTER);
    root.add(button, 0, 2, 2, 2);       // colspan=1, rowspan=1

    // manejo de eventos del botón
    button.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent e) {
        System.out.println(user.getText() + " ha hecho click.");
        System.out.println("La contraseña introducida ha sido '" + password.getText() + "'");
      }
    });

    // creamos escena y asignamos a escenario
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
