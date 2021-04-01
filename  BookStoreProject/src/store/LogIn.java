package store;

import java.io.*;


public class LogIn{
    
    private String userName;
    private String password;
    private String status;
    private int point;
    private User u;
    
    public void setState(User u){
        this.u = u;
    }
    public void setName(String userName){
        this.userName=userName;
    }
    public String getName(){
        return userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }
}

    
