package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.Institution;
import mk.ukim.finki.localfix.repository.InstitutionRepository;
import mk.ukim.finki.localfix.service.InstitutionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> listAllInstitutions() {
        return this.institutionRepository.findAll();
    }
}
