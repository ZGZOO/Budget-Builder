import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.ArrayList;

public class SavingFrame extends JFrame {

    private JPanel IncomePanel;
    private JPanel SpendingPanel;
    private JPanel UtilityPanel; // Where Back and Display Graph Buttons are
    private JPanel FinanceListPanel;
    private JPanel mainUtilityPanel;

    private BudgetEditor budgetEditor;
    private BudgetProfileModel model;
    private BudgetProfile profile;
    private BudgetAnalysis budgetAnalysis;

    public SavingFrame() {
        model = BudgetProfileModel.getSingleton();
        try {
            profile = CategoryFrame.budgetProfile;
            profile = model.findProfile(profile.getUserName(), profile.getPassword());
            budgetEditor = new BudgetEditor(profile);
            budgetAnalysis = new BudgetAnalysis(profile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error");
        }

        this.setTitle("Find " + profile.getUserName() + "'s Possible Saving");
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
        JLabel mainTitle = new JLabel("How much can I save this month?");
        mainTitle.setFont(new Font("Century", Font.ITALIC, 40));
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        this.add(mainTitle, BorderLayout.NORTH);
        this.add(mainUtilityPanel, BorderLayout.CENTER);
        // Total amount is gonna be at Border.SOUTH
        this.add(FinanceListPanel, BorderLayout.SOUTH);
    }

    public void setMainUtilityCotainer() {
        mainUtilityPanel = new JPanel();
        mainUtilityPanel.setLayout(new GridLayout(3, 1));
        setIncomePanel();
        setSpendingPanel();
        setFinanceListPanel();
        setUtilityPanel();
        mainUtilityPanel.add(IncomePanel);
        mainUtilityPanel.add(SpendingPanel);
        mainUtilityPanel.add(UtilityPanel);
    }

    public void setIncomePanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        JLabel IncomeTitle = new JLabel("Enter Your Income:");
        IncomeTitle.setFont(new Font("Century", Font.BOLD, 20));
        IncomeTitle.setHorizontalAlignment(JLabel.CENTER);
        JTextField IncomeName = new JTextField("Salary");
        IncomeName.setFont(font);
        IncomeName.setHorizontalAlignment(JLabel.CENTER);
        JTextField IncomeCost = new JTextField("$");
        IncomeCost.setFont(font);
        IncomeCost.setHorizontalAlignment(JLabel.CENTER);
        JButton IncomeAddButton = new JButton("Add");
        IncomeAddButton.setFont(font);

        IncomePanel = new JPanel();
        IncomePanel.setLayout(new GridLayout(1, 4));
        IncomePanel.add(IncomeTitle);
        IncomePanel.add(IncomeName);
        IncomePanel.add(IncomeCost);
        IncomePanel.add(IncomeAddButton);

        IncomeAddButton.addActionListener(e -> {

            System.out.println(budgetEditor);

            try { // when user does not input the amount for income and press Add button
                // For backend
                budgetEditor.addIncome(new Income(IncomeName.getText(), Double.parseDouble(IncomeCost.getText().substring(1))));
                JPanel listComponent = createIncomeComponent(IncomeName.getText(), Double.parseDouble(IncomeCost.getText().substring(1)));
                FinanceListPanel.add(listComponent);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter proper amount for income");
            }
            IncomeName.setText("");
            IncomeCost.setText("$");
            SwingUtilities.updateComponentTreeUI(this);
        });
    }

    public void setSpendingPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        JLabel SpendingText = new JLabel("Enter Your Spending:");
        SpendingText.setFont(new Font("Century", Font.BOLD, 20));
        SpendingText.setHorizontalAlignment(JLabel.CENTER);
        JTextField SpendingName = new JTextField("Rent");
        SpendingName.setFont(font);
        SpendingName.setHorizontalAlignment(JLabel.CENTER);
        JTextField SpendingAmount = new JTextField("$");
        SpendingAmount.setHorizontalAlignment(JLabel.CENTER);
        SpendingAmount.setFont(font);

        JButton SpendingSetButton = new JButton("Add");
        SpendingSetButton.setFont(font);
        SpendingPanel = new JPanel();
        SpendingPanel.setLayout(new GridLayout(1, 4));

        SpendingPanel.add(SpendingText);
        SpendingPanel.add(SpendingName);
        SpendingPanel.add(SpendingAmount);
        SpendingPanel.add(SpendingSetButton);

