package mk.ukim.finki.localfix.service;

import mk.ukim.finki.localfix.model.City;

import java.util.List;

public interface CityService {

    List<City> listAllCities();

    City findCityById(Long id);

}
