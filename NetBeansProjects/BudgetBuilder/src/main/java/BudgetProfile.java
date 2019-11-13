
import java.util.ArrayList;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zhijiejennyxu
 */
public class BudgetProfile {
    private String userName;
    private String password;
    private ArrayList<Income> incomeList = new ArrayList<Income>();
    private ArrayList<Spending> spendingList = new ArrayList<Spending>();
    private double savings;

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

    public ArrayList<Spending> getSpendingList() {
        return spendingList;
    }

    public Iterator<Spending> spendingIterator() {
        return spendingList.iterator();
    }

    public ArrayList<Income> getIncomeList() {
        return incomeList;
    }

    public Iterator<Income> incomeIterator() {
        return incomeList.iterator();
    }
    
    public String toString(){
        return "Username: " + this.getUserName() + "; Password: " + this.getPassword() 
                + "\nIncome: " + this.getIncomeList()
                + "\nSpendings: " + this.getSpendingList()
                + "\nSavings: " + this.getSavings();
    }
}
