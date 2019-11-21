import javax.swing.*;
import java.awt.*;
/**
 *
 * @author zhijiejennyxu
 */
public class InputNumbersForUtilityBudgetFrame extends JFrame{
    private JLabel incomeLabel;
    private JTextField incomeNameTextField;
    private JTextField incomeValueTextField;
    private JPanel incomePanel;

    private JLabel savingLabel;
    private JTextField savingValueTextField;
    private JPanel savingPanel;

    private JButton backButton;
    private JButton saveButton;
    private JPanel buttonPanel;


    public InputNumbersForUtilityBudgetFrame(){
        this.setTitle("Find your Utility Budget");
        this.setMaximumSize(new Dimension(1000,1000));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setUpFrame();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void setUpFrame(){
        incomePanel = this.getIncomePanel();
        savingPanel = this.getSavingPanel();
        buttonPanel = this.getButtonPanel();
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(savingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(incomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(126, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(incomePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(savingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
        backButton.addActionListener(evt -> {
            // add actions
        });

        saveButton = new JButton("Add");
        saveButton.addActionListener(evt -> {
            //add actions
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