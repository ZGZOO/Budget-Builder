import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		BudgetProfile budgetProfile = new BudgetProfile("PsuedoDuck", "51AllenWrench" );
		BudgetEditor budgetEditor = new BudgetEditor(budgetProfile);
		Income income = new Income("Work",5000.00);
		Spending spending = new Spending("car",250.00);
		
		
		budgetProfile.setSavings(300);
		budgetEditor.addIncome(income);
		budgetEditor.addSpending(spending);
		
		income = new Income("Stocks",2000.00);
		budgetEditor.addIncome(income);
		
		System.out.print(budgetProfile.getUserName() + "\n");
		System.out.print(budgetProfile.getPassword() + "\n");
		System.out.print(budgetProfile.getSavings() + "\n");
		
		Iterator<Income> incomeArray = budgetProfile.incomeIterator();
		Income category;
		String text;
		Double amount;
		while(incomeArray.hasNext()) {
			category = incomeArray.next();
			text = category.getCategory();
			System.out.print(text + "\n");
			amount = category.getAmount();
			System.out.print(amount.toString() + "\n");
		}
				
	
		Iterator<Spending> spendingArray = budgetProfile.spendingIterator();
		Spending category2;
		while(spendingArray.hasNext()) {
			category2 = spendingArray.next();
			text = category2.getCategory();
			System.out.print(text + "\n");
			amount = category2.getAmount();
			System.out.print(amount.toString() + "\n");
		}
		
		//Test savings goal analysis
		BudgetAnalysis budgetAnalysis = new BudgetAnalysis(budgetProfile);
		Double savings = budgetAnalysis.calculateSavings();
		System.out.print("\n" + "SAVINGS ANALYSIS: " + savings.toString());
		
		//Test spending budget analysis
		Double spendingAmnt = budgetAnalysis.calculateSpending();
		System.out.print("\n" + "SPENDING ANALYSIS: " + spendingAmnt.toString());
		
		//Test income analysis
		Double incomeAmnt = budgetAnalysis.calculateIncome();
		System.out.print("\n" + "INCOME ANALYSIS: " + incomeAmnt.toString());
	}
}
