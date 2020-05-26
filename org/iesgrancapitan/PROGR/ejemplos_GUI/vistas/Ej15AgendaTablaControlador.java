package org.iesgrancapitan.PROGR.ejemplos_GUI.vistas;

import org.iesgrancapitan.PROGR.ejemplos_GUI.Ej15AgendaTabla;
import org.iesgrancapitan.PROGR.ejemplos_GUI.agenda.Agenda;
import org.iesgrancapitan.PROGR.ejemplos_GUI.agenda.Contacto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;

public class Ej15AgendaTablaControlador {
  @FXML
  private TableView<Contacto> contactosTabla;
  @FXML
  private TableColumn<Contacto, String> nombreColumna;
  @FXML
  private TableColumn<Contacto, Integer> telefonoColumna;
  @FXML
  private TableColumn<Contacto, String> emailColumna;

  private Ej15AgendaTabla mainApp;

  @FXML
  private void initialize() {

    // Configuramos columnas tabla
    nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    telefonoColumna.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    emailColumna.setCellValueFactory(new PropertyValueFactory<>("email"));
  }

  private void actualizaContactosTabla() {
    Agenda agenda = mainApp.getAgenda();
    ObservableList<Contacto> contactos = FXCollections.observableArrayList();
    for (Contacto contacto: agenda) {
      contactos.add(contacto);
      //contactosTabla.getItems().add(contacto);
    }
    contactosTabla.setItems(contactos);
  }

  /**
   * Es llamado por la aplicación principal para devolverse una referencia a sí mismo.
   * 
   * @param mainApp
   */
  public void setMainApp(Ej15AgendaTabla mainApp) {
    this.mainApp = mainApp;
    actualizaContactosTabla();  // Rellenamos tabla
  }

}
