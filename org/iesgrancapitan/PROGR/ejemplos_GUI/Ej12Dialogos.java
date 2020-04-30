package org.iesgrancapitan.PROGR.ejemplos_GUI;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Ej12Dialogos extends Application {

  @Override
  public void start(Stage primaryStage) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Information Dialog");
    alert.setHeaderText("Look, an Information Dialog");
    alert.setContentText("I have a great message for you!");

    alert.showAndWait();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
