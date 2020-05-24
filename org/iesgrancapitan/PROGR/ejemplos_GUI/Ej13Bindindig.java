package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Ejemplo de uso de eventos basados en propiedades.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ej13Bindindig extends Application {

  @Override
  public void start(Stage primaryStage) {
    
    TextField top = new TextField("Soy un TextField");
    top.textProperty().addListener((observable, oldValue, newValue) -> {
      System.out.println("Antes..: " + oldValue);
      System.out.println("Después: " + newValue);
      System.out.println("--------------------");
      if (newValue.equals("BORRAME")) {
        //((TextField) observable).setText("¡No me borres!");
        top.setText("¡No me borres!");
      }
    });
    
    TextField bottom = new TextField();
    bottom.textProperty().bindBidirectional(top.textProperty());
    
    Button button = new Button("Botón");
    button.textProperty().bind(top.textProperty());
    
    VBox root = new VBox(10, top, bottom, button);
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }
}
