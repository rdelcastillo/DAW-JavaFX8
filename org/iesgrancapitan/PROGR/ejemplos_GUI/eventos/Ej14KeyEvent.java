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

public class Ej14KeyEvent extends Application {

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

      String type = e.getEventType().getName();
      String source = e.getSource().getClass().getSimpleName();
      String target = e.getTarget().getClass().getSimpleName();

      System.out.println("filter: " + type + ", " + source + ", " + target);

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