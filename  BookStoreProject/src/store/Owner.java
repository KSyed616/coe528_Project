package store;

import java.io.*;

public class Owner{
    
    private int point; 
    private String status; 
    
    private String data = "Name Of The Wind 50\n"
            + "The Way Of Kings 45";

    private String userName; 
    private String password;
    
    FileReader out; 
    BufferedReader read = new BufferedReader(out);
    
    FileWriter in; 
    BufferedWriter write = new BufferedWriter(in);

    public Owner() throws IOException {
        this.out = new FileReader("Book.txt");
        this.in = new FileWriter("Book.txt", true);
    }
    
    public void setUserName(String userName){
         this.userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPoint(int point){
        this.point = point;
    }
    
    public int getPoint(){
        return point;
    }

    public void removeBooks(){
    
    }
    
    public void addBooks() throws IOException{
        if(read.readLine() == null){
            write.write(data);  
        }
    }
    
    public void addCust(){
    }
    
    public void removeCust(){
    }
   
    public void changeStatus(){
    }
    
    public static void main(String args[]){
    
    }
}