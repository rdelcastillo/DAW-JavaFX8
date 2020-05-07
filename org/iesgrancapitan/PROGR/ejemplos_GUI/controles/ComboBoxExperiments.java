/**
 * The JavaFX ComboBox control enables users to choose an option from a predefined list of choices, 
 * or type in another value if none of the predefined choices matches what the user want to select. 
 * 
 * The JavaFX ComboBox control is represented by the class javafx.scene.control.ComboBox .
 * 
 *  See more at http://tutorials.jenkov.com/javafx/combobox.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.controles;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxExperiments extends Application  {

  @SuppressWarnings("unchecked")
  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ComboBox Experiment 1");

    // You create a ComboBox simply by creating a new instance of the ComboBox class
    
    @SuppressWarnings("rawtypes")
    ComboBox comboBox = new ComboBox();

    // You can add choices to a ComboBox by obtaining its item collection and add items to it
    comboBox.getItems().add("Choice 1");
    comboBox.getItems().add("Choice 2");
    comboBox.getItems().add("Choice 3");
    
    // A ComboBox is not editable by default. 
    // To make a ComboBox editable you must call the setEditable() method of the ComboBox
    comboBox.setEditable(true);
    
    // You can read the selected value of a ComboBox via its getValue() method. 
    // If no choice is selected, the getValue() method returns null
    Button button1 = new Button("Check");
    button1.setOnAction(value ->  {
      System.out.println("The select value is " + comboBox.getValue()); 
    });

    HBox hbox = new HBox(comboBox, button1);
    hbox.setPadding(new Insets(10,10,10,10));
    hbox.setSpacing(25);

    Scene scene = new Scene(hbox, 300, 50);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}