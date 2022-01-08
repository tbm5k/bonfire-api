package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.PricePackage;
import com.bonfireadventures.services.Imagemanipulator;
import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.entities.Image;
import com.bonfireadventures.services.HotelService;
import com.bonfireadventures.services.PricePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private PricePackageService pricePackageService;
    @Autowired
    Imagemanipulator compressor;

    @RequestMapping(method = RequestMethod.POST, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel")
    public ResponseEntity<Hotel> addHotel(@PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId, @RequestBody Hotel hotel){
        Hotel savedHotel = hotelService.addHotel(continentId, countryId, cityId, hotel);
        if(savedHotel == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.status(HttpStatus.OK).body(savedHotel);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}")
    public Hotel getHotel(@PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId, @PathVariable int hotelId){
        return hotelService.getHotel(continentId, countryId, cityId, hotelId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}/images")
    public List<Image> imageList(@PathVariable int hotelId){
        return hotelService.getImages(hotelId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotels")
    public List<Hotel> getHotels(@PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId){
        return hotelService.getHotels(continentId, countryId, cityId);
    }

    @RequestMapping(value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}")
    public ResponseEntity<Hotel> makeOffer(@PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId, @PathVariable int hotelId){
        return ResponseEntity.ok().body(hotelService.makeOffer(continentId, countryId, cityId, hotelId));
    }
}
