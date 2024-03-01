package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {
    @Autowired
     private AdvertisementService advertisementService;

    //POST a new advertisement
    @PostMapping("/createAdvertisement")
    public ResponseEntity<Advertisement> creatAdvertisement(@Valid @RequestBody Advertisement advertisement){
        Advertisement newAdvertisement= advertisementService.createAdvertisement(advertisement);
        return new ResponseEntity<>(newAdvertisement, HttpStatus.CREATED);
    }

     //GET all advertisements

    @GetMapping("/allAdvertisements")
    public List<Advertisement> getAllAdvertisment(){
        return advertisementService.getAllAdvertisements();
    }

    //GET an advertisment by id
    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable String id){
        Optional<Advertisement> advertisement= advertisementService.getAdvertisementById(id);
        return advertisement.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

//DELETE by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdvertisement(@PathVariable String id){
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.ok("Advertisement with id " + id + "has been deleted");
    }

//UPDATE an advertisement
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdvertisement(@PathVariable String id, @Valid @RequestBody Advertisement advertisementDetails){
        try {
            Advertisement updatedAdvertisement= advertisementService.updatedAdvertisement(id,advertisementDetails);
            return ResponseEntity.ok(updatedAdvertisement);
        } catch (Exception e){ //EntityNotFoundException ska skapas???
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


}
