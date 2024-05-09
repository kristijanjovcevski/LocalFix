package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByPerson(Person person);
}
