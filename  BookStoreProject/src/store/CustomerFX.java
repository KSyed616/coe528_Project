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
    
    private String password;
    private String status;
    private double point;
    private String userName;    
    private String name;
    private double price;
    private double totalPrice = 0;
    private double totalPoints = 0;
    
    private ObservableList<Book> data = FXCollections.observableArrayList();
    
    FileReader out;
    
    Customer c;
    
    CustomerFX(String userName, String password){
        this.userName = userName;
        this.password = password;
        
    }
    public void makeCust(Stage primaryStage, String user, String pass){
        String [] lineSplit;
                
        try{
            out = new FileReader("Customer.txt");
            BufferedReader read  = new BufferedReader(out);
            
            String line;
            
            while((line  = read.readLine()) != null){
                lineSplit = null;
                lineSplit = line.split(",");
                userName = lineSplit[0];
                password = lineSplit[1];
                
                if(user.equals(userName) && pass.equals(password)){
                    status = lineSplit[2];
                    point = Double.parseDouble(lineSplit[3]);
                }
            }
        } catch (FileNotFoundException ex) {         
        } catch (IOException ex) {                    
        }
        start(primaryStage);
    }
    @Override
    public void start(Stage primaryStage) {
            
        c = new Customer(userName, password, status, point);
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
        
        bookTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        String [] lineSplit2;
                
        try{
            out = new FileReader("Book.txt");
            BufferedReader read  = new BufferedReader(out);
            
            String line;
            while((line  = read.readLine()) != null){
                lineSplit2 = null;
                lineSplit2 = line.split(",");
                name = lineSplit2[0];
                price = Double.parseDouble(lineSplit2[1]);
                if(!name.equals("DELETED")){
                    bookTable.getItems().add(new Book(name, price));
                    data.add(new Book(name, price));
                }
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
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                c.state_change(primaryStage);
            }
        });
        
        buy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {             
                for (Book bean : data){
                    totalPrice = bean.getTotal();
                } 
                totalPoints = totalPrice*10;
                Book b1 = new Book(name, price);
                     
                for (int i = 0; i < b1.getCheckedBooks().size(); i++) {
                    try {
                        c.Buy(""+b1.getCheckedBooks().get(i));
                    } catch (IOException ex) {
                        Logger.getLogger(CustomerFX.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                root.getChildren().clear();
                try {
                    Cost(primaryStage);
                } catch (IOException ex) {
                    Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
        });
        
        redeemPoints.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (Book bean : data){
                    totalPrice = bean.getTotal();
                } 
                totalPoints = totalPrice * 100;
                root.getChildren().clear();
                try {
                    PointCost(primaryStage);
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

        //bookTable.getSelectionModel().select(Book(name,price));
        
        root.setStyle("-fx-base: rgba(60, 60, 60, 255);");
        
        primaryStage.setScene(new Scene(root, 375, 250));
        primaryStage.show();
    }
    
    private void Cost(Stage primaryStage) throws IOException{
        
        Pane root = new Pane();
        
        Button logout = new Button ("Logout");
        c.addPoint(userName, totalPoints);
        Text totalCost = new Text(30, 50, "Total Cost: " + totalPrice + ".");
        totalCost.setFont(new Font(12));
        totalCost.setY(20);
        
        Text pAndS = new Text(30, 50, "Points: " + c.getPoint() + ", Status: " + c.getStatus());
        pAndS.setFont(new Font(12));
        pAndS.setY(40);
        
        logout.setLayoutY(50);
        logout.setLayoutX(65);
        logout.setPrefWidth(75);  
        
        /*Button back = new Button ("Back");
        back.setLayoutY(50);
        back.setLayoutX(150);
        back.setPrefWidth(75); 
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);
            }
        }); 
        root.getChildren().add(back);*/
        
        root.getChildren().add(totalCost);
        root.getChildren().add(pAndS);
        root.getChildren().add(logout);
        
        
        primaryStage.setScene(new Scene(root, 330, 250));
        primaryStage.show();
        
        root.setStyle("-fx-base: rgba(60, 60, 60, 255);");
        
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                c.state_change(primaryStage);
            }
        });       
    }
    
    private void PointCost(Stage primaryStage) throws IOException{
        
        Pane root = new Pane();
        
        if(totalPoints<c.getPoint()){
            Button logout = new Button ("Logout");
            c.deductPoint(userName, totalPoints);
            Text totalCost = new Text(30, 50, "Total points redeemed: " + totalPoints + ".");

            totalCost.setFont(new Font(12));
            totalCost.setY(20);

            Text pAndS = new Text(30, 50, "Points: " + c.getPoint() + ", Status: " + c.getStatus());
            pAndS.setFont(new Font(12));
            pAndS.setY(40);

            logout.setLayoutY(50);
            logout.setLayoutX(65);
            logout.setPrefWidth(75);  

            root.getChildren().add(totalCost);
            root.getChildren().add(pAndS);
            root.getChildren().add(logout);


            primaryStage.setScene(new Scene(root, 330, 250));
            primaryStage.show();

            root.setStyle("-fx-base: rgba(60, 60, 60, 255);");

            logout.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    root.getChildren().clear();
                    c.state_change(primaryStage);
                }
            });       
        }
        else{
            Button logout = new Button ("Logout");
            Text noPoint = new Text(30, 50, "Not enough points to complete transaction");

            noPoint.setFont(new Font(12));
            noPoint.setY(20);

            logout.setLayoutY(50);
            logout.setLayoutX(65);
            logout.setPrefWidth(75);  

            root.getChildren().add(noPoint);
            root.getChildren().add(logout);


            primaryStage.setScene(new Scene(root, 330, 250));
            primaryStage.show();

            root.setStyle("-fx-base: rgba(60, 60, 60, 255);");

            logout.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    root.getChildren().clear();
                    c.state_change(primaryStage);
                }
            });
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
