package com.bonfireadventures.controllers;

import com.bonfireadventures.entities.Image;
import com.bonfireadventures.services.HotelService;
import com.bonfireadventures.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private HotelService hotelService;

    @RequestMapping(method = RequestMethod.POST, value = "/continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}/image")
    public void addImage(@PathVariable int hotelId, @RequestBody Image image, @PathVariable int continentId, @PathVariable int countryId, @PathVariable int cityId){
        imageService.addImage(hotelService.getHotel(continentId, countryId, cityId, hotelId), image);
    }

    @RequestMapping(method = RequestMethod.GET, value = "//continent/{continentId}/country/{countryId}/city/{cityId}/hotel/{hotelId}/image/{imageId}")
    public Image getImage(@PathVariable int hotelId, @PathVariable int imageId){
        return imageService.getImage(hotelId, imageId);
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public String addImage(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.cloudStorage(file);
    }
}
