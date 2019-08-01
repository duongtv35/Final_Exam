package com.codegym.cms.repository;

import com.codegym.cms.model.City;
import com.codegym.cms.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City,Long> {
    Iterable<City>findAllByCountry(Country country);
}
