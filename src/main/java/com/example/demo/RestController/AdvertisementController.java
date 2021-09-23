package com.example.demo.RestController;

import java.util.List;

import com.example.demo.model.Advertisement;
import com.example.demo.repository.AdvertisementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/crack")
public class AdvertisementController {
    
    @Autowired
    AdvertisementRepository advertisementRepository;

    @PostMapping(value = "/advertisement")
    public Advertisement saveAdvertisement(@RequestBody String advert) {
        System.out.println(advert);
        Advertisement advertisement2 = new Advertisement();
        advertisement2.setProduct_link(advert);
        return advertisementRepository.save(advertisement2);
    }

    @GetMapping(value = "/advertisement")
    public List<Advertisement> getAllAdv() {
        return advertisementRepository.findAll();
    }
}
