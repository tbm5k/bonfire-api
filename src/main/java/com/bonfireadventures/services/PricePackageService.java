package com.bonfireadventures.services;

import com.bonfireadventures.entities.PricePackage;
import com.bonfireadventures.exceptions.NotFoundException;
import com.bonfireadventures.repositories.PricePackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricePackageService {

    @Autowired
    private PricePackageRepo pricePackageRepo;

    public PricePackage addPricePackage(PricePackage pricePackage) {
        PricePackage pkg = null;
        try{
            pkg = pricePackageRepo.save(pricePackage);
        }catch (NotFoundException e){
            e.printStackTrace();
        }
        return pkg;
    }
}
