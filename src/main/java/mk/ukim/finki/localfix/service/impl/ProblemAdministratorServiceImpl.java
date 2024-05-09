package mk.ukim.finki.localfix.service.impl;

import javax.transaction.Transactional;
import mk.ukim.finki.localfix.model.Problem_Administrator;
import mk.ukim.finki.localfix.repository.ProblemAdministratorRepository;
import mk.ukim.finki.localfix.repository.ProblemRepository;
import mk.ukim.finki.localfix.service.ProblemAdministratorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemAdministratorServiceImpl implements ProblemAdministratorService {

    private final ProblemAdministratorRepository problemAdministratorRepository;
    private final ProblemRepository problemRepository;

    public ProblemAdministratorServiceImpl(ProblemAdministratorRepository problemAdministratorRepository,
                                           ProblemRepository problemRepository) {
        this.problemAdministratorRepository = problemAdministratorRepository;
        this.problemRepository = problemRepository;
    }

    @Override
    public List<Problem_Administrator> listAllProblemAdministrators() {
        return this.problemAdministratorRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteProblemAdministrator(Long id) {


        this.problemRepository.deleteById(id);


    }

    @Override
    public Problem_Administrator create(Problem_Administrator problemAdministrator) {
        return this.problemAdministratorRepository.save(
                new Problem_Administrator(problemAdministrator.getAdministrator(),
                        problemAdministrator.getProblem())
        );
    }
}
