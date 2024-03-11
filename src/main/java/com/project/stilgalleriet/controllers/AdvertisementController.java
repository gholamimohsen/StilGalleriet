package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    @Autowired
     private AdvertisementService advertisementService;

    //POST  new advertisement
    @PostMapping("/add")
    public ResponseEntity<Advertisement> addAdvertisement(@RequestBody Advertisement advertisement){
        Advertisement newAdvertisement=advertisementService.addAdvertisement(advertisement);
        return new ResponseEntity<>(newAdvertisement, HttpStatus.CREATED);

    }

    // GET all advertisements
    @GetMapping("/all")
    public List<Advertisement> getAllAdvertisements(){
        return advertisementService.getAllAdvertisements();
    }


    //GET an advertisement by id
    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable String id){
        Optional<Advertisement> advertisment= advertisementService.getAdvertisementById(id);
        return advertisment.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());

    }

    //DELETE an advertisement by id
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAdvertisement(@PathVariable String id){
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.ok("Advertisement with id " + id + " has been deleted ");
    }

    //UPDATE an advertisement by id
    @PutMapping("update/{id}") // need for @valid ??
    public ResponseEntity<Advertisement> updateAdvertisement(@PathVariable String id,@RequestBody Advertisement advertisementDetails){
          try {
              Advertisement updatedAdvertisement = advertisementService.updateAdvertisement(id, advertisementDetails);
              return ResponseEntity.ok(updatedAdvertisement);
          } catch (Exception e)
          {
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
          }
          }

     // GET advertisement list by color
    @GetMapping("/color/{color}")

    public ResponseEntity<List<Advertisement>> findAdvertisementByColor(@PathVariable String color){
        List <Advertisement> advertisementByColor= advertisementService.findAdvertisementByColor(color);
        if (!advertisementByColor.isEmpty()){
            return ResponseEntity.ok(advertisementByColor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //GET advertisement list by gender
    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Advertisement>> findAdvertisementByGender(@PathVariable String gender){
        List<Advertisement> advertisementByGender=advertisementService.findAdvertisementByGender(gender);
        if (!advertisementByGender.isEmpty()){
            return ResponseEntity.ok(advertisementByGender);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    //GET advertisement list by size
    @GetMapping("/size/{size}")
    public ResponseEntity<List<Advertisement>> findAdvertisementBySize(@PathVariable String size){
        List<Advertisement> advertisementBySize=advertisementService.findAdvertisementBySize(size);
        if (!advertisementBySize.isEmpty()){
            return ResponseEntity.ok(advertisementBySize);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //GET advertisement list by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Advertisement>> findAdvertisementByCategory(@PathVariable String category){
        List<Advertisement> advertisementByCategory=advertisementService.findAdvertisementByCategory(category);
        if(!advertisementByCategory.isEmpty()){
            return ResponseEntity.ok(advertisementByCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }







    }




