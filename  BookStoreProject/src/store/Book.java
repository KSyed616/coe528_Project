package store;

import javafx.scene.control.CheckBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;

public class Book {
    
    //instance variables. 
    private SimpleStringProperty bookName; 
    private SimpleDoubleProperty price; 
    private CheckBox select;
    private static boolean checked;
    private static double total;
    
    //constructor for Book. 
    public Book(String bookName, double price){
        this.bookName = new SimpleStringProperty(bookName);
        this.price = new SimpleDoubleProperty(price);
        this.select = new CheckBox();
        
        select.selectedProperty().addListener(
        (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
         checked = select.isSelected();
         if (checked == true) {
            total += price;
         } else {
            total -= price;
         }
         
      });
    }
    public double getTotal() {
        return total;
    }
    
    //method to set the name. 
    public void setName(String bookName){
        this.bookName.set(bookName);
    }
    
    //method to return the name. 
    public String getName(){
        return bookName.get();
    }
    
    //method to set the price. 
    public void setPrice(double price){
        this.price.set(price);
    }
    
    //method to return the price. 
    public double getPrice(){
        return price.get();
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