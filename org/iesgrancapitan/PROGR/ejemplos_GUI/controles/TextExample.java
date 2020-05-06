/**
 * The JavaFX Text control can display a text inside a JavaFX GUI. 
 * The JavaFX Text control is represented by the JavaFX class javafx.scene.text.Text . 
 * 
 * You can set the font to be used by the Text control, text size, font decorations and 
 * many other things.
 * 
 * See more at http://tutorials.jenkov.com/javafx/text.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.controles;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {

        Text text = new Text("This is a JavaFX text.");

        Scene scene = new Scene(new VBox(text), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}