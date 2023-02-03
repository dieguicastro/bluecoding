package com.spring.bluecoding.service;


import com.spring.bluecoding.entity.ShortUrl;
import com.spring.bluecoding.repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {
    @Autowired
    private UrlRepo urlRepo;
    public String saveUrl(String url){

   /*
   byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);


         */
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();

        String generatedString2 = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


//        String generatedString = new String(array, StandardCharsets.);

        ShortUrl su =  new ShortUrl(url,generatedString2,0);
        urlRepo.save(su);
        return generatedString2;
    }

    public String getUrl(String  shortUrl){
        return urlRepo.findByShortUrl(shortUrl)
                .map(s ->{
                    s.setClicks(s.getClicks() + 1);
                    urlRepo.save(s);
                    return s.getUrl();
                })
                .orElse( null );
    }

    public Optional<List<ShortUrl>> getFrequently(){
        return urlRepo.findFrequently();
    }




}
