
import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhijiejennyxu
 */
public class EntryFrame extends JFrame{
    
    public EntryFrame (){
        this.setTitle("Budget Builder");
        this.setMaximumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel userinfoPanel = getUserinfoPanel();
        JPanel buttonPanel = getButtonPanel();
          
        this.add(userinfoPanel, BorderLayout.CENTER);   
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel getButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.DARK_GRAY);
        Dimension buttonSize = new Dimension(100,40);
        JButton loginButton = new JButton("Log In");
        loginButton.setMaximumSize(buttonSize);
        
        JButton createNewAccountButton = new JButton("Create a new account.");
        createNewAccountButton.setMaximumSize(buttonSize);
        
        GridLayout gridLayout = new GridLayout(0,1);
        buttonPanel.setLayout(gridLayout);
        buttonPanel.add(loginButton);
        buttonPanel.add(createNewAccountButton);
        
        return buttonPanel;
    }
    
    private JPanel getUserinfoPanel(){
        JPanel userinfoPanel = new JPanel();
        userinfoPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        
        JTextField usernameTextField = new JTextField(10);
        usernameTextField.setPreferredSize(new Dimension(40,30));
        usernameTextField.setEditable(true);
        
        JTextField passwordTextField = new JTextField(10);
        passwordTextField.setPreferredSize(new Dimension(10,20));
        passwordTextField.setEditable(true);
        
        GridLayout gridLayout = new GridLayout(0,2);
        userinfoPanel.setLayout(gridLayout);
        userinfoPanel.add(usernameLabel);
        userinfoPanel.add(usernameTextField);
        userinfoPanel.add(passwordLabel);
        userinfoPanel.add(passwordTextField);
        
        return userinfoPanel;
    }
    
}
