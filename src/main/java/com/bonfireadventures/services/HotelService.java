package com.bonfireadventures.services;

import com.bonfireadventures.entities.City;
import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.entities.Image;
import com.bonfireadventures.repositories.HotelRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
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
    @Autowired
    private ImageService imageService;

    public Hotel addHotel(int continentId, int countryId, int cityId, Hotel hotel, List<MultipartFile> files) {
        if(continentService.exists(continentId) && countryService.exists(countryId) && cityService.exists(cityId)){
            List<Image> imagesUrl = new ArrayList<>();
            hotel.setCity(cityService.getCity(continentId, countryId, cityId));
            Hotel savedHotel = hotelRepo.save(hotel);
            try {
                for(MultipartFile file: files){
                    Image image = new Image(imageService.cloudStorage(file));
                    imagesUrl.add(imageService.addImage(savedHotel, image));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            hotel.setImageList(imagesUrl);
            return hotelRepo.save(savedHotel);
        }
        return null;
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

    public Hotel makeOffer(int continentId, int countryId, int cityId, int hotelId) {
        Hotel updated = getHotel(continentId, countryId, cityId, hotelId);
        updated.setOffer(true);
        return hotelRepo.save(updated);
    }

    public Hotel getJson(String hotel){
        Hotel jsonData = new Hotel();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonData = objectMapper.readValue(hotel, Hotel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}
