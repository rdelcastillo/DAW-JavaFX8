package org.iesgrancapitan.PROGR.ejemplos_GUI;

import java.io.IOException;

import org.iesgrancapitan.PROGR.ejemplos_GUI.agenda.Agenda;
import org.iesgrancapitan.PROGR.ejemplos_GUI.agenda.ContactoException;
import org.iesgrancapitan.PROGR.ejemplos_GUI.vistas.Ej15AgendaTablaControlador;

/**
 * Ejemplo de uso de una clase Iterable.
 * 
 * Tendremos una clase Agenda compuesta por una lista de objetos de clase Contacto a la que 
 * implementaremos la interfaz Iterable para poder recorrerla con un foreach. 
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ej15AgendaTabla extends Application {
  private Agenda agenda = new Agenda();

  public Agenda getAgenda() {
    return agenda;
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("vistas/Ej15AgendaTabla.fxml"));
    Parent root = fxmlLoader.load();

    // Damos al controlador acceso a la aplicación principal.
    Ej15AgendaTablaControlador controller = fxmlLoader.getController();
    controller.setMainApp(this);

    // Añadimos nodo a una escena y esta al escenario
    primaryStage.setScene(new Scene(root));
    primaryStage.setTitle("App " + this.getClass().getSimpleName());
    primaryStage.show();
  }

  @Override
  public void init() throws ContactoException {
    // datos de prueba
    agenda.add("Pepe Pérez", 111111111, "pepe@email.es");
    agenda.add("Pepa López", 222222222, "pepa@email.es");
    agenda.add("Juana Henz", 333333333, "juana@email.es");
  }

  public static void main(String[] args) {
    launch(args);
  }


}
