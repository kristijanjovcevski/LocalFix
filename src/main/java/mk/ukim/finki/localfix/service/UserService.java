package mk.ukim.finki.localfix.service;

import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.User;

public interface UserService {

    User findById(Long id);

    User findUserByPerson(Person person);
}
