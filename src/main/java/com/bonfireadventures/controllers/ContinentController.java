package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.Continent;
import com.bonfireadventures.entities.Country;
import com.bonfireadventures.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @RequestMapping(method = RequestMethod.POST, value = "/continent")
    public void addContinent(@RequestBody Continent continent){
        continentService.addContinent(continent);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{id}")
    public Continent getContinent(@PathVariable int id){
        return continentService.getContinent(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent")
    public List<Continent> getAllContinents(){
        return continentService.getAllContinents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{id}/countries")
    public List<Country> getAllCountries(@PathVariable int id){
        return continentService.getAllCountries(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/continent/{id}")
    public ResponseEntity<String> deleteContinent(@PathVariable int id){
        continentService.deleteContinent(id);
        return ResponseEntity.ok().body("Deleted");
    }
}
