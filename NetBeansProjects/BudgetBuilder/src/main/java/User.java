public class User {

    static int numOfObjects = 0;
    private int id;
    private String name;
    private String password;

    public User (String name, String password) {
        this.name = name;
        this.password = password;
        this.id = numOfObjects + 1;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
