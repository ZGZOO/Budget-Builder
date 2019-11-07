import java.util.ArrayList;
import java.util.Iterator;

public class BudgetProfileModel implements Iterable {
	ArrayList<BudgetProfile> profileList;
	
	public BudgetProfileModel() {
		 profileList = new ArrayList<BudgetProfile>();
	}
	
	public void createNewProfile(String userName, String password) {
		 profileList.add(new BudgetProfile(userName, password));
	}
	
	
	//returns profile if found, null if not found
	public BudgetProfile findProfile(String userName, String password) {
		Iterator<BudgetProfile> it = iterator();
		BudgetProfile budgetProfile = null;
		boolean profileFound = false;
		
		while(it.hasNext()) {
			budgetProfile = it.next();
			if(budgetProfile.getUserName().compareTo(userName) == 0) 
			{
				if(budgetProfile.getPassword().compareTo(password) == 0)
				{
					profileFound = true;
					break; //matching profile found
				}
			}
		}
		
		//checkpoint
		if(profileFound == false) {
			budgetProfile = null;
		}
	
		return budgetProfile;
	}
	
	public Iterator<BudgetProfile> iterator() {
		return profileList.iterator();
	}
}
