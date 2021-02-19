package Controllers;

import java.util.HashSet;
import java.util.Set;

public class UserStore {

    private Set<String> userList;

    public UserStore() {
        userList = new HashSet<>();
    }

    public Set<String> addUser(String username, String password,String filename){
        userList.add(username);
        userList.add(password);
        userList.add(filename);
        return userList;
    }

}
