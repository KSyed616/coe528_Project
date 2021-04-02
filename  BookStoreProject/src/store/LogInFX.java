/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author syedk
 */
public class LogInFX extends Application {
    
    String userName;
    String password;
    
    public LogInFX(){
        
    }
    @Override
    public void start(Stage primaryStage) {
       GridPane root = new GridPane();
        Scene scene = new Scene(root, 300, 250);
        
        Button logIn = new Button();
        Label user = new Label("Username: ");
        Label pwd = new Label("Password: ");
        
        TextField userField = new TextField();
        PasswordField pwdField = new PasswordField();
        
        logIn.setText("Login");
        logIn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                userName = userField.getText();
                password = pwdField.getText();
                
                root.getChildren().clear();
                
                if(userName.equalsIgnoreCase("admin")){
                    OwnerFX o = new OwnerFX(userName, password);
                    o.start(primaryStage);
                }
                if(!userName.equalsIgnoreCase("admin")){
                    Customer cust = new Customer(userName, password, "Null", 0);
                    if(cust.checkCust(userName, password) == true){
                        CustomerFX c = new CustomerFX(userName, password);
                        c.makeCust(primaryStage, userName, password);
                    }
                }
            }
        });
        
        root.addRow(0, user, userField);
        root.addRow(1, pwd, pwdField);
        root.addRow(2, logIn);
        root.setStyle("-fx-base: rgba(60, 60, 60, 255);");
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
