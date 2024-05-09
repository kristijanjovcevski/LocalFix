package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.Administrator;
import mk.ukim.finki.localfix.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Long> {

    Optional<Administrator> findByPerson(Person person);
}
