package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.Administrator;
import mk.ukim.finki.localfix.model.exceptions.AdministratorNotFoundException;
import mk.ukim.finki.localfix.repository.AdministratorRepository;
import mk.ukim.finki.localfix.service.AdministratorService;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator findById(Long administratorId) {
        return this.administratorRepository.findById(administratorId)
                .orElseThrow(() -> new AdministratorNotFoundException(administratorId));
    }
}
