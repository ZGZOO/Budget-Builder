import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class UtilityFrame extends JFrame {

    private JPanel IncomePanel;
    private JPanel SavingsPanel;
    private JPanel UtilityPanel; // Where Back and Display Graph Buttons are
    private JPanel FinanceListPanel;
    private JPanel mainUtilityPanel;

    private BudgetEditor budgetEditor;
    private BudgetProfileModel model;
    private BudgetProfile profile;
    private BudgetAnalysis budgetAnalysis;

    public UtilityFrame() {
        model = BudgetProfileModel.getSingleton();
        try {
            profile = CategoryFrame.budgetProfile;
            profile = model.findProfile(profile.getUserName(), profile.getPassword());
            budgetEditor = new BudgetEditor(profile);
            budgetAnalysis = new BudgetAnalysis(profile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error");
        }

        this.setTitle("Find " + profile.getUserName() + " Income Needed");
        this.setPreferredSize(new Dimension(1000, 800));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUpFrame();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setUpFrame() {
        setMainUtilityCotainer();
        JLabel mainTitle = new JLabel("Utility Budget");
        mainTitle.setFont(new Font("Century", Font.ITALIC, 60));
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
        setSavingsPanel();
        setFinanceListPanel();
        setUtilityPanel();
        mainUtilityPanel.add(IncomePanel);
        mainUtilityPanel.add(SavingsPanel);
        mainUtilityPanel.add(UtilityPanel);
    }

    public void setIncomePanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        JLabel IncomeTitle = new JLabel("INCOME ");
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
                JPanel listComponent = createFinanceComponent(IncomeName.getText(), Double.parseDouble(IncomeCost.getText().substring(1)));
                FinanceListPanel.add(listComponent);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter proper amount for income");
            }
            IncomeName.setText("");
            IncomeCost.setText("$");
            SwingUtilities.updateComponentTreeUI(this);
        });
    }

    public void setSavingsPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        JLabel SavingText = new JLabel("SAVING  ");
        SavingText.setFont(new Font("Century", Font.BOLD, 20));
        SavingText.setHorizontalAlignment(JLabel.CENTER);
        JTextField SavingAmount = new JTextField("$");
        SavingAmount.setHorizontalAlignment(JLabel.CENTER);
        SavingAmount.setFont(font);
        JLabel SavingAmountLabel = new JLabel("");
        SavingAmountLabel.setHorizontalAlignment(JLabel.CENTER);
        SavingAmountLabel.setFont(font);
        SavingAmountLabel.setForeground(Color.RED);
        // border for the label. Easier to see the set amount
        LineBorder border = new LineBorder(Color.BLACK, 2, true);
        SavingAmountLabel.setBorder(border);
        // Placing the label at the center of the
        SavingAmountLabel.setVerticalAlignment(JLabel.CENTER);
        SavingAmountLabel.setHorizontalAlignment(JLabel.CENTER);

        JButton SavingSetButton = new JButton("Save");
        SavingSetButton.setFont(font);
        SavingsPanel = new JPanel();
        SavingsPanel.setLayout(new GridLayout(1, 4));

        SavingsPanel.add(SavingText);
        SavingsPanel.add(SavingAmount);
        SavingsPanel.add(SavingSetButton);
        SavingsPanel.add(SavingAmountLabel);

        SavingSetButton.addActionListener(e -> {
            // action for Saving
            try { // when user does not input the amount for income and press Add button
                // For backend
                profile.setSavings(Double.parseDouble(SavingAmount.getText().substring(1)));
                SavingAmountLabel.setText(SavingAmount.getText());
                System.out.println(profile.getSavings());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter proper amount for income");
            }
        });
    }

    public void setUtilityPanel() {
        Font font = new Font("Century", Font.BOLD, 30);
        UtilityPanel = new JPanel();
        UtilityPanel.setLayout(new GridLayout(1, 3));
        JLabel subTitle = new JLabel("Utility Buttons ");
        subTitle.setHorizontalAlignment(JLabel.CENTER);
        subTitle.setFont(new Font("Century", Font.BOLD, 20));
        JButton BackButton = new JButton("Back");
        BackButton.setFont(font);
        JButton GraphButton = new JButton("Analyze Budget");
        GraphButton.setFont(font);
        BackButton.setPreferredSize(new Dimension(20, 20));
        GraphButton.setPreferredSize(new Dimension(20, 20));
        UtilityPanel.add(subTitle);
        UtilityPanel.add(BackButton);
        UtilityPanel.add(GraphButton);

        BackButton.addActionListener(e -> {
            // action
            dispose();
        });

        GraphButton.addActionListener(e -> {
            // action
            JOptionPane.showMessageDialog(new JFrame(), "Hello " + profile.getUserName() + ",\n " +
                    " Your total Spending is $" + budgetAnalysis.calculateSpending());
            System.out.println(budgetAnalysis.calculateSpending());
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
        if (profile.getIncomeList().size() > 0) {
            ArrayList<Income> incomeList = profile.getIncomeList();
            for (int i = 0; i < incomeList.size(); i++) {
                JPanel listComponent = createFinanceComponent(incomeList.get(i).getCategory(), incomeList.get(i).getAmount());
                FinanceListPanel.add(listComponent);
            }
        }
    }

    public JPanel createFinanceComponent(String category, double amount) {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridLayout(1, 3));
        JLabel listName = new JLabel(category);
        JLabel listAmount = new JLabel((("$" + amount)));
        JButton deleteButton = new JButton("Delete");
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
}