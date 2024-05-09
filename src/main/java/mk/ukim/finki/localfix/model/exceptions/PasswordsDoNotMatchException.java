package mk.ukim.finki.localfix.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("Password does not match");
    }
}
