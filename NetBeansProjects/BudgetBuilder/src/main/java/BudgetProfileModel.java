
import java.util.ArrayList;
import java.util.Iterator;

public class BudgetProfileModel implements Iterable {
    private static BudgetProfileModel singleton = new BudgetProfileModel();
    private ArrayList<BudgetProfile> profileList = new ArrayList<BudgetProfile>(10);

    private BudgetProfileModel() {
    }

    public static void createNewProfile(String userName, String password) {
        singleton.profileList.add(new BudgetProfile(userName, password));
    }

    public static BudgetProfileModel getSingleton() {
        return singleton;
    }

    //returns profile if found, null if not found
    public BudgetProfile findProfile(String userName, String password) {
        Iterator<BudgetProfile> it = iterator();
        BudgetProfile budgetProfile = null;
        boolean profileFound = false;

        while(it.hasNext()) {
            budgetProfile = it.next();
            if (budgetProfile.getUserName().compareTo(userName) == 0) {
                if (budgetProfile.getPassword().compareTo(password) == 0) {
                    profileFound = true;
                    break; //matching profile found
                }
            }
        }

        //checkpoint
        if (profileFound) {
            return budgetProfile;
        }

        System.out.println("Couldn't find User Profile");
        return null;
    }

    public Iterator<BudgetProfile> iterator() {
        return singleton.profileList.iterator();
    }
}