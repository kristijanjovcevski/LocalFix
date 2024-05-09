package mk.ukim.finki.localfix.model.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException() {
        super("email already exists exception");
    }
}
