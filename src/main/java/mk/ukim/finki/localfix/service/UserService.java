package mk.ukim.finki.localfix.service;

import mk.ukim.finki.localfix.model.User;

public interface UserService {

    User findUserById(Long id);
}
