package org.iesgrancapitan.PROGR.ejemplos_GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.iesgrancapitan.PROGR.ejemplos_GUI.agenda.Agenda;
import org.iesgrancapitan.PROGR.ejemplos_GUI.agenda.ContactoException;

/**
 * Ejemplo de uso de una clase Iterable.
 * 
 * Tendremos una clase Agenda compuesta por una lista de objetos de clase Contacto a la que 
 * implementaremos la interfaz Iterable para poder recorrerla con un foreach. 
 */

public class Ej17AgendaTablaBD extends Ej15AgendaTabla {

  @Override
  public void init() throws ContactoException {
    try {
      Agenda agenda = this.getAgenda(); 
      
      // Conectar con base de datos y extraigo datos
      Connection conexion = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
      Statement stament = conexion.createStatement();
      ResultSet resultset = stament.executeQuery("SELECT * FROM contactos");

      // Relleno la agenda con el resultado de la consulta SQL
      while (resultset.next()) {
        agenda.add(resultset.getString("nombre"), resultset.getInt("telefono"),
            resultset.getString("email"));
      }

    } catch (SQLException e) {
      System.err.println("Error al conectar con la base de datos");
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    launch(args);
  }


}
