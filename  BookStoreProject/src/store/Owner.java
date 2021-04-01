package store;

import java.io.*;
import java.util.Scanner; 

public class Owner extends User{
    
    //instance variables for points and status. 
    private int Point; 
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
    
    File file2;
    FileReader out2; 
    FileWriter in2; 
    BufferedWriter write2;
    BufferedReader read2; 
    
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
    public void setPoint(int Point){
        this.Point = Point;
    }
    
    //method to return the points. 
    public int getPoint(){
        return Point;
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
    public void addCust(String userName, String password, String status, int Point) throws IOException{  
        in2 = new FileWriter("Customer.txt", true);
        out2 = new FileReader("Customer.txt");
        write2 = new BufferedWriter(in2);
        
        Customer c = new Customer(userName, password, status, Point); 
        write2.write(""+c.getUserName()+","+c.getPassword()+","+c.getStatus()+","+c.getPoint());  
        write2.newLine();
        
        write2.close();
    }
    
    //method to remove customers. 
    public void removeCust(String userName, String password, String status, int Point) throws IOException{

        out2 = new FileReader("Customer.txt");
        read2 = new BufferedReader(out2);
        
        String thisLine;
        String data = "";
        String newLine;
        while((thisLine = read2.readLine()) != null){
            data += thisLine + "\r\n";
        }
        read2.close();
        newLine = data.replaceAll(userName, "DELETED");
        in2 = new FileWriter("Customer.txt");
        in2.write(newLine);
        in2.close();
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
        o.addCust("Unnati Vinayak", "Dumbass", "Gold", 100);
    }  
}