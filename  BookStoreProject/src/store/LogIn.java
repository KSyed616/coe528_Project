package store;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LogIn
{
    private String userName;
    private String password;
    private User u;
    
    public void setOwner(){
        u = new Owner("Book.txt");
    }
    public void setCustomer(){
        u = new Customer(userName, password);
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
    
    
    
    public static void main(String[] args){
       JPanel panel = new JPanel(); 
       JFrame frame = new JFrame();
       frame.setSize(350, 200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(panel);
        
       panel.setLayout(null);
       JLabel userNameLabel = new JLabel("userName:");
       userNameLabel.setBounds(10, 20, 80, 25);
       panel.add(userNameLabel);
       
       JTextField userText = new JTextField(20);
       userText.setBounds(100, 20, 165, 25);
       panel.add(userText);
       
       JLabel passwordLabel = new JLabel("password:");
       passwordLabel.setBounds(10, 50, 80, 25);
       panel.add(passwordLabel);
       
       JPasswordField passwordText = new JPasswordField();
       passwordText.setBounds(100, 50, 165, 25);
       panel.add(passwordText);
       
       frame.setVisible(true);
    }
    
    /*    
        System.out.println("Username:");
        userName = input.nextLine();
        
        System.out.println("Password:");
        password = input.nextLine();
        
        Customer LogIn = new Customer(userName, password);
        if(LogIn.checkPassword())
            System.out.println("logged in!");
        else
            System.out.println("The username and password are incorrect.");
        Owner LogIn = Owner(userName, password);
        if(LogIn.checkPassword())
            System.out.println("logged in!");
        else
            System.out.println("The username and password are incorrect.");
    }
    }/*