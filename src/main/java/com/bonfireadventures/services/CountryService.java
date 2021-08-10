package com.bonfireadventures.services;

import com.bonfireadventures.entities.Country;
import com.bonfireadventures.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    public void addCountry(Country country) {
        countryRepo.save(country);
    }

    public Country getCountry(int id) {
        return countryRepo.findById(id).get();
    }
}
