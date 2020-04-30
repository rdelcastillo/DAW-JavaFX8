package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Uso de FXML y clase controladora para leer los eventos del botón.
 * 
 * Ejemplo de login.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ej09Login extends Application {

  @Override
  public void start(Stage primaryStage) {
    try {

      FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("vistas/Ej09Login.fxml"));
      GridPane root = fxml.<GridPane>load();  
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.setTitle("App " + this.getClass().getSimpleName());     // nombre de la clase
      primaryStage.show();


    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  public static void main(String[] args) {
    launch(args);
  }
}
