/**
 * Los eventos en la API JavaFX son parte importante en el desarrollo de una aplicación, un evento 
 * se produce cuando el usuario interactúa con la aplicación, por ejemplo, al hacer clic sobre un botón, 
 * al mover el ratón sobre algún control, al presionar una tecla, etc.
 * 
 * La clase base que representa los eventos es javafx.event.Event todas las subclases de la misma 
 * también representan eventos, algunas de estas clases son:
 * 
 * - MouseEvent: Para los eventos producidos por la interacción del ratón. 
 * - KeyEvent: Para los eventos producidos por el teclado. 
 * - WindowEvent: Para los eventos producidos por la ventana, por ejemplo, mostrarla u ocultarla.
 * 
 * Para controlar un evento en JavaFX disponemos de los manejadores de eventos y los filtros de eventos,
 * cada uno de estos controladores poseen estas propiedades:
 * 
 * - Target: El nodo en donde se produjo el evento.
 * - Source: La fuente que genera el evento.
 * - Type: El tipo de evento producido.
 * 
 * Para responder a un evento requerimos un objeto que implemente la interface EventHandler.
 * 
 * Más información:
 * 
 * http://acodigo.blogspot.com/2017/06/eventos-en-javafx.html
 * http://www.developandsys.es/manejo-de-eventos-en-javafx/
 * 
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.eventos;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Eventos01MouseEvent extends Application {

  int numEventHandler = 0;

  @Override
  public void start(Stage primaryStage) {

    // Escenario para experimentar

    Label label = new Label("Soy un Label");
    TextField textField = new TextField("Soy un TextField");
    TextArea textArea = new TextArea();
    Button button1 = new Button("Botón 1");
    Button button2 = new Button("Botón 2");
    Button button3 = new Button("Borra TextField");

    HBox hBox = new HBox(175, button1, button2, button3);

    VBox root = new VBox(label, textField, textArea, hBox);
    root.setPadding(new Insets(10));

    Scene scene = new Scene(root);
    primaryStage.setScene(scene);

    /* La base de la captura y funcionalidad de los eventos son los objetos de tipo EventHandler.
     *  
     * En su definición se indica el tipo de evento que se maneja y se sobrescribe el método 
     * handle(), que recibe el evento producido del que se podrá extraer el source, target y type.
     */

    EventHandler<MouseEvent> handler1 = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent e) {
        manejador(e, "handler1 (addEventHandler)", textArea);
      }
    };

    // El manejador anterior podríamos haberlo implementado usando expresiones lambda.

    EventHandler<MouseEvent> handler2 = e -> manejador(e,"handler2 (addEventFilter)", textArea);

    /*
     * El proceso de generación de un evento tiene varias fases:
     * 
     * 1. Construcción de la ruta: se crea la ruta que seguirá el evento, iniciándose en la ventana 
     *    (Stage) y terminando en el objeto donde se origina el evento.
     * 
     * 2. Fase de captura: el nodo raíz distribuye el evento, dicho evento recorre la jerarquía
     *    desde la parte superior, si alguno de los nodos ha registrado un manejador de eventos con filtro (addEventFilter) 
     *    se invoca, esto ocurre hasta llegar a la parte inferior del recorrido que termina con 
     *    el objeto que originó el evento.
     *    
     * 3. Fase de propagación: ocurre el proceso inverso, el evento se distribuye iniciando el 
     *    recorrido en el origen del evento hasta llegar al nodo raíz, si algún nodo ha registrado 
     *    un manejador de eventos con addEventHandler, este será invocado, el proceso termina al llegar 
     *    al nodo raíz.   
     */

    // Registramos manejadores de eventos
    
    button1.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    button2.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    button2.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2); // MAL USADO, no hacedlo así
    button3.setOnAction(e -> { 
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setContentText("Vamos a borrar 'TextArea'.\n\nLee lo que pone antes de borrarlo.");
      alert.setHeaderText(null);
      alert.showAndWait();
      textArea.clear();
    });
    
    label.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    label.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);
    
    textField.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    textField.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);
    
    textArea.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    textArea.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);
    
    scene.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    scene.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);

    primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, handler1);
    primaryStage.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);
    
    // Mostramos escenario
    
    primaryStage.setTitle("Experimentos con eventos");
    primaryStage.show();
  }

  /**
   * Método auxiliar para el manejador de eventos, el objetivo es ahorrar código.
   * @param e: evento capturado, o MouseEvent o ActionEvent
   * @param registro: cómo se ha registrado el namejador.
   * @param textArea: donde escribimos la salida.
   */
  protected void manejador(Event e, String registro, TextArea log) {
    numEventHandler++;
    log.appendText("Soy un manejador de eventos registrado con " + registro + "\n");
    log.appendText("Tipo de evento: " + e.getEventType().getName() + "\n");
    log.appendText("Source: " + e.getSource().getClass().getSimpleName() + "\n");
    log.appendText("Target: " + e.getTarget() + "\n");
    log.appendText("Ocurrencia número: " + numEventHandler + "\n");
    log.appendText("------------------------------------------\n");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
