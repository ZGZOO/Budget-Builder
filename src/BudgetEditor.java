import java.util.ArrayList;

public class BudgetEditor {
	private BudgetProfile currentProfile;
	
	public BudgetEditor() {
	}
	
	public BudgetEditor(BudgetProfile profile) {
		this.currentProfile = profile;
	}
	
	public void setCurrentProfile(BudgetProfile profile) {
		this.currentProfile = profile;
	}
	
	//adds to ArrayList in currentProfile
	public void addIncome(Income category) {
		currentProfile.getIncomeList().add(category);
	}
	
	//adds to ArrayList in currentProfile
	public void addSpending(Spending category) {
		currentProfile.getSpendingList().add(category);
	}
	
	public void deleteIncome(String category) {
		ArrayList<Income> list = currentProfile.getIncomeList();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCategory() == category) {
				list.remove(i);
				break; //End loop once object with matching category type is found
			}
		}
	}
	
	public void deleteSpending(String category) {
		ArrayList<Spending> list = currentProfile.getSpendingList();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCategory() == category) {
				list.remove(i);
				break; //End loop once object with matching category type is found
			}
		}
	}
	

	//Use when modifying the amount in an already existing category
	public void editIncome(String category, double amount) {
		ArrayList<Income> list = currentProfile.getIncomeList();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCategory() == category) {
				list.get(i).setAmount(amount); 
				break; //End loop once object with matching category type is found
			}
		}
	}
	
	//Use when modifying the amount in an already existing category
	public void editSpending(String category, double amount) {
		ArrayList<Spending> list = currentProfile.getSpendingList();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCategory() == category) {
				list.get(i).setAmount(amount); 
				break; //End loop once object with matching category type is found
			}
		}
	}
	
	
	
}
