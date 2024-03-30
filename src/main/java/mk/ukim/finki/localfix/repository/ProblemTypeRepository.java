package mk.ukim.finki.localfix.repository;

import mk.ukim.finki.localfix.model.ProblemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemTypeRepository extends JpaRepository<ProblemType,Long> {
}
