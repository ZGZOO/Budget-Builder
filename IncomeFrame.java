/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhijiejennyxu
 */
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class IncomeFrame extends JFrame {

    private JPanel spendingPanel;
    private JPanel savingsPanel;
    private JPanel utilityPanel; // Where Back and Display Graph Buttons are
    private JPanel financeListPanel;
    private JPanel mainUtilityPanel;
    
    private JPanel SavingComponent = new JPanel();
    private JLabel SavingTextLabel = new JLabel("");
    private JLabel SavingAmountLabel = new JLabel("");

    private BudgetEditor budgetEditor;
    private BudgetProfileModel model;
    private BudgetProfile profile;
    private BudgetAnalysis budgetAnalysis;

    public IncomeFrame() {
        model = BudgetProfileModel.getSingleton();
        try {
            profile = CategoryFrame.budgetProfile;
            profile = model.findProfile(profile.getUserName(), profile.getPassword());
            budgetEditor = new BudgetEditor(profile);
            budgetAnalysis = new BudgetAnalysis(profile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error");
        }

        this.setTitle("Find " + profile.getUserName() + "'s Income Needed");
        this.setPreferredSize(new Dimension(1000, 800));
        this.setLayout(new BorderLayout());
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUpFrame();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setUpFrame() {
        setMainUtilityCotainer();
        JLabel mainTitle = new JLabel("How much income do I need this month?");
        mainTitle.setFont(new Font("Century", Font.ITALIC, 40));
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(mainTitle, BorderLayout.NORTH);
        this.add(mainUtilityPanel, BorderLayout.CENTER);
        // Total amount is gonna be at Border.SOUTH
        this.add(financeListPanel, BorderLayout.SOUTH);
    }

    public void setMainUtilityCotainer() {
        mainUtilityPanel = new JPanel();
        mainUtilityPanel.setLayout(new GridLayout(3, 1));
        setSpendingPanel();
        setSavingsPanel();
        setFinanceListPanel();
        setUtilityPanel();
        mainUtilityPanel.add(spendingPanel);
        mainUtilityPanel.add(savingsPanel);
        mainUtilityPanel.add(utilityPanel);
    }

    public void setSpendingPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        JLabel spendingTitle = new JLabel("Enter Your Spending:");
        spendingTitle.setFont(new Font("Century", Font.BOLD, 20));
        spendingTitle.setHorizontalAlignment(JLabel.CENTER);
        JTextField spendingName = new JTextField("Spending");
        spendingName.setFont(font);
        spendingName.setHorizontalAlignment(JLabel.CENTER);
        JTextField spendingCost = new JTextField("$");
        spendingCost.setFont(font);
        spendingCost.setHorizontalAlignment(JLabel.CENTER);
        JButton spendingAddButton = new JButton("Add");
        spendingAddButton.setFont(font);

        spendingPanel = new JPanel();
        spendingPanel.setLayout(new GridLayout(1, 4));
        spendingPanel.add(spendingTitle);
        spendingPanel.add(spendingName);
        spendingPanel.add(spendingCost);
        spendingPanel.add(spendingAddButton);

        spendingAddButton.addActionListener(e -> {

            System.out.println(budgetEditor);

            try { // when user does not input the amount for income and press Add button
                // For backend
                budgetEditor.addSpending(new Spending(spendingName.getText(), Double.parseDouble(spendingCost.getText().substring(1))));
                JPanel listComponent = createSpendingComponent(spendingName.getText(), Double.parseDouble(spendingCost.getText().substring(1)));
                financeListPanel.add(listComponent);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter proper amount for income");
            }
            spendingName.setText("");
            spendingCost.setText("$");
            SwingUtilities.updateComponentTreeUI(this);
        });
    }

    public void setSavingsPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        JLabel SavingText = new JLabel("Enter Your Saving Goal:");
        SavingText.setFont(new Font("Century", Font.BOLD, 20));
        SavingText.setHorizontalAlignment(JLabel.CENTER);
        JTextField SavingAmount = new JTextField("$");
        SavingAmount.setHorizontalAlignment(JLabel.CENTER);
        SavingAmount.setFont(font);
        JLabel SavingAmountText = new JLabel("");
        SavingAmountText.setHorizontalAlignment(JLabel.CENTER);
        SavingAmountText.setFont(font);
        SavingAmountText.setForeground(Color.orange);
        // border for the label. Easier to see the set amount
        LineBorder border = new LineBorder(Color.BLACK, 2, true);
        SavingAmountText.setBorder(border);
        // Placing the label at the center of the
        SavingAmountText.setVerticalAlignment(JLabel.CENTER);
        SavingAmountText.setHorizontalAlignment(JLabel.CENTER);

        JButton SavingSetButton = new JButton("Save");
        SavingSetButton.setFont(font);
        savingsPanel = new JPanel();
        savingsPanel.setLayout(new GridLayout(1, 3));

        savingsPanel.add(SavingText);
        savingsPanel.add(SavingAmount);
        savingsPanel.add(SavingSetButton);
        //savingsPanel.add(SavingAmountLabel);

        SavingSetButton.addActionListener(e -> {
            // action for Saving
            try { // when user does not input the amount for income and press Add button
                // For backend
                double amount = Double.parseDouble(SavingAmount.getText().substring(1));
                if (SavingTextLabel.getText().equals("")) {
                    SavingComponent.setBackground(Color.ORANGE);
                    SavingComponent.setLayout(new GridLayout(1, 2));
                    SavingTextLabel.setText("Saving");
                    SavingTextLabel.setFont(new Font("Century", Font.BOLD, 14));
                    SavingTextLabel.setHorizontalAlignment(JLabel.CENTER);
                    SavingTextLabel.setForeground(Color.WHITE);
                    SavingAmountLabel.setText(("$" + amount));
                    SavingAmountLabel.setFont(new Font("Century", Font.BOLD, 14));
                    SavingAmountLabel.setHorizontalAlignment(JLabel.CENTER);
                    SavingAmountLabel.setForeground(Color.WHITE);
                    SavingComponent.add(SavingTextLabel);
                    SavingComponent.add(SavingAmountLabel);
                    financeListPanel.add(SavingComponent);
                } else {
                    SavingAmountLabel.setText(("$" + amount));
                    SwingUtilities.updateComponentTreeUI(this);
                }

                BevelBorder border2 = new BevelBorder(BevelBorder.RAISED);
                SavingComponent.setBorder(border2);
                profile.setSavings(amount);
                SavingAmountLabel.setText(SavingAmount.getText());
                System.out.println(profile.getSavings());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter proper amount for income");
            }
        });
    }

    public void setUtilityPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        utilityPanel = new JPanel();
        utilityPanel.setLayout(new GridLayout(1, 2));
        //JLabel subTitle = new JLabel("Utility Buttons ");
        //subTitle.setHorizontalAlignment(JLabel.CENTER);
        //subTitle.setFont(new Font("Century", Font.BOLD, 20));
        JButton BackButton = new JButton("Back");
        BackButton.setFont(font);
        JButton GraphButton = new JButton("Analyze Budget");
        GraphButton.setFont(font);
        BackButton.setPreferredSize(new Dimension(20, 20));
        GraphButton.setPreferredSize(new Dimension(20, 20));
        //utilityPanel.add(subTitle);
        utilityPanel.add(BackButton);
        utilityPanel.add(GraphButton);

        BackButton.addActionListener(e -> {
            // action
            dispose();
        });

        GraphButton.addActionListener(e -> {
            // action
            JOptionPane.showMessageDialog(new JFrame(), "Hello " + profile.getUserName() + ",\n" +
                    "You need to make at least $" + budgetAnalysis.calculateIncome() + ". Good luck! :)");
            System.out.println(budgetAnalysis.calculateSpendingBudget());
            SwingUtilities.updateComponentTreeUI(this);
        });

    }

    public void setFinanceListPanel() {
        financeListPanel = new JPanel();
        financeListPanel.setLayout(new GridLayout(10, 1));
        JLabel ListTitle = new JLabel("Finance List");
        ListTitle.setFont(new Font("Century", Font.BOLD, 20));
        ListTitle.setHorizontalAlignment(JLabel.CENTER);
        financeListPanel.add(ListTitle);

        // When user already has the data stored in the profile, this shows income list
        if (profile.getSpendingList().size() > 0) {
            ArrayList<Income> spendingList = profile.getIncomeList();
            for (int i = 0; i < spendingList.size(); i++) {
                JPanel listComponent = createSpendingComponent(spendingList.get(i).getCategory(), spendingList.get(i).getAmount());
                financeListPanel.add(listComponent);
            }
        }
    }

    public JPanel createSpendingComponent(String category, double amount) {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1, 4));
        JLabel listName = new JLabel(category);
        JLabel listAmount = new JLabel((("$" + amount)));
        JButton deleteButton = new JButton("Delete");
        JLabel sign = new JLabel("-");
        sign.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setForeground(Color.RED);
        listPanel.add(sign);
        listPanel.add(listName);
        listPanel.add(listAmount);
        listPanel.add(deleteButton);
        BevelBorder border = new BevelBorder(BevelBorder.RAISED);
        listPanel.setBorder(border);
        deleteButton.addActionListener(e -> {
            // action for deleting
            budgetEditor.deleteIncome(listName.getText());
            financeListPanel.remove(listPanel);
            SwingUtilities.updateComponentTreeUI(this);
        });
        return listPanel;
    }

}