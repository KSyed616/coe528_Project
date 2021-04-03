package store;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogInFX extends Application {
    
    String userName;
    String password;
    
    public LogInFX(){
        
    }
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(15, 25, 25, 25));
        
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
        
        Text scenetitle = new Text("Welcome to the Bookstore App");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        
        root.add(scenetitle, 0, 0, 2, 1);
        root.addRow(1, user, userField);
        root.addRow(2, pwd, pwdField);
        root.addRow(3, logIn);
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}