import java.util.Iterator;

public class BudgetAnalysis{
    private BudgetProfile currentProfile;

    public BudgetAnalysis(BudgetProfile profile) {
        this.currentProfile = profile;
    }

    public void setCurrentProfile(BudgetProfile profile) {
        this.currentProfile = profile;
    }

    //How much user has after factoring in their income and spending habits
    public Double calculateSavings() {
        double totalSpending = 0.0;
        double temp = 0.0;
      
        Iterator<Spending> it2 = currentProfile.spendingIterator();

        //calculate total spending
        while(it2.hasNext()) {
            temp = it2.next().getAmount();
            totalSpending += temp;
        }

        return totalIncome() - totalSpending;
    }

    //How much is user's spending budget after factoring in their income and savings goal
    public double calculateSpending() {

        double temp = 0.0;
        Iterator<Income> it = currentProfile.incomeIterator();

        return (totalIncome() - currentProfile.getSavings());
    }

    //How much user must make to support spending habits and reach savings goal
    public double calculateIncome() {

        double totalSpending = 0.0;
        double temp = 0.0;

        Iterator<Spending> it = currentProfile.spendingIterator();

        //calculate total spending
        while(it.hasNext()) {
            temp = it.next().getAmount();
            totalSpending += temp;
        }
        return (totalSpending + currentProfile.getSavings());
    }
    
    public double totalIncome() {
    	double temp = 0.0;
    	double totalIncome = 0.0;
        Iterator<Income> it = currentProfile.incomeIterator();

        //calculate total income
        while(it.hasNext()) {
            temp = it.next().getAmount();
            totalIncome += temp;
        }
        
        return totalIncome;
    }
}