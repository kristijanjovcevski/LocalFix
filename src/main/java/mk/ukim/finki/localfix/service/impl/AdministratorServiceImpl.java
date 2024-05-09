package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.Administrator;
import mk.ukim.finki.localfix.model.Person;
import mk.ukim.finki.localfix.model.exceptions.AdministratorNotFoundException;
import mk.ukim.finki.localfix.repository.AdministratorRepository;
import mk.ukim.finki.localfix.service.AdministratorService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    @Transactional
    public Administrator findByPerson(Person person) {
        return this.administratorRepository.findByPerson(person)
                .orElseThrow(() -> new AdministratorNotFoundException(person.getId()));
    }
}
