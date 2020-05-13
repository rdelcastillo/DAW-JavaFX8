/**
 * Fuente: http://acodigo.blogspot.com/2017/06/eventos-en-javafx.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.eventos;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ej13MouseEvent extends Application {

  @Override
  public void start(Stage primaryStage) {

    EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();

        System.out.println("Soy 'handler'. Type: " + type + ", source: " + source + ", target: " + target);
      }
    };

    EventHandler<MouseEvent> filter = (MouseEvent e) -> {
      String type = e.getEventType().getName();
      String source = e.getSource().getClass().getSimpleName();
      String target = e.getTarget().getClass().getSimpleName();

      System.out.println("Soy 'filter'. Type: " + type + ", source: " + source + ", target: " + target);
    };

    Button btn = new Button();
    btn.setText("Button");
    btn.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);

    StackPane root = new StackPane();
    root.getChildren().add(btn);
    root.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);

    Scene scene = new Scene(root, 300, 250);
    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, filter);

    primaryStage.setTitle("JavaFX Manejo de Eventos");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}