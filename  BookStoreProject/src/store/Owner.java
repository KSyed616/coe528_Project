package store;

import java.io.*;
import java.util.Scanner; 

public class Owner extends User{
    
    //instance variables for points and status. 
    private int point; 
    private String status; 
    private String userName; 
    private String password;
    
    private String data = "Name Of The Wind,50\n"
            + "The Way Of Kings,45";    
    
    File file;
    FileReader out; 
    FileWriter in; 
    BufferedWriter write;
    BufferedReader read; 
    
    Scanner input = new Scanner(System.in);
    
    //constructor for Owner. 
    public Owner(String userName, String password){
        this.userName = userName;
        this.password = password; 
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
    public void removeBooks(String name, double price) throws IOException{        
        out = new FileReader("Book.txt");
        read = new BufferedReader(out);
        
        String thisLine;
        String data = "";
        String newLine;
        String replace = ""+name+","+price;
        while((thisLine = read.readLine()) != null){
            data += thisLine + "\r\n";
        }
        read.close();
        newLine = data.replaceAll(name, "DELETED");
        in = new FileWriter("Book.txt");
        in.write(newLine);
        in.close();
        
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
    //method to add books. 
    public void addBooks(String name, double price) throws IOException{       
        in = new FileWriter("Book.txt", true);
        out = new FileReader("Book.txt");
        write = new BufferedWriter(in);
        
        Book b = new Book(name, price);   
        write.write(""+b.getName()+","+b.getPrice());  
        write.newLine();
        
        write.close();
    }
    
    //method to add customers. 
    public void addCust(String userName, String password, String status, int point) throws IOException{
        Customer c = new Customer(userName, password, status, point);   
        in = new FileWriter("Customer.txt", true);
        out = new FileReader("Custmer.txt");
        write = new BufferedWriter(in);
        
        write.write(""+c.getUserName()+","+c.getPassword()+","+c.getPoints()+","+c.getStatus());  
        write.newLine();
        
        write.close();
    }
    
    //method to remove customers. 
    public void removeCust(String userName, String password, String status, int point) throws IOException{

        out = new FileReader("Customer.txt");
        read = new BufferedReader(out);
        
        String thisLine;
        String data = "";
        String newLine;
        while((thisLine = read.readLine()) != null){
            data += thisLine + "\r\n";
        }
        read.close();
        newLine = data.replaceAll(userName, "DELETED");
        in = new FileWriter("Customer.txt");
        in.write(newLine);
        in.close();
    }
    
    //method change status. 
    public void changeStatus(){
    }
    
    @Override
    public void owner_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void customer_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    //main method. 
    public static void main(String args[]) throws IOException{ 
        String userName = null;
        String password = null; 
        
        Owner o = new Owner(userName, password);
        o.initializeBookStore();
        o.removeBooks("Name Of The Wind", 50);
    }  
}