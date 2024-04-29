package mk.ukim.finki.localfix.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class InstitutionNotFoundException extends RuntimeException{
    public InstitutionNotFoundException(Long id) {
        super(String.format("Institution with id %d not found",id));
    }
}
