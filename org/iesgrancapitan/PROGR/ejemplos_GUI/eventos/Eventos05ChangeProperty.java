/**
 * Este programa impide introducir datos numéricos.
 * 
 * Controlaremos la propiedad TextProperty del TextField para que solo se puedan introducir
 * dígitos y el punto (uno solo).
 * 
 * Fuente: http://acodigo.blogspot.com/2017/06/eventos-en-javafx.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.eventos;

import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Eventos05ChangeProperty extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    TextField tf1 = new TextField();
    PasswordField tf2 = new PasswordField();
    TextArea tf3 = new TextArea();

    VBox root = new VBox(tf1, tf2, tf3);
    root.setSpacing(5.0);
    root.setPadding(new Insets(5.0));

    Scene scene = new Scene(root, 300, 250);
    
    // Añadimos "listener" al TextField
    tf1.textProperty().addListener((observable, oldValue, newValue) -> {
      if (!esValido(newValue)) {
        tf1.setText(oldValue);
      }
    });

    primaryStage.setTitle("JavaFX Manejo de Eventos");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private static boolean esValido(String cadena) {
    return Pattern.matches("^[0-9]*\\.?[0-9]*$", cadena);
  }
  
  public static void main(String[] args) {
    launch(args);
  }
}