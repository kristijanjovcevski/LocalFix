package mk.ukim.finki.localfix.model.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProblemNotFoundException extends RuntimeException{

    public ProblemNotFoundException(Long id) {
        super(String.format("Problem with id %d not found",id));
    }
}
