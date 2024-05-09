package mk.ukim.finki.localfix.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException() {
        super("invalid user credential");
    }
}
