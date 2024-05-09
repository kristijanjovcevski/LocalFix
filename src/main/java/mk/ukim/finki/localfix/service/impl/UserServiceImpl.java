package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.User;
import mk.ukim.finki.localfix.model.exceptions.UserNotFoundException;
import mk.ukim.finki.localfix.repository.UserRepository;
import mk.ukim.finki.localfix.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }

    @Override
    @Transactional
    public User findUserByPerson(Person person) {
        return this.userRepository.findByPerson(person).orElseThrow(() ->
                new UserNotFoundException(person.getId()));
    }
}
