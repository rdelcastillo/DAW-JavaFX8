/**
 * Este programa impide introducir datos numéricos.
 * 
 * Con un EventFilter capturamos en la escena la tecla pulsada.
 * 
 * Fuente: http://acodigo.blogspot.com/2017/06/eventos-en-javafx.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.eventos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Eventos02KeyEvent extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {

    TextField tf1 = new TextField();
    PasswordField tf2 = new PasswordField();
    TextArea tf3 = new TextArea();

    VBox root = new VBox(tf1, tf2, tf3);
    root.setSpacing(5.0);
    root.setPadding(new Insets(5.0));

    Scene scene = new Scene(root, 300, 250);
    scene.addEventFilter(KeyEvent.KEY_TYPED, e -> {
      if (Character.isDigit(e.getCharacter().charAt(0))) {
        System.out.println("caracter: " + e.getCharacter() + ", no permitido.");
        e.consume(); 
      }
    });

    primaryStage.setTitle("JavaFX Manejo de Eventos");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}