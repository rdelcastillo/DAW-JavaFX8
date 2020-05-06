/**
 * The JavaFX ImageView control can display an image inside a JavaFX GUI. 
 * The ImageView control must be added to the scene graph to be visible. 
 * The JavaFX ImageView control is represented by the class javafx.scene.image.ImageView.
 * 
 * See more at http://tutorials.jenkov.com/javafx/imageview.html
 * 
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ImageViewExperiments extends Application  {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("ImageView Experiment 1");

    Image image = new Image(getClass().getResource("view/JavafxClasses.jpg").toString());
    ImageView imageView = new ImageView(image);

    HBox hbox = new HBox(imageView);

    Scene scene = new Scene(hbox, 1000, 600);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    Application.launch(args);
  }

}