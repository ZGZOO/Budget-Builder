import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CategoryFrame extends JFrame {
//    private JFrame incomeFrame;
//    private JFrame utilityFrame;
//    private JFrame savingFrame;
//    private JFrame spendingGraphFrame;
//    public static BudgetProfile budgetProfile;
//    private BudgetAnalysis analysis;
//
//    private BudgetProfileModel model;
//    private BudgetProfile profile;
    private JFrame incomeFrame;
    private JFrame utilityFrame;
    private JFrame savingFrame;
    private JFrame spendingGraphFrame;
    public static BudgetProfile budgetProfile;
    private BudgetAnalysis analysis;
    

    public CategoryFrame(BudgetProfile budgetProfile) throws HeadlessException {
        this.budgetProfile = budgetProfile;
        this.analysis = new BudgetAnalysis(budgetProfile);
        this.setTitle("Budget Builder");
        this.setPreferredSize(new Dimension(1200, 900));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JPanel title = getTitlePanel();
        JPanel choicesPanel = getChoicesPanel();
        JPanel buttonsPanel = getButtonsPanel();
        
        this.add(title, BorderLayout.NORTH);
        this.add(choicesPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }


    public JPanel getTitlePanel() {
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Hello " + budgetProfile.getUserName() + "! What would you like to calculate? ");
        title.setFont(new Font("Century", Font.ITALIC, 50));
        titlePanel.add(title);
        return titlePanel;
    }


    public JPanel getChoicesPanel() {
        JPanel choicePanel = new JPanel();
        choicePanel.setMaximumSize(new Dimension(80, 100));
        Dimension buttonSize = new Dimension(60, 10);
        choicePanel.setLayout(new GridLayout(3, 1, 20, 20));
        JButton IncomeButton = new JButton("Minimum Income Needed Per Month");
        IncomeButton.setPreferredSize(buttonSize);
        IncomeButton.setFont(new Font("SansSerif", Font.BOLD, 50));
        JButton UtilityButton = new JButton("Utility Budget Per Month");
        UtilityButton.setPreferredSize(buttonSize);
        UtilityButton.setFont(new Font("SansSerif", Font.BOLD, 50));
        JButton SavingButton = new JButton("Leisure Budget Per Month");
        SavingButton.setPreferredSize(buttonSize);
        SavingButton.setFont(new Font("SansSerif", Font.BOLD, 50));

        IncomeButton.setForeground(Color.GREEN);
        UtilityButton.setForeground(Color.ORANGE);
        SavingButton.setForeground(Color.BLUE);

        IncomeButton.addActionListener(e -> {
            incomeFrame = new IncomeFrame();
            incomeFrame.pack();
            incomeFrame.setLocationRelativeTo(null);
            incomeFrame.setVisible(true);
        });

        UtilityButton.addActionListener(e -> {
            utilityFrame = new UtilityFrame();
            utilityFrame.pack();
            utilityFrame.setLocationRelativeTo(null);
            utilityFrame.setVisible(true);
        });

        SavingButton.addActionListener(e -> {
            try {
                savingFrame = new SavingFrame();
                savingFrame.pack();
                savingFrame.setLocationRelativeTo(null);
                savingFrame.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
        choicePanel.add(IncomeButton);
        choicePanel.add(UtilityButton);
        choicePanel.add(SavingButton);

        return choicePanel;
    }
    
    public JPanel getButtonsPanel() {
        JPanel buttonPanel = new JPanel();
        
        JButton seeBudgetButton = new JButton("See My Current Budget");
        JButton logOutButton = new JButton("Log Out");
        
        Dimension buttonSize = new Dimension(60, 30);
        seeBudgetButton.setPreferredSize(buttonSize);
        logOutButton.setPreferredSize(buttonSize);        
        
        
        seeBudgetButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(new JFrame(), analysis.toString());
        });
        
        logOutButton.addActionListener((ActionEvent e) -> {
            int input = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure to log out?", "Select an Option", JOptionPane.YES_NO_OPTION);
            if(input == JOptionPane.YES_OPTION)
                dispose();
        });
        
        buttonPanel.setLayout(new GridLayout(1,2,5,100));
        buttonPanel.add(seeBudgetButton);
        buttonPanel.add(logOutButton);
        
        return buttonPanel;
    }
}