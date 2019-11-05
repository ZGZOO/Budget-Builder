
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhijiejennyxu
 */
public class EntryFrame extends JFrame {
    private CreateNewAccountFrame newAccountFrame;
    private ArrayList<User> userDatabase;

    public EntryFrame (){
        this.setTitle("Budget Builder");
        this.setSize(new Dimension(800,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel userInfoPanel = getUserInfoPanel();
        JPanel buttonPanel = getButtonPanel();

        this.add(userInfoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        userDatabase = new ArrayList<>(10);
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
        Dimension buttonSize = new Dimension(100,40);
        JButton loginButton = new JButton("Log In");
        loginButton.setMaximumSize(buttonSize);
        
        JButton createNewAccountButton = new JButton("Create a new account.");
        createNewAccountButton.setMaximumSize(buttonSize);
        
        GridLayout gridLayout = new GridLayout(2,1);
        buttonPanel.setLayout(gridLayout);
        buttonPanel.add(loginButton);
        buttonPanel.add(createNewAccountButton);
        
        createNewAccountButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                newAccountFrame = new CreateNewAccountFrame();
                newAccountFrame.pack();
                newAccountFrame.setLocationRelativeTo(null);
                newAccountFrame.setVisible(true);
            }
        });

//        loginButton.addActionListener(e -> {
//            String password = new String()
//        });
        
        return buttonPanel;
    }     
}
