package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Ejemplo de GUI usando JavaFX.
 * 
 * Creamos una ventana secundaria que puede bloquear a la principal.
 */

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Ej03Ventanas extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX App");

    Stage stage = new Stage();
    
    //stage.initModality(Modality.APPLICATION_MODAL); // bloquea todas las ventanas
    
    stage.initOwner(primaryStage);
    stage.initModality(Modality.WINDOW_MODAL); // bloquea la ventana principal (dueña de este escenario)
    
    //stage.initModality(Modality.NONE);
    
    stage.setTitle("Modo ventana: " + stage.getModality());

    primaryStage.show();
    System.out.println("Hemos lanzado el 'Stage' primario (pero no cerrado).");

    stage.showAndWait();
    System.out.println("Hemos cerrado el 'Stage' secundario.");

  }
}