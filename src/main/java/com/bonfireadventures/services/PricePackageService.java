package com.bonfireadventures.services;

import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.entities.PricePackage;
import com.bonfireadventures.repositories.PricePackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricePackageService {

    @Autowired
    private PricePackageRepo pricePackageRepo;
    @Autowired
    private HotelService hotelService;

    public PricePackage addPackage(PricePackage pricePackage, int continentId, int countryId, int cityId, int hotelId){
        Hotel hotel = hotelService.getHotel(continentId, countryId, cityId, hotelId);
        pricePackage.setHotel(hotel);
        return pricePackageRepo.save(pricePackage);
    }
}
