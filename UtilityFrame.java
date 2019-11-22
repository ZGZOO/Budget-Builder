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
    private JPanel SavingComponent = new JPanel();
    private JLabel SavingTextLabel = new JLabel("");
    private JLabel SavingAmountLabel = new JLabel("");

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

        this.setTitle("Find " + profile.getUserName() + "'s Available Budget");
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
        JLabel mainTitle = new JLabel("How much is my utility budget this month?");
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
        setSavingsPanel();
        setFinanceListPanel();
        setUtilityPanel();
        mainUtilityPanel.add(IncomePanel);
        mainUtilityPanel.add(SavingsPanel);
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
        SavingsPanel = new JPanel();
        SavingsPanel.setLayout(new GridLayout(1, 3));

        SavingsPanel.add(SavingText);
        SavingsPanel.add(SavingAmount);
        SavingsPanel.add(SavingSetButton);

        SavingSetButton.addActionListener(e -> {
            // action for Saving
            try { // when user does not input the amount for income and press Add button
                // For backend
                double amount = Double.parseDouble(SavingAmount.getText().substring(1));
                if (SavingTextLabel.getText().equals("")) {
                    SavingComponent.setBackground(Color.ORANGE);
                    SavingComponent.setLayout(new GridLayout(1, 2));
                    SavingTextLabel.setText("Saving Goal");
                    SavingTextLabel.setFont(new Font("Century", Font.BOLD, 14));
                    SavingTextLabel.setHorizontalAlignment(JLabel.CENTER);
                    SavingTextLabel.setForeground(Color.WHITE);
                    SavingAmountLabel.setText(("$" + amount));
                    SavingAmountLabel.setFont(new Font("Century", Font.BOLD, 14));
                    SavingAmountLabel.setHorizontalAlignment(JLabel.CENTER);
                    SavingAmountLabel.setForeground(Color.WHITE);
                    SavingComponent.add(SavingTextLabel);
                    SavingComponent.add(SavingAmountLabel);
                    FinanceListPanel.add(SavingComponent);
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
                    "Your total available budget is $" + budgetAnalysis.calculateSpendingBudget() + ".");
            System.out.println(budgetAnalysis.calculateSpendingBudget());
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
                JPanel listComponent = createIncomeComponent(incomeList.get(i).getCategory(), incomeList.get(i).getAmount());
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

}