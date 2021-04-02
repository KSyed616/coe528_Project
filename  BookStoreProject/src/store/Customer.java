package store;

import java.io.*; 
import javafx.stage.Stage;

public class Customer extends User {
    
    //Instance variables.
    private double point;
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
    public Customer(String userName, String password, String status, double point){
        this.userName = userName;
        this.password = password; 
        this.status = status;
        this.point = point;
    }
    
    //method to update points. 
    public void deductPoint (String user, double point) throws IOException {       
        this.point = this.point - point; 
        String lineSplit[];
        out = new FileReader("Customer.txt");
        BufferedReader read  = new BufferedReader(out);
            
        String line;
        String data = "";
            
        while((line  = read.readLine()) != null){
            lineSplit = null;
            lineSplit = line.split(",");
            userName = lineSplit[0];
            password = lineSplit[1];
            status = lineSplit[2];
            if(user.equals(userName)){
                data+=userName+","+password+","+status+","+this.point+"\r\n";
                System.out.println(data);
            }
            else{
                data+=line+"\r\n";
            }
        }
        read.close();
        in = new FileWriter("Customer.txt");
        in.write(data);
        in.close();
    }
    
    public void addPoint (String user, double point) throws IOException {       
        this.point = this.point + point; 
        String lineSplit[];
        out = new FileReader("Customer.txt");
        BufferedReader read  = new BufferedReader(out);
            
        String line;
        String data = "";
            
        while((line  = read.readLine()) != null){
            lineSplit = null;
            lineSplit = line.split(",");
            userName = lineSplit[0];
            password = lineSplit[1];
            status = lineSplit[2];
            if(user.equals(userName)){
                data+=userName+","+password+","+status+","+this.point+"\r\n";
                System.out.println(data);
            }
            else{
                data+=line+"\r\n";
            }
        }
        read.close();
        in = new FileWriter("Customer.txt");
        in.write(data);
        in.close();
    }
    
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setPoint(double point){
        this.point = point;
    }
    public double getPoint() {
        return point;
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
                
                if(user.equals(userName) && pass.equals(password)){
                    return true; 
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