        SpendingSetButton.addActionListener(e -> {
            // action for Saving
            try { // when user does not input the amount for income and press Add button
                // For backend
                budgetEditor.addSpending(new Spending(SpendingName.getText(), Double.parseDouble(SpendingAmount.getText().substring(1))));
                JPanel listComponent = createSpendingComponent(SpendingName.getText(), Double.parseDouble(SpendingAmount.getText().substring(1)));
                FinanceListPanel.add(listComponent);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter proper amount for Spending");
            }
        });
    }

    public void setUtilityPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        UtilityPanel = new JPanel();
        UtilityPanel.setLayout(new GridLayout(1, 3));
        //JLabel subTitle = new JLabel("Utility Buttons ");
        //subTitle.setHorizontalAlignment(JLabel.CENTER);
        //subTitle.setFont(new Font("Century", Font.BOLD, 20));
        JButton BackButton = new JButton("Back");
        BackButton.setFont(font);
        JButton GraphButton = new JButton("Analyze Budget");
        GraphButton.setFont(font);
        BackButton.setPreferredSize(new Dimension(20, 20));
        GraphButton.setPreferredSize(new Dimension(20, 20));
        //UtilityPanel.add(subTitle);
        UtilityPanel.add(BackButton);
        UtilityPanel.add(GraphButton);

        BackButton.addActionListener(e -> {
            // action
            dispose();
        });

        GraphButton.addActionListener(e -> {
            // action
            JOptionPane.showMessageDialog(new JFrame(), "Hello " + profile.getUserName() + ",\n" + 
                    "Your total saving this month will be $" + budgetAnalysis.calculateSavingGoal() + ".");
            System.out.println(budgetAnalysis.calculateSavingGoal());
            SwingUtilities.updateComponentTreeUI(this);
        });
    }

    public void setFinanceListPanel() {
        FinanceListPanel = new JPanel();
        FinanceListPanel.setLayout(new GridLayout(10, 1));
        JLabel ListTitle = new JLabel("Finance List");
        ListTitle.setFont(new Font("Century", Font.BOLD, 20));
        ListTitle.setHorizontalAlignment(JLabel.CENTER);
        FinanceListPanel.add(ListTitle);

        // When user already has the data stored in the profile, this shows income list
        if (profile.getIncomeList().size() > 0 || profile.getSpendingList().size() > 0) {
            ArrayList<Income> incomeList = profile.getIncomeList();
            ArrayList<Spending> spendingList = profile.getSpendingList();
            for (int i = 0; i < incomeList.size(); i++) {
                JPanel listComponent = createIncomeComponent(incomeList.get(i).getCategory(), incomeList.get(i).getAmount());
                FinanceListPanel.add(listComponent);
            }
            for (int j = 0; j < spendingList.size(); j++) {
                JPanel listComponent = createSpendingComponent(spendingList.get(j).getCategory(), spendingList.get(j).getAmount());
                FinanceListPanel.add(listComponent);
            }
        }
    }

    public JPanel createIncomeComponent(String category, double amount) {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1, 4));
        JLabel listName = new JLabel(category);
        JLabel listAmount = new JLabel((("$" + amount)));
        JButton deleteButton = new JButton("Delete");
        JLabel sign = new JLabel("+");
        sign.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        sign.setHorizontalAlignment(JLabel.CENTER);
        sign.setForeground(Color.GREEN);
        listPanel.add(sign);
        listPanel.add(listName);
        listPanel.add(listAmount);
        listPanel.add(deleteButton);
        BevelBorder border = new BevelBorder(BevelBorder.RAISED);
        listPanel.setBorder(border);
        deleteButton.addActionListener(e -> {
            // action for deleting
            budgetEditor.deleteIncome(listName.getText());
            FinanceListPanel.remove(listPanel);
            SwingUtilities.updateComponentTreeUI(this);
        });
        return listPanel;
    }

    public JPanel createSpendingComponent(String category, double amount) {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1, 4));
        JLabel listName = new JLabel(category);
        JLabel listAmount = new JLabel(("$" + amount));
        JLabel sign = new JLabel("-");
        sign.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        sign.setForeground(Color.RED);
        sign.setHorizontalAlignment(JLabel.CENTER);
        JButton deleteButton = new JButton("Delete");
        listPanel.add(sign);
        listPanel.add(listName);
        listPanel.add(listAmount);
        listPanel.add(deleteButton);
        BevelBorder border = new BevelBorder(BevelBorder.RAISED);
        listPanel.setBorder(border);
        deleteButton.addActionListener(e -> {
            // action for deleting
            budgetEditor.deleteSpending(listName.getText());
            FinanceListPanel.remove(listPanel);
            SwingUtilities.updateComponentTreeUI(this);
        });
        return listPanel;
    }
}