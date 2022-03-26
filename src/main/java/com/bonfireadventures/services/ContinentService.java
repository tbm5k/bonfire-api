package com.bonfireadventures.services;

import com.bonfireadventures.entities.Continent;
import com.bonfireadventures.entities.Country;
import com.bonfireadventures.repositories.ContinentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ContinentService {

    @Autowired
    private ContinentRepo continentRepo;

    public void addContinent(Continent continent) {
        continentRepo.save(continent);
    }

    public Continent getContinent(int id) {
        return continentRepo.findById(id).get();
    }

    public List<Continent> getAllContinents() {
        return (List<Continent>) continentRepo.findAll();
    }

    public boolean exists(int continentId) {
        return continentRepo.existsById(continentId);
    }

    public List<Country> getAllCountries(int id) {
        return getContinent(id).getCountryList();
    }

    public void deleteContinent(int id) {
        continentRepo.deleteByContinentId(id);
    }
}
