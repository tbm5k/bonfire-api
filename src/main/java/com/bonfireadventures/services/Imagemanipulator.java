package com.bonfireadventures.services;
import com.tinify.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class Imagemanipulator {


    @Value("${key.tinify}")
    private String tinifyKey;

    public void compress(){

        Tinify.setKey(tinifyKey);

        Source source = Tinify.fromUrl("https://tinypng.com/images/panda-happy.png");
        Source copyrighted = source.preserve("copyright", "creation");

        try{
            copyrighted.toFile("resized.png");
            System.out.println(copyrighted);
        }catch (ClientException | IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
