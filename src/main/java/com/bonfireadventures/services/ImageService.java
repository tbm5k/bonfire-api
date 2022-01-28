package com.bonfireadventures.services;

import com.bonfireadventures.entities.Image;
import com.bonfireadventures.repositories.ImageRepo;
import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepo imageRepo;
    @Autowired
    private HotelService hotelService;
    @Value("${GOOGLE_APPLICATION_CREDENTIALS}")
    private String GOOGLE_APPLICATION_CREDENTIALS;

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

    @Bean
    public void cloudStorage() throws IOException {

        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream("src/main/resources/bonfire-adventures-339612-1d713623ba3c.json"));

        //instantiate the client
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

        //create bucket
        Bucket bucket = storage.create(BucketInfo.of("bonfire-adventures-safari-bucket"));

        System.out.println(bucket.getName());

    }
}
