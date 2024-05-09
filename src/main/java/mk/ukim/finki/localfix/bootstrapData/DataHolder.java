package mk.ukim.finki.localfix.bootstrapData;

import mk.ukim.finki.localfix.model.Administrator;
import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.enums.Role;
import mk.ukim.finki.localfix.repository.AdministratorRepository;
import mk.ukim.finki.localfix.repository.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataHolder {

    private final PersonRepository personRepository;
    private final AdministratorRepository administratorRepository;
    private final PasswordEncoder passwordEncoder;

    public DataHolder(PersonRepository personRepository, AdministratorRepository administratorRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /*@PostConstruct
    public void initAdminPersons(){
        Person person = personRepository.save(new Person(passwordEncoder.encode("admin"), "admin@gmail.com",
                "Admin", Role.ADMIN));
        administratorRepository.save(new Administrator(person));
    }*/
}
