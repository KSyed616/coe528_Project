package store;

public class Customer extends User {
    private int point;
    
    private String userName;
    private String password;
    
    public Customer(String userName, String password){
        this.userName = userName;
        this.password = password; 
    }
    
    public void Buy (Book b){    
    }
    
    public void deductPoints (int point) {       
        this.point = point;       
    }

    boolean checkPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void owner_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void customer_change(LogIn l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}