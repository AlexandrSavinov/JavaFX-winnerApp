package Controllers;

public class UserStore {
    private static String name;
    private static String password;
    private static String filename;

    public UserStore(String name, String password, String filename) {
        this.name = name;
        this.password = password;
        this.filename = filename;
    }

    public UserStore() {
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFilename() {
        return filename;
    }

    public void setParam(String username, String password, String filename) {
        this.name = username;
        this.password = password;
        this.filename = filename;
    }
}
