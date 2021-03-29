package store;

import java.io.*;
import java.util.Scanner; 

public class Owner{
    
    //instance variables for points and status. 
    private int point; 
    private String status; 
    private String userName; 
    private String password;
    private String filename;
    
    private String data = "Name Of The Wind 50\n"
            + "The Way Of Kings 45";
    
    
    File file;
    FileReader out; 
    FileWriter in; 
    BufferedWriter write;
    
    Scanner input = new Scanner(System.in);
    
    //constructor for Owner. 
    public Owner(String filename){
        this.filename = filename;
    }
    
    //method to set the username. 
    public void setUserName(String userName){
         this.userName = userName;
    }
    
    //method to return the username. 
    public String getUserName(){
        return userName;
    }
    
    //method to set password. 
    public void setPassword(String password){
        this.password = password;
    }
    
    //method to return the password. 
    public String getPassword(){
        return password;
    }
    
    //method to set points. 
    public void setPoint(int point){
        this.point = point;
    }
    
    //method to return the points. 
    public int getPoint(){
        return point;
    }
    
    //method to remove books. 
    public void removeBooks(){
    }
    
    //method to add books. 
    public void addBooks() throws IOException{
        file = new File(filename);
        in = new FileWriter(filename, true);
        out = new FileReader(filename);
        write = new BufferedWriter(in);
        
        if(file.length() == 0){
            write.write(data);
            write.newLine();
        }
        String name;
        System.out.println("What is the name of the book?"); 
        name = input.nextLine(); 
        
        double price; 
        
        System.out.println("What is the price of the book?");
        price = input.nextDouble();
            
        Book b = new Book(name, price);   
        write.write(""+b);  
        write.newLine();
        
        write.close();
    }
    
    //method to add customers. 
    public void addCust(){
    }
    
    //method to remove customers. 
    public void removeCust(){
    }
    
    //method change status. 
    public void changeStatus(){
    }
    
    //main method. 
    public static void main(String args[]) throws IOException{ 
        Owner o = new Owner("Book.txt");
        o.addBooks();
    }
}