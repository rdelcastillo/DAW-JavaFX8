/**
 * A JavaFX CheckBox is a button which can be in three different states: Selected, not selected 
 * and unknown (indeterminate). 
 * 
 * The JavaFX CheckBox control is represented by the class javafx.scene.control.CheckBox.
 * 
 * See more at http://tutorials.jenkov.com/javafx/checkbox.html
 * 
 */
package org.iesgrancapitan.PROGR.ejemplos_GUI.controles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class CheckBoxExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("CheckBox Experiment 1");

    CheckBox checkBox1 = new CheckBox("Off");

    // You can read the selected state of a CheckBox via its method isSelected()

    checkBox1.setOnAction(value ->  {
      if (checkBox1.isSelected()) {     
        checkBox1.setText("On");
      } else {
        checkBox1.setText("Off");
      }       
    });

    Button button1 = new Button("Check");
    button1.setOnAction(value ->  {
      if (checkBox1.isSelected()) {
        System.out.println("We are in ON.");
      } else {
        System.out.println("We are in OFF.");
      }       
    });

    HBox hbox = new HBox(checkBox1, button1);
    hbox.setPadding(new Insets(10,10,10,10));
    hbox.setSpacing(25);

    Scene scene = new Scene(hbox, 175, 50);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}