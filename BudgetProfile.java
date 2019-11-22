import java.util.ArrayList;
import java.util.Iterator;

public class BudgetProfile {

    private String userName;
    private String password;
    private ArrayList<Income> incomeList;
    private ArrayList<Spending> spendingList;
    private double savings;

    public BudgetProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.incomeList = new ArrayList<>();
        this.spendingList = new ArrayList<>();
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public double getSavings() {
        return this.savings;
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

    @Override
    public String toString() {
        return "User {" +
                "name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}