package Server1;

import java.util.List;

public class LoginRegister {
    private final FileUpdates fileUpdates = new FileUpdates();

    private void registerUser(String username, String password, UserType type){
        List<User> users = fileUpdates.load();
        users.add(UserFactory.createUser(username, password, type));
        fileUpdates.saveUsers(users);
    }

    private User loginUser(String username, String password){
        for (User user: fileUpdates.load()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
}
