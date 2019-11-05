
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private EntryFrame entryFrame;
    
    public CreateNewAccountFrame(){
        this.setTitle("Create a new account");
        this.setMaximumSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel userinfoPanel = getUserinfoPanel();
        JPanel buttonPanel = getButtonPanel();
        this.add(userinfoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
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
    
    private JPanel getButtonPanel(){
        JPanel buttonPanel = new JPanel();
        
        JButton nextButton = new JButton("Create");
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
                entryFrame = new EntryFrame();
                entryFrame.pack();
                entryFrame.setLocationRelativeTo(null);
                entryFrame.setVisible(true);
            }
        });
        
        return buttonPanel;
    }
}
