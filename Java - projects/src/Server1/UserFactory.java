package Server1;

import java.util.regex.Pattern;

public class UserFactory {
    private final static Pattern facultyNumber = Pattern.compile("//d{9}");
    private final static Pattern EGN = Pattern.compile("//d{10}");
    private final static Pattern mail = Pattern.compile("[a-z]+@tu-sofia.bg");

    public static User createUser(String username, String password, UserType type) throws CredentialsException{

        switch(type){
            case ADMIN:
                return new Admin(username, password);
            case STUDENT:
                if(facultyNumber.matcher(username).matches() && EGN.matcher(password).matches()){
                    return new Student(username,password);
                }
                else{
                    throw new CredentialsException("Exception occured!");
                }
            case TEACHER:
                if(mail.matcher(username).matches() && password.length() >=5){
                    return new Teacher(username,password);
                }
                else{
                    throw new CredentialsException("Exception occured!");
                }
            default: return null;
        }
    }
}
