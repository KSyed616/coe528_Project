package store;

public class Owner {
    
    private int point; 
    private String status; 
    
    private String userName; 
    private String password;
    
     public void setUserName(String userName){
         this.userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPoint(int point){
        this.point = point;
    }
    
    public int getPoint(){
        return point;
    }
    
    public void removeBooks(){
    }
    
    public void addBooks(){
    }
    
    public void addCust(){
    }
    
    public void removeCust(){
    }
   
    public void changeStatus(){
    }
}
