package org.iesgrancapitan.PROGR.ejemplos_GUI.vistas;

/**
 * Controlador-vista para los eventos de Ej09Login.
 * 
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Ej09LoginControlador implements Initializable {
  @FXML
  private TextField user;

  @FXML
  private PasswordField password;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void okAction(ActionEvent e) {
    System.out.println(user.getText() + " ha hecho click.");
    System.out.println("La contraseña introducida ha sido '" + password.getText() + "'");
  }
  
  public void onMousePressed(MouseEvent e) {
    System.out.println("Estás presionando el botón Ok.");
  }

  public void onMouseReleased(MouseEvent e) {
    System.out.println("Has soltado el botón Ok.");
  }

}
