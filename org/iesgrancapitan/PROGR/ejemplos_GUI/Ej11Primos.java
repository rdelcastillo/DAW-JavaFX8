package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Mostrar en pantalla los N primeros números primos. Se pide la cantidad
   de números primos que queremos mostrar.
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ej11Primos extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader fxml = new FXMLLoader(this.getClass().getResource("vistas/Ej11Primos.fxml"));
    GridPane root = fxml.<GridPane>load();  
    primaryStage.setScene(new Scene(root));
    primaryStage.setTitle("App " + this.getClass().getSimpleName());     // nombre de la clase
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
