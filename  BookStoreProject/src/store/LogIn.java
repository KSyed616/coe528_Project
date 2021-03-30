package store;

import java.util.Scanner;

public class LogIn{
    private String userName;
    private String password;
    private User u;
    
    public void setOwner(){
        u = new Owner(userName, password);
    }
    
    public void setCustomer(){        
        u = new Customer(userName, password);
    }
    
    public void setState(User u){
        this.u = u;
    }
      /*  
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
    }*/
}
