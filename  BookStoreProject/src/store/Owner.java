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
    public Owner(){
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
        in = new FileWriter("Book.txt", true);
        out = new FileReader("Book.txt");
        write = new BufferedWriter(in);
        read = new BufferedReader(out);
        
        String thisLine = null;
        
        while((thisLine = read.readLine()) != null){       
            if(thisLine.equals(""+name+","+price)){
                write.write("");
            }
        }    
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
    public void addCust(){
    }
    
    //method to remove customers. 
    public void removeCust(){
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
        Owner o = new Owner();
        o.initializeBookStore();
    }  
}