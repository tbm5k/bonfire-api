package com.bonfireadventures.services;

import com.bonfireadventures.entities.Continent;
import com.bonfireadventures.repositories.ContinentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
