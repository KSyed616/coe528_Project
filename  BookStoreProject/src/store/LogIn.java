package store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class LogIn
{
    public static void LogIn(String[] args){
        Scanner input = new Scanner (System.in);
        
        String userName = "admin";
        String password = "admin";
        
        System.out.println("Username:");
        userName = input.nextLine();
        
        System.out.println("Password:");
        password = input.nextLine();
        
        Customer LogIn = new Customer(userName, password);
        if(LogIn.checkPassword())
            System.out.println("logged in!");
        else
            System.out.println("The username and password are incorrect.");
        Owner LogIn = Owner(userName, password);
        if(LogIn.checkPassword())
            System.out.println("logged in!");
        else
            System.out.println("The username and password are incorrect.");
    }
    }

}