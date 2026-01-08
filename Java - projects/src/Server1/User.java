package Server1;

import java.io.Serializable;
import java.util.Objects;

public abstract class  User implements Serializable{
    private String username;
    private String password;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public abstract UserType getUserType();
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String userName)
    {
        this.username = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode(){
        return Objects.hash(username, password);
    }
}
