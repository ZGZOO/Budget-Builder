
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zhijiejennyxu
 */
public class InputNumbersForSavingGoalFrame extends JFrame{
    private JLabel incomeLabel;
    private JTextField incomeNameTextField;
    private JTextField incomeValueTextField;
    private JPanel incomePanel;

    private JLabel spendingLabel;
    private JTextField spendingNameTextField;
    private JTextField spendingValueTextField;
    private JPanel spendingPanel;

    private JButton backButton;
    private JButton saveButton;
    private JPanel buttonPanel;

    public InputNumbersForSavingGoalFrame(){
        this.setTitle("Find your Savings");
        this.setMaximumSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUpFrame();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setUpFrame(){
        incomePanel = this.getIncomePanel();
        spendingPanel = this.getSpendingPanel();
        buttonPanel = this.getButtonPanel();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spendingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(incomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(incomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(spendingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
        );
    }

    private JPanel getIncomePanel(){
        incomeLabel = new JLabel("Income:");
        incomeNameTextField = new JTextField("Income Name");
        incomeValueTextField = new JTextField("$:");

        JPanel income_Panel = new JPanel();
        GroupLayout incomePanelLayout = new GroupLayout(income_Panel);
        income_Panel.setLayout(incomePanelLayout);
        incomePanelLayout.setHorizontalGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(incomePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(incomePanelLayout.createSequentialGroup()
                                        .addComponent(incomeLabel)
                                        .addGap(0, 145, Short.MAX_VALUE))
                                .addGroup(incomePanelLayout.createSequentialGroup()
                                        .addComponent(incomeNameTextField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(incomeValueTextField))))
        );
        incomePanelLayout.setVerticalGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(incomePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(incomeLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(incomeValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(incomeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(17, Short.MAX_VALUE))
        );
        return income_Panel;
    }

    private JPanel getSpendingPanel(){
        spendingLabel = new JLabel("Spending:");
        spendingNameTextField = new JTextField("Spending Name");
        spendingValueTextField = new JTextField("$:");

        JPanel spending_Panel = new JPanel();
        GroupLayout spendingPanelLayout = new GroupLayout(spending_Panel);
        spending_Panel.setLayout(spendingPanelLayout);
        spendingPanelLayout.setHorizontalGroup(spendingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(spendingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(spendingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(spendingPanelLayout.createSequentialGroup()
                                        .addComponent(spendingLabel)
                                        .addGap(0, 145, Short.MAX_VALUE))
                                .addGroup(spendingPanelLayout.createSequentialGroup()
                                        .addComponent(spendingNameTextField, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spendingValueTextField))))
        );
        spendingPanelLayout.setVerticalGroup(spendingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(spendingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(spendingLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(spendingPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(spendingValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(spendingNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(17, Short.MAX_VALUE))
        );
        return spending_Panel;
    }

    private JPanel getButtonPanel(){
        backButton = new JButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                             //add actions
                                         }
                                     });
        saveButton = new JButton("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //add actions
            }
        });

        JPanel button_Panel = new JPanel();
        GroupLayout buttonPanelLayout = new GroupLayout(button_Panel);
        button_Panel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(buttonPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(buttonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(saveButton))
                                .addContainerGap())
        );
        return button_Panel;
    }

}