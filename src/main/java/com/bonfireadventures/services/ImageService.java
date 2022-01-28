package com.bonfireadventures.services;

import com.bonfireadventures.entities.Image;
import com.bonfireadventures.repositories.ImageRepo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public void cloudStorage() throws Exception{
        //instantiate the client
        Storage storage = StorageOptions.getDefaultInstance().getService();

        //new bucket name
        String bucketName = "bonfire-adventures-bucket";

        //create bucket
        Bucket bucket = storage.create(BucketInfo.of(bucketName));

        System.out.println(bucket.getName());

    }
}
