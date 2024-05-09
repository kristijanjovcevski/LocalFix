package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.User;
import mk.ukim.finki.localfix.model.enums.Role;
import mk.ukim.finki.localfix.model.exceptions.EmailAlreadyExistsException;
import mk.ukim.finki.localfix.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.localfix.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.localfix.model.exceptions.UsernameAlreadyExistsException;
import mk.ukim.finki.localfix.repository.PersonRepository;
import mk.ukim.finki.localfix.repository.UserRepository;
import mk.ukim.finki.localfix.service.PersonService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public PersonServiceImpl(PersonRepository personRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public Person register(String username, String email, String password, String repeatPassword) {
        if(username.equals("") || email.equals("") || password.equals("")){
            throw new InvalidArgumentsException();
        }
        if(!password.equals(repeatPassword)){
            throw new PasswordsDoNotMatchException();
        }
        if(personRepository.findByEmail(email).isPresent()){
            throw new EmailAlreadyExistsException();
        }
        if(personRepository.findByUsername(username).isPresent()){
            throw new UsernameAlreadyExistsException();
        }
        Person person = personRepository.save(new Person(passwordEncoder.encode(password), email, username, Role.ROLE_USER));
        userRepository.save(new User(person));
        return person;
    }

    @Override
    public Person login(String email, String password) {
        if(email.isEmpty() || password.isEmpty()){
            throw new InvalidArgumentsException();
        }
        return personRepository.findByEmailAndPassword(email, password).orElseThrow(InvalidArgumentsException::new);
    }

    @Override
    public Person findByUsername(String username) {
        return personRepository.findByUsername(username).orElseThrow(null);
    }
}
