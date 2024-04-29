package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.Problem_Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemAdministratorRepository extends JpaRepository<Problem_Administrator, Long> {

    List<Problem_Administrator> findAllByAdministratorId(Long administratorId);

    void deleteByProblemId (Long problemId);

    Problem_Administrator findByProblemId(Long problemId);
}
