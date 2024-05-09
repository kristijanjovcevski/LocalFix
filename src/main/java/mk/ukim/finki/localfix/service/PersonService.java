package mk.ukim.finki.localfix.service;

import mk.ukim.finki.localfix.model.Person;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface PersonService extends UserDetailsService {

    Person register(String username, String email, String password, String repeatPassword);

    Person login(String email, String password);

    Person findByUsername(String username);
}
