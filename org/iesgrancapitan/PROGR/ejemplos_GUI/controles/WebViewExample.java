/**
 * The JavaFX WebView (javafx.scene.web.WebView) component is capable of showing web pages 
 * (HTML, CSS, SVG, JavaScript) inside a JavaFX application. 
 * 
 * As such, the JavaFX WebView is a mini browser. The WebView component is very handy when you need to show 
 * documentation (e.g. Help texts), news, blog posts or other content which needs to be downloaded from a 
 * web server at runtime.
 * 
 * The JavaFX WebView uses the WebKit open source browser engine internally to render the web pages. 
 * 
 * See more at http://tutorials.jenkov.com/javafx/webview.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.controles;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewExample extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {

    // creamos y configuramos un WebView
    WebView webView = new WebView();
    webView.setMaxSize(750, 700);

    // campo para introducir la URL
    TextField entry = new TextField();
    entry.setMaxWidth(750);

    // si pulsamos Intro abrimos la URL
    entry.setOnKeyTyped(e -> {
      String url;
      if(e.getCharacter().equals("\r"))
      {
        url = entry.getText();
        if(!url.startsWith("http"))
        {
          url = "http://" + url;
        }
        webView.getEngine().load(url);
        entry.setText(webView.getEngine().getLocation());
      }
    });

    VBox root = new VBox(20);
    root.setAlignment(Pos.CENTER);
    root.setMaxSize(1024,768);
    root.getChildren().addAll(new Label("Introduce una URL y pulsa Intro..."), entry, webView);
    
    // Botones de navegación
    
    Button prev = new Button("⏪");
    prev.setOnAction(e -> {
      webView.getEngine().getHistory().go(-1);
      entry.setText(webView.getEngine().getLocation());
    });
    
    Button zoom1 = new Button("Zoom +");
    zoom1.setOnAction(e -> webView.setZoom(webView.getZoom() + 0.10));
    
    Button zoom2 = new Button("Zoom -");
    zoom2.setOnAction(e -> webView.setZoom(webView.getZoom() - 0.10));
    
    Button next = new Button("⏩");
    next.setOnAction(e -> {
      webView.getEngine().getHistory().go(1);
      entry.setText(webView.getEngine().getLocation());
    });
    
    HBox botones = new HBox(20, prev, zoom1, zoom2, next);
    botones.setAlignment(Pos.CENTER);
    root.getChildren().add(botones);
    
    // Escena y escenario
    
    Scene scene = new Scene(root, 800, 750);

    stage.setScene(scene);
    stage.setTitle("Mi navegador");
    stage.show();
  }
}
