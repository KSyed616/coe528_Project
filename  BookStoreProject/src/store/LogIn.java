package store;

import java.io.*;


public class LogIn{
    
    
    private String userName;
    private String password;
    private String status;
    private int point;
    private User u;
    
    public void setOwner(){
        u = new Owner("admin", "admim");
    }
    public void setCustomer(){
        u = new Customer(userName, password, status, point);
    }
    public void setState(User u){
        this.u = u;
    }
    public void setName(String userName){
        this.userName=userName;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public void getUser(User u){
        this.u = u;
    }
    public User getUser(){
        return u;
    }
}

    