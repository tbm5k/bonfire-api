package com.bonfireadventures.services;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.entities.Image;
import com.bonfireadventures.exceptions.NotFoundException;
import com.bonfireadventures.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public boolean exists(int hotelId) {
        return hotelRepo.existsById(hotelId);
    }

    public List<Image> getImages(int hotelId) {
        if(hotelRepo.existsById(hotelId)){
            return hotelRepo.findById(hotelId).get().getImageList();
        }
        return null;
    }

    public List<Hotel> getHotels(int continentId, int countryId, int cityId) {
        City city = cityService.getCity(continentId, countryId, cityId);
        List<Hotel> hotels = city.getHotelList();
        return hotels;
    }

    public void addHotel(Hotel hotel) {
        hotelRepo.save(hotel);
    }
}
