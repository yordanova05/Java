package week10.model;

public class Secretary {
    private String username;
    private String password;

    public Secretary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}
