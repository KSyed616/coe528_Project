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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

public class CustomerFX extends Application{        
    
    private String userName = "Jane";
    private String password;
    private String status;
    private int point;
    
    private String name;
    private double price;
    
    private double totalPrice = 0;
    
    final ObservableList<Book> data = FXCollections.observableArrayList();
    
    FileReader out;
    
    Customer c = new Customer(userName, password, status, point);
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        
        Button buy = new Button ("Buy");    
        Button redeemPoints = new Button ("Redeem Points and Buy");
        Button logout = new Button ("Logout");
        
        Text welcome = new Text(30, 50, "Welcome " + c.getUserName() + ". You have " + c.getPoint() + " Points. Your Status is " + c.getStatus() +".");
        welcome.setFont(new Font(12));
        welcome.setY(20);
        
        try {
            c.initializeBookStore();
        } catch (IOException ex) {
            Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        TableView <Book> bookTable = new TableView();
        TableColumn<Book, String> column1 = new TableColumn<>("Book Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Book, String> column2 = new TableColumn<>("Book Price");
        column2.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableColumn column3 = new TableColumn<>("Select");
        column3.setCellValueFactory(new PropertyValueFactory<>("select"));
        
        String [] lineSplit;
                
        try{
            out = new FileReader("Book.txt");
            BufferedReader read  = new BufferedReader(out);
            
            String line;
            while((line  = read.readLine()) != null){
                lineSplit = null;
                lineSplit = line.split(",");
                name = lineSplit[0];
                price = Double.parseDouble(lineSplit[1]);
                bookTable.getItems().add(new Book(name, price));
                data.add(new Book(name, price));
            }
        } catch (FileNotFoundException ex) {
                    
        } catch (IOException ex) {
                    
        }
        bookTable.getColumns().add(column1);
        bookTable.getColumns().add(column2);
        bookTable.getColumns().add(column3);
        
        bookTable.setLayoutY(30);
        bookTable.setLayoutX(40);
        bookTable.setPrefHeight(150);
        
        buy.setLayoutY(200);
        buy.setLayoutX(0);
        buy.setPrefWidth(75); 
        
        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Book bean : data){
                    totalPrice = bean.getTotal();
                } 
                root.getChildren().clear();
                try {
                    Cost(primaryStage);
                } catch (IOException ex) {
                    Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        redeemPoints.setLayoutY(200);
        redeemPoints.setLayoutX(85);
        redeemPoints.setPrefWidth(160);    
        
        logout.setLayoutY(200);
        logout.setLayoutX(255);
        logout.setPrefWidth(75);  
        
        root.getChildren().add(buy);
        root.getChildren().add(redeemPoints);
        root.getChildren().add(logout);
        root.getChildren().add(welcome);
        root.getChildren().add(bookTable);
        root.setStyle("-fx-base: rgba(60, 60, 60, 255);");
        
        primaryStage.setScene(new Scene(root, 330, 250));
        primaryStage.show();
    }
    
    private void Cost(Stage primaryStage) throws IOException{
        
        Pane root = new Pane();
        
        Button logout = new Button ("Logout");
        
        Text totalCost = new Text(30, 50, "Total Cost: " + totalPrice + ".");
        totalCost.setFont(new Font(12));
        totalCost.setY(20);
        
        Text pAndS = new Text(30, 50, "Points: " + c.getPoint() + ", Status: " + c.getStatus());
        pAndS.setFont(new Font(12));
        pAndS.setY(40);
        
        logout.setLayoutY(50);
        logout.setLayoutX(85);
        logout.setPrefWidth(75);  
        
        root.getChildren().add(totalCost);
        root.getChildren().add(pAndS);
        root.getChildren().add(logout);
        root.setStyle("-fx-base: rgba(60, 60, 60, 255);");
        
        primaryStage.setScene(new Scene(root, 330, 250));
        primaryStage.show();
        
    } 
    
    public static void main(String[] args) {
        launch(args);
    }
}
