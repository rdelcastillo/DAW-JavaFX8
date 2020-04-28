package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Ejemplo de GUI usando JavaFX.
 * 
 * Mostramos una ventana con título.
 * 
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Ej01HolaMundo extends Application {

  @Override
  public void start(Stage primaryStage) {
    
    // el objeto stage que se recibe es creado por Application
    primaryStage.setTitle("Mi primera aplicación JavaFX");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}