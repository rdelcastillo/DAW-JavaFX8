package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Ejemplo de GUI usando JavaFX.
 * 
 * Mostramos una ventana con título maximizada, tiene que tener un objeto Scene para ello.
 * 
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ej06HolaMundo extends Application {

  @Override
  public void start(Stage primaryStage) {
    
    // creamos control etiqueta
    Label label = new Label("¡Hola Mundo, JavaFX!");
    label.setFont(new Font("Arial", 50));
    label.setAlignment(Pos.CENTER);
    
    // creamos escena, añadimos control y cammiamos cursor del ratón
    Scene scene = new Scene(label);
    scene.setCursor(Cursor.OPEN_HAND);

    // colocamos escena en el escenario primario y maximizamos ventana
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);
    primaryStage.setTitle("Saludos");
    
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}