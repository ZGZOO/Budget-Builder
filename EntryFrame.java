import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntryFrame extends JFrame {
    private NewAccountFrame newAccountFrame;
    private CategoryFrame categoryFrame;
    private BudgetProfileModel model;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    


    public EntryFrame() {
        this.setTitle("Budget Builder");
        this.setSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel userInfoPanel = getUserInfoPanel();
        JPanel buttonPanel = getButtonPanel();

        this.add(userInfoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        model = BudgetProfileModel.getSingleton();
        //FOR TESTING PURPOSE ONLY
        model.createNewProfile("Chris", "Gil");
    }

    private JPanel getUserInfoPanel() {
        JPanel userInfoPanel = new JPanel();
        userInfoPanel.setBackground(Color.gray);
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        usernameLabel.setFont(new Font("Century", Font.ITALIC, 16));
        passwordLabel.setFont(new Font("Century", Font.ITALIC, 16));
        usernameTextField = new JTextField(10);
        usernameTextField.setPreferredSize(new Dimension(40, 30));
        usernameTextField.setEditable(true);

        //JPasswordField is a subclass of JTestField
        passwordTextField = new JPasswordField(10);
        passwordTextField.setPreferredSize(new Dimension(10, 20));
        passwordTextField.setEditable(true);

        JPanel userNamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(0, 2);
        GridLayout userInfoLayout = new GridLayout(2, 0);
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


    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        Dimension buttonSize = new Dimension(100, 40);
        JButton loginButton = new JButton("Log In");
        loginButton.setMaximumSize(buttonSize);

        JButton createNewAccountButton = new JButton("Don't have your account?");
        createNewAccountButton.setMaximumSize(buttonSize);

        GridLayout gridLayout = new GridLayout(2, 1);
        buttonPanel.setLayout(gridLayout);
        buttonPanel.add(loginButton);
        buttonPanel.add(createNewAccountButton);

        createNewAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newAccountFrame = new NewAccountFrame(model);
                newAccountFrame.pack();
                newAccountFrame.setLocationRelativeTo(null);
                newAccountFrame.setVisible(true);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String getUsername = usernameTextField.getText();
                @SuppressWarnings("deprecation")
                String getPassword = passwordTextField.getText();

                BudgetProfile profile = model.findProfile(getUsername, getPassword);
                if (profile == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "No Profile Found. Please try again.");
                    System.out.println("No Profile Found. Please try again.");
                    usernameTextField.setText("");
                    passwordTextField.setText("");

                }
                //Represent it with a red log in button if log in unsuccessful
                else {
                    categoryFrame = new CategoryFrame(profile);
                    categoryFrame.pack();
                    categoryFrame.setLocationRelativeTo(null);
                    categoryFrame.setVisible(true);
                }
            }
        });
        
        return buttonPanel;
    }
}