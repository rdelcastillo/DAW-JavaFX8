package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * 
 */

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ej07FXML extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    
    // cargamos FXMLs
    FXMLLoader fxml1 = new FXMLLoader();
    fxml1.setLocation(Ej07FXML.class.getResource("vistas/Ej07FXML.fxml"));
    FXMLLoader fxml2 = new FXMLLoader(this.getClass().getResource("vistas/Ej07FXML2.fxml"));
    FXMLLoader fxml3 = new FXMLLoader(this.getClass().getResource("vistas/Ej07FXML3.fxml"));
    
    // obtenemos elemento raíz del FXML
    VBox vbox1 = fxml1.<VBox>load();
    VBox vbox2 = fxml2.<VBox>load();
    VBox vbox3 = fxml3.<VBox>load();

    // construimos escena 1 y añadimos al escenario principal
    Scene scene1 = new Scene(vbox1);
    primaryStage.setScene(scene1);
    primaryStage.setTitle("App " + this.getClass().getSimpleName());     // nombre de la clase
    primaryStage.show();
    
    // construimos escena 2 y otro escenario
    Stage stage2 = new Stage();
    stage2.setTitle("Escenario 2");
    Scene scene2 = new Scene(vbox2);
    stage2.setScene(scene2);
    stage2.show();
    
    // construimos escena 3 y otro escenario
    Stage stage3 = new Stage();
    stage3.setTitle("Escenario 3 (basado en el principal, pero con más cosas)");
    Scene scene3 = new Scene(vbox3);
    stage3.setScene(scene3);
    stage3.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
