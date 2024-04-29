package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.User;
import mk.ukim.finki.localfix.model.exceptions.UserNotFoundException;
import mk.ukim.finki.localfix.repository.UserRepository;
import mk.ukim.finki.localfix.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException(id));
    }
}
