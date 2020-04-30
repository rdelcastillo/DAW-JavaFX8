package org.iesgrancapitan.PROGR.ejemplos_GUI.vistas;

/**
 * Controlador-vista para los eventos de Ej11Primos.
 * 
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Ej11PrimosControlador implements Initializable {
  @FXML
  private TextField cantidad;

  @FXML
  private TextArea resultado;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  public void calcula(ActionEvent e) {
    int cantidadAMostrar = Integer.parseInt(cantidad.getText());
    
    // el primer primo es 2, los otros son todos impares...
    resultado.setText("1: 2");
    int cantidadMostrados = 1;
    // ...a partir de 3
    int num = 3;
    while (cantidadMostrados < cantidadAMostrar) {
      // pienso que es primo hasta que encuentre con que dividirlo
      boolean esPrimo = true;
      // ya sabemos que es impar
      for (int divisor=3; divisor<=Math.sqrt(num) && esPrimo; divisor+=2) {
        // si la división da exacta...
        if (num%divisor==0) {
          // ...ya no es primo
          esPrimo = false;
        }
      }
      if (esPrimo) {
        cantidadMostrados++;
        resultado.setText(resultado.getText() +"\n" + cantidadMostrados + ": " + num);
      }
      num += 2;
    }
  }

}
