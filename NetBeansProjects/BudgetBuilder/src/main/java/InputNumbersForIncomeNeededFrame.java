import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zhijiejennyxu
 */
public class InputNumbersForIncomeNeededFrame extends JFrame{
    private JLabel spendingLabel;
    private JTextField spendingNameTextField;
    private JTextField spendingValueTextField;
    private JPanel spendingPanel;

    private JLabel savingLabel;
    private JTextField savingValueTextField;
    private JPanel savingPanel;

    private JButton backButton;
    private JButton saveButton;
    private JPanel buttonPanel;

    public InputNumbersForIncomeNeededFrame(){
        this.setTitle("Find your Income Needed");
        this.setMaximumSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUpFrame();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setUpFrame(){
        spendingPanel = this.getSpendingPanel();
        buttonPanel = this.getButtonPanel();
        savingPanel = this.getSavingPanel();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(savingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spendingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(spendingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(savingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))
        );
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

    private JPanel getSavingPanel(){
        savingLabel = new JLabel("Savings:");
        savingValueTextField = new JTextField("$:");
        JPanel saving_Panel = new JPanel();

        GroupLayout savingPanelLayout = new GroupLayout(saving_Panel);
        saving_Panel.setLayout(savingPanelLayout);
        savingPanelLayout.setHorizontalGroup(
                savingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(savingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(savingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(savingValueTextField)
                                        .addGroup(savingPanelLayout.createSequentialGroup()
                                                .addComponent(savingLabel)
                                                .addContainerGap(143, Short.MAX_VALUE))))
        );
        savingPanelLayout.setVerticalGroup(
                savingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(savingPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(savingLabel)
                                .addGap(18, 18, 18)
                                .addComponent(savingValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return saving_Panel;
    }

    private JPanel getButtonPanel(){
        backButton = new JButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                             // Add actionListener
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
                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
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