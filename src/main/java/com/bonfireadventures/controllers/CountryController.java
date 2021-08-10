package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.Country;
import com.bonfireadventures.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.POST, value = "/country")
    public void addCountry(@RequestBody Country country){
        System.out.println(country.toString());
        countryService.addCountry(country);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/country")
    public Country getCountry(@PathVariable int id){
        return countryService.getCountry(id);
    }
}
