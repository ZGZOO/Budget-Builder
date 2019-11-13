import java.awt.*;
import javax.swing.*;
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhijiejennyxu
 */

public class CategoryFrame extends JFrame{
        private JFrame spendingGraphFrame;
        private BudgetProfileModel budgetProfileModel;

        public CategoryFrame(BudgetProfileModel budgetProfileModel) throws HeadlessException {
            this.budgetProfileModel = budgetProfileModel;
            this.setTitle("Budget Builder");
            this.setPreferredSize(new Dimension(1200, 900));
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            JPanel title = getTitlePanel();
            JPanel buttonPanel = getButtonsPanel();
            this.add(title, BorderLayout.NORTH);
            this.add(buttonPanel, BorderLayout.CENTER);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }

        public JPanel getTitlePanel() {
            JPanel titlePanel = new JPanel();
            JLabel title = new JLabel("What would you like to calculate ? ");
            title.setFont(new Font("Century", Font.ITALIC, 70));
            titlePanel.add(title);
            return titlePanel;
        }

        public JPanel getButtonsPanel() {
            JPanel buttonPanel = new JPanel();
            buttonPanel.setMaximumSize(new Dimension(100, 150));
            Dimension buttonSize = new Dimension(60, 20);
            buttonPanel.setLayout(new GridLayout(3, 1, 30, 30));
            JButton IncomeButton = new JButton("Income Needed");
            IncomeButton.setPreferredSize(buttonSize);
            IncomeButton.setFont(new Font("SansSerif", Font.BOLD, 50));
            JButton UtilityButton = new JButton("Utility Budget");
            UtilityButton.setPreferredSize(buttonSize);
            UtilityButton.setFont(new Font("SansSerif", Font.BOLD, 50));
            JButton SavingButton = new JButton("Savings");
            SavingButton.setPreferredSize(buttonSize);
            SavingButton.setFont(new Font("SansSerif", Font.BOLD, 50));

            IncomeButton.setForeground(Color.GREEN);
            UtilityButton.setForeground(Color.ORANGE);
            SavingButton.setForeground(Color.BLUE);

            IncomeButton.addActionListener(e -> {
                dispose();
                JFrame incomeFrame = new InputNumbersForIncomeNeededFrame(budgetProfileModel);
            });

            UtilityButton.addActionListener(e -> {
                dispose();
                JFrame UtilityFrame = new InputNumbersForUtilityBudgetFrame(budgetProfileModel);
            });

            SavingButton.addActionListener(e -> {
                try {
                    dispose();
                    JFrame SavingGoalFrame = new InputNumbersForSavingsGoalFrame(budgetProfileModel);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            });
            buttonPanel.add(IncomeButton);
            buttonPanel.add(UtilityButton);
            buttonPanel.add(SavingButton);

            return buttonPanel;
        }
}
