package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.Problem;
import mk.ukim.finki.localfix.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem,Long> {

    List<Problem> findAllByCityIdAndStatus(Long cityId, Status status);
}
