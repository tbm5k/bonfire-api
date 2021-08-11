package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Country;
import com.bonfireadventures.services.ContinentService;
import com.bonfireadventures.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private ContinentService continentService;

    @RequestMapping(method = RequestMethod.POST, value = "/continent/{continentId}/country")
    public void addCountry(@PathVariable int continentId, @RequestBody Country country){
        country.setContinent(continentService.getContinent(continentId));
        countryService.addCountry(country);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}")
    public Country getCountry(@PathVariable int continentId, @PathVariable int countryId){
        if(!continentService.exists(continentId)){
            //breaking out the method if the continent doesn't exist
            System.out.println("Error");
            return null;
        }
        return countryService.getCountry(countryId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}/cities")
    public List<City> getCities(@PathVariable int continentId, @PathVariable int countryId){
        return countryService.getCities(continentId, countryId);
    }
}
