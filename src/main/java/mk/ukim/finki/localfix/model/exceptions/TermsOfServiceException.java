package mk.ukim.finki.localfix.model.exceptions;

public class TermsOfServiceException extends RuntimeException{
    public TermsOfServiceException() {
        super("Must agree in terms of service");
    }
}
