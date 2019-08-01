package com.codegym.cms.service;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Country;

public interface CityService {
    Iterable<City>findALl();
    City findById(Long id);
    void save(City city);
    void remove(Long id);
    Iterable<City> findAllByCountry(Country country);
}
