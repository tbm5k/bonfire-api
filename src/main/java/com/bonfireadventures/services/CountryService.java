package com.bonfireadventures.services;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Country;
import com.bonfireadventures.repositories.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private ContinentService continentService;

    public void addCountry(Country country) {
        countryRepo.save(country);
    }

    public Country getCountry(int id) {
        return countryRepo.findById(id).get();
    }

    public boolean exists(int countryId) {
        return countryRepo.existsById(countryId);
    }

    public List<City> getCities(int continentId, int countryId) {
        if(continentService.exists(continentId) && countryRepo.existsById(countryId)){
            return countryRepo.findById(countryId).get().getCityList();
        }else {
            return null;
        }
    }
}
