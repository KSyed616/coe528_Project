package store;

import java.io.*; 
import javafx.stage.Stage;

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
    boolean checkCust(String user, String pass){
        String [] lineSplit;
                
        try{
            out = new FileReader("Customer.txt");
            BufferedReader read  = new BufferedReader(out);
            
            String line;
            
            while((line  = read.readLine()) != null){
                lineSplit = null;
                lineSplit = line.split(",");
                userName = lineSplit[0];
                password = lineSplit[1];
                
                if(user == userName && pass == password){
                    return true; 
                }
                else{
                    return false; 
                }
            }
        } catch (FileNotFoundException ex) {
                    
        } catch (IOException ex) {                    
        }  
        return false; 
    }

    @Override
    public void state_change(Stage primaryStage) {
        LogInFX l = new LogInFX();
        l.start(primaryStage);
    }
}