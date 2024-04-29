package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator,Long> {


}
