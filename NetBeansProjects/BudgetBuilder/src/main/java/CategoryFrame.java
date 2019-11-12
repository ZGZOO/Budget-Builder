import javax.swing.*;
import java.awt.*;

public class CategoryFrame extends JFrame {
    private JFrame incomeFrame;
    private JFrame UtilityFrame;
    private JFrame SavingGoalFrame;
    private JFrame spendingGraphFrame;

    public CategoryFrame() throws HeadlessException {
        this.setTitle("Budget Builder");
        this.setPreferredSize(new Dimension(1200,900));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel title = getTitlePanel();
        JPanel buttonPanel = getButtonsPanel();
        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
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
        buttonPanel.setLayout(new GridLayout(3,1, 30, 30));
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
            incomeFrame = new InputNumbersForIncomeNeededFrame();
            incomeFrame.pack();
            incomeFrame.setLocationRelativeTo(null);
            incomeFrame.setVisible(true);
        });

        UtilityButton.addActionListener( e -> {
            UtilityFrame = new InputNumbersForUtilityBudgetFrame();
            UtilityFrame.pack();
            UtilityFrame.setLocationRelativeTo(null);
            UtilityFrame.setVisible(true);
        });

        SavingButton.addActionListener(e -> {
            try {
                SavingGoalFrame = new InputNumbersForSavingGoalFrame();
                SavingGoalFrame.pack();
                SavingGoalFrame.setLocationRelativeTo(null);
                SavingGoalFrame.setVisible(true);
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
