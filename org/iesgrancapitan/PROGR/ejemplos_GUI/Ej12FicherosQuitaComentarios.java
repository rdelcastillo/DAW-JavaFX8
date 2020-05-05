/**
 * Uso del control FileChooser.
 * 
 * Programa que quita los comentarios de un fichero java.
 * 
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Ej12FicherosQuitaComentarios extends Application {

  @Override
  public void start(Stage primaryStage) {

    // Advertimos y pedimos fichero
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Quita Comentarios Java");
    alert.setHeaderText("Esta aplicación quita los comentarios de un fichero java\n"
        + "y aunque guarda una copia del mismo con la extensión .old.java\n"
        + "el fichero original será modificado.");
    alert.setContentText("¿De verdad quieres realizar esta operación?");

    Optional<ButtonType> result = alert.showAndWait();

    // Si aceptan escogemos fichero
    if (result.get() != ButtonType.OK) { 
      System.out.println("Operación cancelada.");
      System.exit(1);
    }

    // Mediante un FileChooser escogemos un fichero .java (objeto de clase File)
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().addAll(   // filtramos por *.java
        new FileChooser.ExtensionFilter("Ficheros Java", "*.java")   );
    File fileToChange = fileChooser.showOpenDialog(primaryStage);

    // Si no han pulsado "Cancelar" procedemos...
    if (fileToChange == null) {
      System.out.println("Operación cancelada.");
      System.exit(2);
    }

    try {

      // Renombro fichero .java a .old.java
      String fileName = fileToChange.getAbsolutePath();
      String fileCopy = fileName.replace(".java", ".old.java");
      if (!fileToChange.renameTo(new File(fileCopy))) {
        // no se ha podido renombrar, ventana de error
        Alert error = new Alert(AlertType.ERROR);
        error.setTitle("Error en el proceso");
        error.setHeaderText(null);
        error.setContentText("Ha habido un error al renombrar " + fileName);
        error.showAndWait();
        System.exit(3);
      }

      // Leo del fichero renombrado y guardo en otro con el nombre original
      BufferedReader br = new BufferedReader(new FileReader(fileCopy)); 
      BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
      boolean estoyEnUnBloqueDeComentarios = false;     // necesaria para detectar bloques /* ... */

      // Leo cada línea del fichero origen y si no es un comentario la escribo en el destino
      String linea;
      while ((linea=br.readLine()) != null) {
        if (estoyEnUnBloqueDeComentarios) { 
          // Estoy dentro de un bloque /* ... */
          // solo tengo que comprobar si el bloque finaliza por acabar la línea con "*/"
          // no escribo nada en el fichero de salida en cualquier caso
          if (linea.trim().endsWith("*/")) {
            estoyEnUnBloqueDeComentarios = false;
          }
        } else if (linea.trim().startsWith("/*")) {     // ¿empieza un bloque de comentarios?
          estoyEnUnBloqueDeComentarios = true;          // activo el indicador del bloque /*...*/
        } else {
          // el único comentario posible aquí es con //
          // lo eliminamos y escribimos en el fichero si la línea no queda vacía
          boolean escribeLinea = true;
          if (linea.contains("//")) {     // ¿hay comentario con //?
            int dondeEmpiezaBarra2 = linea.indexOf("//");
            linea = linea.substring(0, dondeEmpiezaBarra2);
            // si la línea contiene únicamente espacios o está vacía, no la escribo
            if (linea.trim().equals("")) {
              escribeLinea = false;
            }
          }
          // escribimos línea sin comentarios
          if (escribeLinea) {
            bw.write(linea);
            bw.newLine();     // añado salto de línea
          }
        }
      }
      br.close();
      bw.close();
      
      // Proceso completado
      Alert end = new Alert(AlertType.INFORMATION);
      end.setTitle("Operación realizada");
      end.setHeaderText(null);
      end.setContentText("Se han quitado los comentarios a:\n" + fileName);
      end.showAndWait();

    } catch (Exception e) {
      Alert exception = new Alert(AlertType.ERROR);
      exception.setTitle("ERROR");
      exception.setHeaderText(null);
      exception.setContentText("Se ha producido un error y no se ha completado el proceso");  
      exception.setResizable(true);
      exception.getDialogPane().setPrefSize(400, 200);
      
      Label label = new Label("La excepción producida ha sido:");
      TextArea textArea = new TextArea(e.getMessage());
      textArea.setEditable(false);
      
      VBox expContent = new VBox(label, textArea);
     
      // Set expandable Exception into the dialog pane.
      exception.getDialogPane().setExpandableContent(expContent);
      exception.showAndWait();

    }
    
  }

  public static void main(String[] args) {
    launch(args);
  }
}
