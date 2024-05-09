package mk.ukim.finki.localfix.service;

import mk.ukim.finki.localfix.model.Administrator;
import mk.ukim.finki.localfix.model.Person;

public interface AdministratorService {

    Administrator findByPerson(Person person);

}
