
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

public class NewAccountFrame extends JFrame{
    private EntryFrame entryFrame;
    
    public NewAccountFrame(){
        this.setTitle("Create a new account");
        this.setPreferredSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel userInfoPanel = getUserInfoPanel();
        JPanel buttonPanel = getButtonPanel();
        this.add(userInfoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private JPanel getUserInfoPanel(){
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");

        JTextField usernameTextField = new JTextField(10);
        usernameTextField.setPreferredSize(new Dimension(40,30));
        usernameTextField.setEditable(true);

        //JPasswordField is a subclass of JTestField
        JPasswordField passwordTextField = new JPasswordField(10);
        passwordTextField.setPreferredSize(new Dimension(10,20));
//        passwordTextField.setEditable(true);

        JPanel userNamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(0,2);
        GridLayout userInfoLayout = new GridLayout(2,0);
        userNamePanel.setLayout(gridLayout);
        passwordPanel.setLayout(gridLayout);

        userNamePanel.add(usernameLabel);
        userNamePanel.add(usernameTextField);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);

        userInfoPanel.setLayout(userInfoLayout);
        userInfoPanel.add(userNamePanel);
        userInfoPanel.add(passwordPanel);
        
        return userInfoPanel;
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
