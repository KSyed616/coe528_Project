package store;

public class Book {
    private String bookName; 
    private double price; 
    
    public Book(String bookName, double price){
        this.bookName = bookName;
        this.price = price;
    }
    public void setName(String bookName){
        this.bookName = bookName;
    }
    
    public String getName(){
        return bookName;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
}