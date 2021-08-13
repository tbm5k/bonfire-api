package com.bonfireadventures.services;

import com.bonfireadventures.entities.Image;
import com.bonfireadventures.repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private HotelService hotelService;

    public void addImage(int hotelId, Image image) {
        if(hotelService.exists(hotelId)){
            imageRepo.save(image);
        }
    }

    public Image getImage(int hotelId, int imageId) {
        if(hotelService.exists(hotelId)){
            return imageRepo.findById(imageId).get();
        }
        return null;
    }
}
