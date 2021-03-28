package store;

public class Book {
    
    //instance variables. 
    private String bookName; 
    private double price; 
    
    //constructor for Book. 
    public Book(String bookName, double price){
        this.bookName = bookName;
        this.price = price;
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
}