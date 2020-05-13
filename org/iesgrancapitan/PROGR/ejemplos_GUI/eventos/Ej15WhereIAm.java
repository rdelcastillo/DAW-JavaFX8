package org.iesgrancapitan.PROGR.ejemplos_GUI.eventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ej15WhereIAm extends Application {

  @Override
  public void start(Stage primaryStage) {
    
    StackPane root = new StackPane();
    
    Text text = new Text();
    text.setFont(new Font("Courier", 16));
    
    root.getChildren().add(text);
    
    Scene scene = new Scene(root, 800, 500);
    
    scene.setOnMouseMoved(value -> {
      text.setText("Posición ratón: (" + (int) value.getX() + "," + (int) value.getY() + ") y " +
                                   "(" + (int) value.getScreenX() + "," + (int) value.getScreenY() +
                                   ")");
    });
    
    scene.setOnMouseExited(value -> {
      text.setFont(new Font("Arial Black", 100));
      text.setText("¿Dónde vas?"); 
    });

    scene.setOnMouseEntered(value -> {
      text.setFont(new Font("Courier", 16));
      text.setText("Hola de nuevo"); 
    });
    
    primaryStage.setTitle("JavaFX Manejo de Eventos");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
