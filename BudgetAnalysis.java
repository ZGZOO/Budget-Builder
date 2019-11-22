import java.util.Iterator;

public class BudgetAnalysis {    
    private BudgetProfile currentProfile;

    public BudgetAnalysis(BudgetProfile profile) {
        this.currentProfile = profile;
    }

    public void setCurrentProfile(BudgetProfile profile) {
        this.currentProfile = profile;
    }

    //How much user has after factoring in their income and spending habits
    public Double calculateSavingGoal() {
        return (getTotalIncome() - getTotalSpending());
    }

    //How much is user's spending budget after factoring in their income and savings goal
    public double calculateSpendingBudget() {
        return (getTotalIncome() - currentProfile.getSavings());
    }

    //How much user must make to support spending habits and reach savings goal
    public double calculateIncome() {
        return (getTotalSpending() + currentProfile.getSavings());
    }
    
    
    private double getTotalIncome(){
        double totalIncome = 0.0;
        double temp = 0.0;        
        Iterator<Income> it = currentProfile.incomeIterator();
        //calculate total income
        while(it.hasNext()) {
            temp = it.next().getAmount();
            totalIncome += temp;
        }   
        return totalIncome;
    }
    
    private double getTotalSpending(){
        double totalSpending = 0.0;
        double temp = 0.0;
        Iterator<Spending> it = currentProfile.spendingIterator();
        //calculate total spending
        while(it.hasNext()) {
            temp = it.next().getAmount();
            totalSpending += temp;
        }
        return totalSpending;
    }
    
    private double getActualSaving(){
        return (this.getTotalIncome() - this.getTotalSpending());
    }
    
    @Override
    public String toString(){
        return "User:           " + this.currentProfile.getUserName() + "\n" +
               "Saving Goal:    " + this.currentProfile.getSavings() + "\n" +
               "Total Income:   " + this.getTotalIncome() + "\n" +
               "Total Spending: " + this.getTotalSpending() + "\n" +
               "Actual Saving:  " + this.getActualSaving();
    }
}