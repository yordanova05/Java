package week7;
import java.util.regex.*;

public interface Validator {
    public static final Pattern VALID_MAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    public boolean checking(String nickName);
}
