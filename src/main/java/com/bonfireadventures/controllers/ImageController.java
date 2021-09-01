package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.Image;
import com.bonfireadventures.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(method = RequestMethod.POST, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}/image")
    public void addImage(@PathVariable int hotelId, @RequestBody Image image){
        imageService.addImage(hotelId, image);
    }

    @RequestMapping(method = RequestMethod.GET, value = "//continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}/image/{imageId}")
    public Image getImage(@PathVariable int hotelId, @PathVariable int imageId){
        return imageService.getImage(hotelId, imageId);
    }
}
