package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Mostrar en pantalla los N primeros números primos. Se pide la cantidad
   de números primos que queremos mostrar.
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ej11Primos extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    // Obtenemos nodo raíz del FXML (otra forma)
    Parent root = FXMLLoader.load(getClass().getResource("vistas/Ej11Primos.fxml"));
    
    // Añadimos nodo a una escena y esta al escenario
    primaryStage.setScene(new Scene(root));
    primaryStage.setTitle("App " + this.getClass().getSimpleName());
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
