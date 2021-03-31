package store;

import javafx.scene.control.CheckBox;

public class Book {
    
    //instance variables. 
    private String bookName; 
    private double price; 
    private CheckBox select;
    int test;
    
    //constructor for Book. 
    public Book(String bookName, double price){
        this.bookName = bookName;
        this.price = price;
        this.select = new CheckBox();
    }
    
    //method to set the name. 
    public void setName(String bookName){
        this.bookName = bookName;
    }
    
    //method to return the name. 
    public String getName(){
        return bookName;
    }
    
    //method to set the price. 
    public void setPrice(double price){
        this.price = price;
    }
    
    //method to return the price. 
    public double getPrice(){
        return price;
    }
    
    public CheckBox getSelect() {
        return select;
    }
    
    public void setSelect (CheckBox select) {
        this.select = select;
    }
    
    public String toString(){
        return bookName+"\t"+price;
    }
}