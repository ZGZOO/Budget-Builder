import java.util.ArrayList;
import java.util.Iterator;

public class BudgetProfile {

    private String userName;
    private String password;
    private ArrayList<Income> incomeList;
    private double savings;
    private ArrayList<Spending> spendingList;

    public BudgetProfile(String userName, String password) {
        this.userName = userName;
        this.password = password;
        incomeList = new ArrayList<>();
        spendingList = new ArrayList<>();
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

    @Override
    public String toString() {
        return "User {" +
                "name='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}