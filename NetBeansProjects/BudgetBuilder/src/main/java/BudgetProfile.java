import java.util.ArrayList;
import java.util.Iterator;

public class BudgetProfile{
    private String userName;
    private String password;
    private ArrayList<Income> incomeList= new ArrayList<Income>();
    private double savings;
    private ArrayList<Spending> spendingList= new ArrayList<Spending>();

    public BudgetProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public ArrayList<Spending> getSpendingList(){
        return spendingList;
    }

    public Iterator<Spending> spendingIterator() {
        return spendingList.iterator();
    }

    public ArrayList<Income> getIncomeList(){
        return incomeList;
    }

    public Iterator<Income> incomeIterator() {
        return incomeList.iterator();
    }

}