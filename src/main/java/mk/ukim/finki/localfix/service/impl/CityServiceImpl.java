package mk.ukim.finki.localfix.service.impl;

import mk.ukim.finki.localfix.model.City;
import mk.ukim.finki.localfix.model.exceptions.CityNotFoundException;
import mk.ukim.finki.localfix.repository.CityRepository;
import mk.ukim.finki.localfix.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public List<City> listAllCities() {
        return this.cityRepository.findAll();
    }

    @Override
    public City findCityById(Long id) {
        return this.cityRepository.findById(id).orElseThrow(() ->
                new CityNotFoundException(id));
    }
}
