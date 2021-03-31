package store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



public class LogIn implements ActionListener{
    private static JLabel userNameLabel;
    private static JTextField userNameText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    
    
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
       userNameLabel = new JLabel("userName:");
       userNameLabel.setBounds(10, 20, 80, 25);
       panel.add(userNameLabel);
       
       userNameText = new JTextField(20);
       userNameText.setBounds(100, 20, 165, 25);
       panel.add(userNameText);
       
       passwordLabel = new JLabel("password:");
       passwordLabel.setBounds(10, 50, 80, 25);
       panel.add(passwordLabel);
       
       passwordText = new JPasswordField();
       passwordText.setBounds(100, 50, 165, 25);
       panel.add(passwordText);
       
       button = new JButton ("LogIn");
       button.setBounds(10, 80, 80, 25);
       button.addActionListener(new LogIn());
       panel.add(button);
       
       success = new JLabel ("");
       success.setBounds(10, 110, 300, 25);
       panel.add(success);
       
       
       
       frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        userName = userNameText.getText();
        password = passwordText.getText();
        
        Customer LogIn = new Customer(userName, password);
        
        if(userName.equals("admin") && password.equals("admin"))
            success.setText("logged in!");
        else
            System.out.println("The username and password are incorrect.");
       
    }
}

    