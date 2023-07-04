package Exceptions;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthUtil {
    private static final String EMAIL_REGEX = "^(.+)@(\\S+)$";
    static boolean login(String login, String pwd, String pwd2 ) throws LoginException{

        if(StringUtils.isBlank(login)){
            throw new LoginException("Invalid login " +" "+ login);
        }

        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(login);
        matcher.matches();
        if(!matcher.matches()){
            throw new LoginException("Invalid email"+login);
        }
        if(!pwd.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
        {
            throw new LoginException("Password rules: " +
                    "1.        Password must contain at least one digit [0-9].\n" +
                    "2.               Password must contain at least one lowercase Latin character [a-z].\n" +
                    "3.        Password must contain at least one uppercase Latin character [A-Z].\n" +
                    "4.               Password must contain at least one special character like ! @ # & ( ).\n" +
                    "5.                Password must contain a length of at least 8 characters and a maximum of 20 characters.");
        }
        if(!pwd.equals(pwd2)){
            throw new LoginException("Password are not equal");
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("App begin.");

        String login = "test@gmail";
        String pwd = "Kl12@iLo";
        String pwd2 = "Kl12@iLo";
        login(login, pwd, pwd2);
        System.out.println(login+"\n"+pwd+"\n"+pwd2);

        System.out.println("App end.");
    }
}
class LoginException extends RuntimeException {
    public LoginException(){
        super("Login error");
    }

    public LoginException(String details){
        super(details);
    }

    public LoginException(String details, Exception cause){
        super(details, cause);
    }
}

