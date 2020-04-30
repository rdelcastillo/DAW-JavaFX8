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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    button.setDefaultButton(true);
    root.add(button, 0, 2, 2, 1);               // colspan=2, rowspan=1
    //GridPane.setColumnSpan(button, 2);        // otra forma de hacer columnspan
    GridPane.setHalignment(button, HPos.CENTER);

    // manejo de eventos del botón
    button.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
        System.out.println(user.getText() + " ha hecho click.");
        System.out.println("La contraseña introducida ha sido '" + password.getText() + "'");
      }
    });
    
    button.setOnMousePressed(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent e) {
        System.out.println("Estás presionando el botón Ok.");
      }
    });
    
    // con una expresión lambda es más corto (si hubiera varias líneas usaríamos llaves)
    button.setOnMouseReleased(event -> System.out.println("Has soltado el botón Ok.")); 
    
    // creamos escena y asignamos a escenario
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
