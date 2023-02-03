package com.spring.bluecoding.controller;

import com.spring.bluecoding.entity.ShortUrl;
import com.spring.bluecoding.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/short")
public class UrlShort {

    @Autowired
    private UrlService urlService;

    @PostMapping("/{url}")
    public ResponseEntity<String> saveUrl(@PathVariable("url") String url){
        return new ResponseEntity<String>(urlService.saveUrl(url), HttpStatus.CREATED);
    }

    @GetMapping("/{url}")
    public ResponseEntity<String> getUrl(@PathVariable("url") String shortUrl){
        return new ResponseEntity<String>(urlService.getUrl(shortUrl),HttpStatus.OK);
    }

    @GetMapping("/frequently")
    public ResponseEntity<List<ShortUrl>> getFrequently(String shortUrl){
        return urlService.getFrequently()
                .map( s -> new ResponseEntity<>(s,HttpStatus.OK) )
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
