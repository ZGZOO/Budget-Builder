public class User {

    private static String name = "";
    private static String password = "";
    private static User singleton = new User(name, password);

    private User(String name, String password) {
        singleton.name = name;
        singleton.password = password;
    }

    public static void setUser(String name, String password) {
        singleton.name = name;
        singleton.password = password;
    }

    public static User getSingleton() {
        if (singleton == null) {
            singleton = new User(name, password);
        }
        return singleton;
    }

    public String getName() {
        return singleton.name;
    }

    public String getPassword() {
        return singleton.password;
    }

    public static void setName(String name) {
        if (singleton != null) singleton.name = name;
    }

    public static void setPassword(String password) {
        if (singleton != null) singleton.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
