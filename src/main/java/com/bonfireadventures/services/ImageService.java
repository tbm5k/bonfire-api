package com.bonfireadventures.services;

import com.bonfireadventures.entities.Hotel;
import com.bonfireadventures.entities.Image;
import com.bonfireadventures.repositories.ImageRepo;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private HotelService hotelService;

    public Image addImage(Hotel hotel, Image image) {
        image.setHotel(hotel);
        return imageRepo.save(image);
    }

    public Image getImage(int hotelId, int imageId) {
        if(hotelService.exists(hotelId)){
            return imageRepo.findById(imageId).get();
        }
        return null;
    }

    public String cloudStorage(MultipartFile fileName) throws IOException {

        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/bonfire-adventures-339612-1d713623ba3c.json"));

        //instantiate the client
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        //storing an image into the bucket
        BlobInfo blob = storage.create(BlobInfo.newBuilder("bonfire-adventure-bucket", fileName.getOriginalFilename())
                .setContentType(fileName.getContentType())
                .setAcl(new ArrayList<>(List.of(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))))
                .build(),
                fileName.getInputStream());

        //return the url to the file
        return "https://storage.googleapis.com/bonfire-adventure-bucket/" + fileName.getOriginalFilename() ;
    }
}
