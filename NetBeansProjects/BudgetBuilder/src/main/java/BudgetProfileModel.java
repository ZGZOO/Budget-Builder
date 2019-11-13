
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
public class BudgetProfileModel implements Iterable {
    private ArrayList<BudgetProfile> profileList;
    private BudgetProfile profile;

    public BudgetProfileModel() {
        profileList = new ArrayList<BudgetProfile>();
    }

    public void createNewProfile(String userName, String password) {
        profile = new BudgetProfile(userName, password);
        profileList.add(profile);
    }
    
    public BudgetProfile getProfile(){
        return this.profile;
    }

    //returns profile if found, null if not found
    public BudgetProfile findProfile(String userName, String password) {
        Iterator<BudgetProfile> it = iterator();
        BudgetProfile budgetProfile = null;
        boolean profileFound = false;

        while (it.hasNext()) {
            budgetProfile = it.next();
            if (budgetProfile.getUserName().compareTo(userName) == 0) {
                if (budgetProfile.getPassword().compareTo(password) == 0) {
                    profileFound = true;
                    break; //matching profile found
                }
            }
        }

        //checkpoint
        if (profileFound == false) {
            budgetProfile = null;
        }

        return budgetProfile;
    }

    public Iterator<BudgetProfile> iterator() {
        return profileList.iterator();
    }
}
