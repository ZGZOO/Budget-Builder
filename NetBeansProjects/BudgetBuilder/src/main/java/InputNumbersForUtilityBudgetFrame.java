import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zhijiejennyxu
 */
public class InputNumbersForUtilityBudgetFrame extends JFrame{
    private JLabel incomeLabel;
    private JComboBox<String> incomeCatergoryComboBox;
    private JTextField incomeValueTextField;
    private JPanel incomePanel;

    private JLabel savingLabel;
    private JTextField savingValueTextField;
    private JPanel savingPanel;


    public InputNumbersForUtilityBudgetFrame(){
        this.setTitle("Find your Utility Budget");
        this.setMaximumSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUpFrame();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setUpFrame()
    {
        savingPanel = this.getSavingPanel();
        incomePanel = this.getIncomePanel();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(savingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(incomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(incomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(savingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(70, Short.MAX_VALUE))
        );
    }

    private JPanel getIncomePanel(){
        incomeLabel = new JLabel("Income:");
        incomeCatergoryComboBox = new JComboBox<>();
        incomeValueTextField = new JTextField("$:");

        incomeCatergoryComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        incomeCatergoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        JPanel income_Panel = new JPanel();
        GroupLayout incomePanelLayout = new GroupLayout(income_Panel);
        income_Panel.setLayout(incomePanelLayout);
        incomePanelLayout.setHorizontalGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(incomePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(incomePanelLayout.createSequentialGroup()
                                        .addComponent(incomeCatergoryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(incomeValueTextField, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                .addComponent(incomeLabel))
                        .addGap(0, 15, Short.MAX_VALUE))
        );
        incomePanelLayout.setVerticalGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(incomePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(incomeLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(incomePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(incomeValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(incomeCatergoryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))
        );
        return income_Panel;
    }

    private JPanel getSavingPanel(){
        savingLabel = new JLabel("Savings:");
        savingValueTextField = new JTextField("$:");
        JPanel saving_Panel = new JPanel();

        GroupLayout savingPanelLayout = new GroupLayout(saving_Panel);
        saving_Panel.setLayout(savingPanelLayout);
        savingPanelLayout.setHorizontalGroup(savingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(savingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(savingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(savingValueTextField, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGroup(savingPanelLayout.createSequentialGroup()
                                        .addComponent(savingLabel)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        savingPanelLayout.setVerticalGroup(savingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(savingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(savingLabel)
                        .addGap(18, 18, 18)
                        .addComponent(savingValueTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return saving_Panel;
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}
