package org.iesgrancapitan.PROGR.ejemplos_GUI;

import java.io.IOException;
import java.util.List;

import org.iesgrancapitan.PROGR.ejemplos_GUI.vistas.Ej14Controlador;

/**
 * En este ejemplo vamos a ver como desde un controlador podemos acceder a datos que están
 * definidos en nuestro objeto Application.
 * 
 * También vamos a ver el funcionamiento de los métodos init() y stop().
 * 
 * Estos datos se le van a pasar a la App como parámetros.
 * 
 * Método 1: definir un atributo estático en la App.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ej14AccederDatosAppDesdeControlador extends Application {
  public static  String parametro1;     // mal
  private static String parametro2;
  
  /*
   * Cuando comienza una aplicación JavaFX, hay tres métodos que se llaman en orden. Estos son:
   * 
   * void init()
   * abstract void start(Stage stage)
   * void stop()
   */
  
  @Override
  public void init() {
    // Ejecutado antes que el método start, ningún componente gráfico ha sido creado
    System.out.println("Soy el método init()");
    
    // Accedo a los argumentos con los que hemos llamado a la aplicación
    List<String> params = getParameters().getRaw();
    int n = 0;
    for (String p: params) {
      System.out.println("Parámetro " + (++n) + ": " + p);
    }
    
    // modifico atributos App
    parametro1 = getParameters().getRaw().get(0);
    parametro2 = getParameters().getRaw().get(1);
    
    System.out.println("---");
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    System.out.println("Soy el método start()\n---");
    
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vistas/Ej14.fxml"));
    Parent root = fxmlLoader.load();
    
    /* Además de usar atributos estáticos y acceder a los mismos desde el controlador,
     * podemos acceder al controlador e "inyectarle" valores desde aquí.
     * 
     * En este caso le pasamos el tercer argumento.
     */
    Ej14Controlador controller = fxmlLoader.getController();
    controller.actualiza(getParameters().getRaw().get(2));
    
    // Añadimos nodo a una escena y esta al escenario
    primaryStage.setScene(new Scene(root));
    primaryStage.setTitle("App " + this.getClass().getSimpleName());
    primaryStage.show();
  }
  
  @Override
  public void stop() {
    // Ejecutado al terminar la aplicación
    System.out.println("Soy el método stop(), me ejecutan al final, cuando la aplicación termina.");
  }

  // método observador
  public static String getParametro2() {
    return parametro2;
  }
  
  public static void main(String[] args) {
    launch(args);
  }

}
