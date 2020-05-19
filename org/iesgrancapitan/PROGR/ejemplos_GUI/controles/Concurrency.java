/**
 * JavaFX uses a single-threaded rendering design, meaning only a single thread can render anything on 
 * the screen, and that is the JavaFX application thread. 
 * 
 * In fact, only the JavaFX application thread is allowed to make any changes to the JavaFX Scene Graph 
 * in general.
 * 
 * A single-threaded rendering design is easier to implement correctly, but long-running tasks that run 
 * within the JavaFX application thread make the GUI unresponsive until the task is completed. 
 * 
 * No JavaFX GUI controls react to mouse clicks, mouse over, keyboard input while the JavaFX application 
 * thread is busy running that task.
 *  * 
 * See more at http://tutorials.jenkov.com/javafx/concurrency.html
 * 
 * In this example we implement a clock.
 * 
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.controles;

import java.time.LocalTime;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Concurrency extends Application {
  
  private boolean keepRunning = true;
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    
    // clock controls

    Font font = new Font("Arial", 50);
    
    Label sep1 = new Label(":");
    sep1.setFont(font);
    
    Label sep2 = new Label(":");
    sep2.setFont(font);
    
    Label hora = new Label("00");
    hora.setFont(font);
    
    Label minuto = new Label("00");
    minuto.setFont(font);
    
    Label segundo = new Label("00");
    segundo.setFont(font);
    
    /*
     * Sometimes you absolutely need to perform some long-running task in a JavaFX application. 
     * You don't want to leave the GUI unresponsive while the task is running, so you want to run the 
     * ask in its own thread. However, you would like the running task to update the GUI - either along
     * the way, or when the task is completed. The task thread cannot update the GUI (the scene graph) 
     * directly - but JavaFX has a solution for this problem.
     * 
     * JavaFX contains the Platform class which has a runLater() method. The runLater() method takes a 
     * Runnable which is executed by the JavaFX application thread when it has time. From inside this 
     * Runnable you can modify the JavaFX scene graph.
     */

    Thread taskThread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (keepRunning) {
          Platform.runLater(new Runnable() {
            @Override
            public void run() {
              hora   .setText(String.format("%02d", LocalTime.now().getHour()));
              minuto .setText(String.format("%02d", LocalTime.now().getMinute()));
              segundo.setText(String.format("%02d", LocalTime.now().getSecond()));
            }
          });
          
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }        
        }
      }
    });

    taskThread.start();
    
    // Layout, scene and stage
    
    HBox root = new HBox(5, hora, sep1, minuto, sep2, segundo);
    root.setPadding(new Insets(10));
    
    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Concurrency: clock");
    primaryStage.setOnCloseRequest(e -> keepRunning = false);   // to stop the thread
    primaryStage.show();
  }
}
