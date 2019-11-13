
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhijiejennyxu
 */
public class CreateNewAccountFrame extends JFrame{
    private BudgetProfileModel budgetProfileModel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    
    public CreateNewAccountFrame(){
        this.setTitle("Create a new account");
        this.setMaximumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel userinfoPanel = getUserinfoPanel();
        JPanel buttonPanel = getButtonPanel();
        this.add(userinfoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private JPanel getUserinfoPanel(){
        JPanel userinfoPanel = new JPanel();
        userinfoPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        
        usernameTextField = new JTextField(10);
        usernameTextField.setPreferredSize(new Dimension(40,30));
        usernameTextField.setEditable(true);
        
        passwordTextField = new JTextField(10);
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
    
    private JPanel getButtonPanel(){
        JPanel buttonPanel = new JPanel();
        
        JButton nextButton = new JButton("NEXT");
        JButton backButton = new JButton("BACK");
        
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        Dimension buttonSize = new Dimension(100,40);
        backButton.setMaximumSize(buttonSize);
        nextButton.setMaximumSize(buttonSize);
        
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                EntryFrame entryFrame = new EntryFrame();
            }
        });
        
        nextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String username = usernameTextField.getText();
                String password = passwordTextField.getText();
                budgetProfileModel = new BudgetProfileModel();
                budgetProfileModel.createNewProfile(username, password);
                
                //for testing, delete later
                Iterator it = budgetProfileModel.iterator();
                if(it.hasNext()){
                    System.out.print(it.next().toString());
                }
                
                dispose();
                CategoryFrame categories = new CategoryFrame(budgetProfileModel);
            }
        });
        
        return buttonPanel;
    }
}
