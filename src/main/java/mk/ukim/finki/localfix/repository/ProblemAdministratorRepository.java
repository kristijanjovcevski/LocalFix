package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.Problem_Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemAdministratorRepository extends JpaRepository<Problem_Administrator, Long> {
}
