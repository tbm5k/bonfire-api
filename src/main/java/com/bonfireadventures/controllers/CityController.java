package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.POST, value = "/continent/{continentId}/country/{countryId}/city")
    public void addCity(@PathVariable int continentId, @PathVariable int countryId, @RequestBody City city){
        cityService.addCity(continentId, countryId, city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}/city/{cityId}")
    public City getCity(@PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId){
        return cityService.getCity(continentId, countryId, cityId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotels")
    public List<Hotel> getHotels(@PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId){
        return cityService.getHotels(continentId, countryId, cityId);
    }
}
