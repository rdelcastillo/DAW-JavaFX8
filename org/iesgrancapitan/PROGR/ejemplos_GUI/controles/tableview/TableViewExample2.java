/**
 * The JavaFX TableView enables you to display table views inside your JavaFX applications. 
 * 
 * The JavaFX TableView is represented by the class javafx.scene.control.TableView 
 * 
 * See more at http://tutorials.jenkov.com/javafx/tableview.html
 */

package org.iesgrancapitan.PROGR.ejemplos_GUI.controles.tableview;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewExample2 extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void start(Stage primaryStage) {

    TableView<Customer> tableView = new TableView<Customer>();

    TableColumn<Customer, String> customerId = new TableColumn<>("Customer No");
    TableColumn<Customer, String> name       = new TableColumn<>("Name");
    TableColumn<Customer, String> firstName  = new TableColumn<>("First Name");
    TableColumn<Customer, String> lastName   = new TableColumn<>("Last Name");
    TableColumn<Customer, String> email      = new TableColumn<>("email");

    // The JavaFX TableView supports nesting of the TableColumn instances you add to it. 
    name     .getColumns().addAll(firstName, lastName);
    tableView.getColumns().addAll(customerId, name, email);

    customerId.setCellValueFactory(new PropertyValueFactory<>("customerNo"));
    firstName .setCellValueFactory(new PropertyValueFactory<>("firstName"));
    lastName  .setCellValueFactory(new PropertyValueFactory<>("lastName"));
    email     .setCellValueFactory(new PropertyValueFactory<>("email"));

    tableView.getItems().add(new Customer("007", "Jane", "Deer", "jane@email.net"));
    tableView.getItems().add(new Customer("006", "John", "Doe", "john@email.net"));
    tableView.getItems().add(new Customer("008", "Mack", "Alamo", "mack@email.net"));  

    // Buttons to experiment
    Button button1 = new Button("Hide email");
    Button button2 = new Button("Sort by customer");
    Button button3 = new Button("Sort by name");
    Button button4 = new Button("Reorder");

    // The JavaFX TableView enaables you to hide a TableColumn
    button1.setOnAction(e -> {
      email.setVisible(!email.isVisible());     // if visible is true, now is false, and vice versa
      button1.setText((email.isVisible() ? "Hide" : "Show") + " email");
      button4.setDisable(!email.isVisible());   // if email is not visible this button is disabled
    }); 

    // The JavaFX TableView enables you to sort the rows in the TableView
    button2.setOnAction(e -> {
      customerId.setSortType(TableColumn.SortType.ASCENDING);   // sort type
      tableView.getSortOrder().setAll(customerId);
      tableView.sort();
    });

    button3.setOnAction(e -> {
      firstName.setSortType(TableColumn.SortType.ASCENDING);
      lastName.setSortType(TableColumn.SortType.ASCENDING);
      tableView.getSortOrder().setAll(lastName, firstName);
      tableView.sort();
    });

    // The JavaFX TableView fires a sort event just before sorting of the items is carried out
    tableView.setOnSort(e -> System.out.println("Sorting items"));

    // The JavaFX TableView enables you to reorder its columns
    button4.setOnAction(e -> {
      tableView.getColumns().add(
          tableView.getColumns().remove(0));
    });

    /*
     * The TableView class not only renders tabular data, but it also provides capabilities to edit it. 
     * 
     * Use the setEditable method to enable editing of the table content.
     * 
     * Use the setCellFactory method to reimplement the table cell as a text field with the help of 
     * the TextFieldTableCell class. 
     * 
     * The setOnEditCommit method processes editing and assigns the updated value to the corresponding 
     * table cell.
     * 
     * See more at https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
     * 
     */
    tableView.setEditable(true);
    email.setCellFactory(TextFieldTableCell.forTableColumn());
    email.setOnEditCommit(e -> {
      e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue());
    });

    // Layout, scene and stage
    HBox hBox = new HBox(10, button1, button2, button3, button4);
    hBox.setAlignment(Pos.CENTER);

    VBox root = new VBox(10, tableView, hBox);
    root.setPadding(new Insets(10));

    Scene scene = new Scene(root, 450, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("TableView Example");
    primaryStage.show();
  }

}