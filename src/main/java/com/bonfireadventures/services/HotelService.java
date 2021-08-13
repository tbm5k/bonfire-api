package com.bonfireadventures.services;

import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepo hotelRepo;
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;

    public void addHotel(int continentId, int countryId, int cityId, Hotel hotel) {
        if(continentService.exists(continentId) && countryService.exists(countryId) && cityService.exists(cityId)){
            hotel.setCity(cityService.getCity(continentId, countryId, cityId));
            hotelRepo.save(hotel);
        }
    }

    public Hotel getHotel(int continentId, int countryId, int cityId, int hotelId) {
        if(continentService.exists(continentId) && countryService.exists(countryId) && cityService.exists(cityId) && hotelRepo.existsById(hotelId)){
            return hotelRepo.findById(hotelId).get();
        }
        return null;
    }
}
