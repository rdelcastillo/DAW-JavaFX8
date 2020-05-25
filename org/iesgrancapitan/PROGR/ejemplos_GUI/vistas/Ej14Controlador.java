package org.iesgrancapitan.PROGR.ejemplos_GUI.vistas;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import org.iesgrancapitan.PROGR.ejemplos_GUI.Ej14AccederDatosAppDesdeControlador;

public class Ej14Controlador {
  @FXML
  private TextField text1;
  @FXML
  private TextField text2;
  @FXML
  private TextField text3;
  
  // datos recogidos de la App
  private String dato1;
  private String dato2;
  private String dato3;

  // Event Listener on Button.onAction
  @FXML
  public void rellena(ActionEvent event) {
    text1.setText(dato1);
    text2.setText(dato2);
    text3.setText(dato3);
  }
  
  // Nos actualizan los datos "desde fuera"
  public void actualiza(String dato) {
    dato3 = dato;
  }

  @FXML
  public void initialize() {
    System.out.println("Inicializo controlador sin implementar 'Initializable'"); 
    System.out.println("---");
    
    // recojo datos (el tercero me lo "inyectan" desde la App)
    dato1 = Ej14AccederDatosAppDesdeControlador.parametro1;
    dato2 = Ej14AccederDatosAppDesdeControlador.getParametro2();
  }
}
