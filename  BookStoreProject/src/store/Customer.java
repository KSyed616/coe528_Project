package store;

public class Customer extends User {
    
    //Instance variables.
    private int point;
    private String userName;
    private String password;
    
    //Constructor for Customer class.
    public Customer(String userName, String password){
        this.userName = userName;
        this.password = password; 
    }
    
    //method to buy book
    public void Buy (Book b){    
    }
    
    //method to duduct points. 
    public void deductPoints (int point) {       
        this.point = point;       
    }

    //method to check if password is correct. 
    boolean checkPassword() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void owner_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void customer_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}