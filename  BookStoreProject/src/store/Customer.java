package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Customer extends User {
    
    //Instance variables.
    private int Point;
    private String userName;
    private String password;
    private String status;
    
    private String data = "Name Of The Wind,50\n"
            + "The Way Of Kings,45";   
    
    File file;
    FileReader out; 
    FileWriter in; 
    BufferedWriter write;
    BufferedReader read; 
    
    //Constructor for Customer class.
    public Customer(String userName, String password, String status, int Point){
        this.userName = userName;
        this.password = password; 
        this.status = status;
        this.Point = Point;
    }
    
    //method to buy book
    public void Buy (Book b){    
    }
    
    //method to update points. 
    public void updatePoint (int Point) {       
        this.Point = Point;  
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public int getPoint() {
        return Point;
    }
    
    public String getStatus () {
        return status;
    }

    public void initializeBookStore() throws IOException{
        file = new File("Book.txt");
        in = new FileWriter("Book.txt", true);
        write = new BufferedWriter(in);
       
        if(file.length() == 0){
            write.write(data);
            write.newLine();
            write.close();
        }
    }
    //method to check if password is correct. 
    boolean checkPassword() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void owner_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void customer_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}