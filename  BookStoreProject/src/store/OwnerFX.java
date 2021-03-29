/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author syedk
 */
public class OwnerFX extends Application {
    String name;
    double price;
    
    FileReader out;
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Button books = new Button("Books");
        Button cust = new Button("Customers");
        Button log = new Button("Logout");
        
        books.setLayoutY(50);
        books.setLayoutX(115);
        books.setPrefWidth(75);
        
        books.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                try {
                    BooksFX(primaryStage);
                } catch (IOException ex) {
                    Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
        
        cust.setLayoutY(100);
        cust.setLayoutX(115);
        cust.setPrefWidth(75);
        
        cust.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                //Customer(primaryStage);
            }
            
        });
        
        log.setLayoutY(150);
        log.setLayoutX(115);
        log.setPrefWidth(75);
        
        root.getChildren().add(books);
        root.getChildren().add(cust);
        root.getChildren().add(log);
        root.setStyle("-fx-base: rgba(60, 60, 60, 255);");
        
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
    private void BooksFX(Stage primaryStage) throws IOException{
        Button add = new Button("Add");
        Button delete = new Button("Delete");
        Button back = new Button("Back");
        
        TextField bookName = new TextField();
        bookName.setPromptText("Name of Book");
        
        TextField bookPrice = new TextField();
        bookPrice.setPromptText("Price of Book");
         
        TableView bookTable = new TableView();
        TableColumn<Book, String> column1 = new TableColumn<>("Book Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Book, String> column2 = new TableColumn<>("Book Price");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        bookTable.getColumns().add(column1);
        bookTable.getColumns().add(column2);
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                name = bookName.getText();
                price = Double.parseDouble(bookPrice.getText());
                Owner o = new Owner();
                try {
                    o.addBooks(name, price);
                } catch (IOException ex) {
                    
                }
                bookTable.getItems().add(new Book(name, price));
            }
        });
        
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Book b1;
                b1 = (Book)bookTable.getSelectionModel().getSelectedItem();
                bookTable.getItems().removeAll(b1);
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);
            }
        });
        String [] lineSplit;
                
        try {
            out = new FileReader("Book.txt");
            BufferedReader read  = new BufferedReader(out);
            String line;
            while((line  = read.readLine()) != null){
                lineSplit = null;
                lineSplit = line.split(",");
                name = lineSplit[0];
                price = Double.parseDouble(lineSplit[1]);
                bookTable.getItems().add(new Book(name, price));
            }
        } catch (FileNotFoundException ex) {
                    
        } catch (IOException ex) {
                    
        }
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(bookName, bookPrice, add, delete, back);
        
        VBox vbox = new VBox(bookTable);
        vbox.getChildren().add(hbox);
        
        Scene scene = new Scene(vbox);
        
        primaryStage.setScene(scene);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
