package com.bonfireadventures.services;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CountryService countryService;

    public void addCity(int continentId, int countryId, City city) {
        if(continentService.exists(continentId) && countryService.exists(countryId)){
            city.setCountry(countryService.getCountry(countryId));
            cityRepo.save(city);
        }else{
            return;
        }
    }

    public City getCity(int continentId, int countryId, int cityId) {
        if(continentService.exists(continentId) && countryService.exists(countryId) && cityRepo.existsById(cityId)){
            return cityRepo.findById(cityId).get();
        }else {
            return null;
        }
    }

    public boolean exists(int cityId) {
        return cityRepo.existsById(cityId);
    }

    public List<Hotel> getHotels(int continentId, int countryId, int cityId) {
        if(continentService.exists(continentId) && countryService.exists(countryId) && cityRepo.existsById(cityId)){
            return cityRepo.findById(cityId).get().getHotelList();
        }
        return null;
    }
}
