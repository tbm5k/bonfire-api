package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.PricePackage;
import com.bonfireadventures.services.HotelService;
import com.bonfireadventures.services.PricePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class PricePackageController {

    @Autowired
    private PricePackageService pricePackageService;
    @Autowired
    private HotelService hotelService;

    @RequestMapping(method = RequestMethod.POST, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}")
    public ResponseEntity<PricePackage> addPricePackage(@RequestBody PricePackage pricePackage, @PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId, @PathVariable int hotelId){
        URI uri = URI.create("/continent/" + continentId +"/country/" + countryId + "/city/" + cityId + "/hotel/" + hotelId);
        pricePackage.setHotelPackage(hotelService.getHotel(continentId, countryId, cityId, hotelId));
        PricePackage response = pricePackageService.addPricePackage(pricePackage);
        return ResponseEntity.created(uri).body(response);
    }
}
