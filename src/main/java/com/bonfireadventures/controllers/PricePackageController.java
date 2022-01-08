package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.PricePackage;
import com.bonfireadventures.services.PricePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PricePackageController {

    @Autowired
    private PricePackageService pricePackageService;

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}"
    )
    public ResponseEntity<PricePackage> addPackage(@RequestBody PricePackage pricePackage, @PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId, @PathVariable int hotelId){
        return ResponseEntity.ok().body(
                pricePackageService.addPackage(pricePackage, continentId, countryId, cityId, hotelId)
        );
    }

}
