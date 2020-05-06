package org.iesgrancapitan.PROGR.ejemplos_GUI.controles.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MenuButtonsExperimentsControler implements Initializable {
  
  @FXML
  private MenuItem menuItem3;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    // TODO Auto-generated method stub    
  }
  
  public void fireMenuItem3() {
    System.out.println("Option 3 selected via Lambda"); 
  }

}
