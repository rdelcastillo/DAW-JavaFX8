package org.iesgrancapitan.PROGR.ejemplos_GUI;

/**
 * Combinamos VBOX y HBOX para hacer diseños más compactos.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ej08VHBox extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Ejemplo " + this.getClass().getSimpleName());
    
    // controles
    Label label11 = new Label("L11L");
    label11.setFont(new Font("Arial", 20));
    TextField texto12 = new TextField("T12T");
    Text texto13 = new Text("t13t");
    HBox hbox1 = new HBox(label11, texto12, texto13);
    
    TextArea texto2 = new TextArea("Rellena");
    texto2.setFont(new Font("Gothic", 25));
    
    Label label31 = new Label("L31L");
    Label label33 = new Label("L33L");
    VBox vbox32 = new VBox(new Label("321"), new Button("No hago nada"), new Label("323"));
    HBox hbox3 = new HBox(label31, vbox32, label33);
    
    VBox vbox = new VBox(hbox1, texto2, hbox3);
    
    Scene scene = new Scene(vbox, 600, 600);
    
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
