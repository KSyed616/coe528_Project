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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OwnerFX extends Application {
    String name;
    double price;
    
    FileReader out;
    FileReader out2;
    
    String userName;
    String password;
    
    int Point = 0;
    String status = null;
    Owner o = new Owner(userName, password);
    
    public OwnerFX(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
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
                    o.initializeBookStore();
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
                try {
                    Customer(primaryStage);
                } catch (IOException ex) {
                    Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        log.setLayoutY(150);
        log.setLayoutX(115);
        log.setPrefWidth(75);
        
        log.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                o.state_change(primaryStage);
            }
        });
        
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
                try {
                    o.removeBooks(b1.getName(), b1.getPrice());
                } catch (IOException ex) {
                    Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);
            }
        });
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
                if(!name.equals("DELETED")){
                    bookTable.getItems().add(new Book(name, price));
                }
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
    
    private void Customer(Stage primaryStage) throws IOException{
        Button add = new Button ("Add");    
        Button delete = new Button ("Delete");
        Button back = new Button ("Back");
        
        TextField user = new TextField();
        user.setPromptText("Username");
        
        TextField pass = new TextField();
        pass.setPromptText("Password");
        
        TableView <Customer> custTable = new TableView();
        
        TableColumn<Customer, String> column1 = new TableColumn<>("Username");
        column1.setCellValueFactory(new PropertyValueFactory<>("userName"));

        TableColumn<Customer, String> column2 = new TableColumn<>("Password");
        column2.setCellValueFactory(new PropertyValueFactory<>("password"));
        
        TableColumn<Customer, Integer> column3 = new TableColumn<>("Points");
        column3.setCellValueFactory(new PropertyValueFactory<>("Point"));
        
        TableColumn<Customer, String> column4 = new TableColumn<>("Status");
        column4.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        custTable.getColumns().add(column1);
        custTable.getColumns().add(column2);
        custTable.getColumns().add(column3);
        custTable.getColumns().add(column4);
        custTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                userName = user.getText();
                password = pass.getText();
                Point = 0;
                status = "S";
                try {
                    o.addCust(userName, password, status, Point);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                custTable.getItems().add(new Customer(userName, password, status, Point));
                user.setText("");
                pass.setText("");
            }
        });
        
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Customer c1;
                c1 = (Customer)custTable.getSelectionModel().getSelectedItem();
                custTable.getItems().removeAll(c1);
                try {
                    o.removeCust(c1.getUserName(), c1.getPassword(), c1.getStatus(), c1.getPoint());
                } catch (IOException ex) {
                    Logger.getLogger(OwnerFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);
            }
        });
        
        String [] lineSplit;
                
        try{
            out2 = new FileReader("Customer.txt");
            BufferedReader read  = new BufferedReader(out2);
            
            String line;
            
            while((line  = read.readLine()) != null){
                lineSplit = null;
                lineSplit = line.split(",");
                userName = lineSplit[0];
                password = lineSplit[1];
                status=lineSplit[2];
                Point=Integer.parseInt(lineSplit[3]);
                
                if(!userName.equals("DELETED")){
                    custTable.getItems().add(new Customer(userName, password, status, Point));
                }
            }
        } catch (FileNotFoundException ex) {
                    
        } catch (IOException ex) {
                    
        }
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(user, pass, add, delete, back);
        
        VBox vbox = new VBox(custTable);
        vbox.getChildren().add(hbox);
        
        Scene scene = new Scene(vbox);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();    
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
