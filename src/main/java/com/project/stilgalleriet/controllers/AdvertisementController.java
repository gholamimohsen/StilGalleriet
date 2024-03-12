package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    //GET advertisement list only with actives
    @GetMapping("/isActive/{isActive}")
    public ResponseEntity <List<Advertisement>> findAdvertisementByActive(@PathVariable boolean isActive){
         List <Advertisement> advertisementByActive=advertisementService.findAdvertisementByActive(isActive);
         if (!advertisementByActive.isEmpty()){
             return ResponseEntity.ok(advertisementByActive);
         } else {
            return ResponseEntity.notFound().build();
    }

    }

    //GET advertisement list by price less than max price
    @GetMapping("/price/lessthan/{maxPrice}")
    public List<Advertisement> findAdvertisementByPriceLessThan(@PathVariable double maxPrice){
        return advertisementService.findAdvertisementByPriceLessThan(maxPrice);
    }

    //GET advertisement list by price greater than max price
    @GetMapping("/price/greaterthan/{minPrice}")
    public List<Advertisement> findAdvertisementByPriceGreaterThan(@PathVariable double minPrice){
        return advertisementService.findAdvertisementByPriceGreaterThan(minPrice);
    }

    //GET advertisement list by price between min and max price
    @GetMapping("/price/between")
    public List<Advertisement> findAdvertisementByPriceBetween(@RequestParam double minPrice, @RequestParam double maxPrice){
        return advertisementService.findAdvertisementByPriceBetween(minPrice, maxPrice);
    }


    //GET advertisement list by date after created at
     @GetMapping("/date/createdAfter")
    public ResponseEntity <List <Advertisement>> findAdvertisementByCreatedAtAfter(@RequestParam("date") String dateString){ // take date String typ
         try {
             // to convert String to Date format
             SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date startDate=dateFormat.parse(dateString);// requested date
             Date endDate=new Date(); //now
             List<Advertisement> filteredAdvertisementsByDateAfter=advertisementService.findAdvertisementByCreatedAtAfter(startDate, endDate);
             return ResponseEntity.ok(filteredAdvertisementsByDateAfter);
         }catch (ParseException e){

            return ResponseEntity.badRequest().build();
        }

     }

     //GET advertisement list by  created date before the date
    @GetMapping("/date/createdBefore")
    public ResponseEntity <List <Advertisement>> findAdvertisementByCreatedAtBefore(@RequestParam("date") String dateString){

        try {
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            Date startDate=dateFormat.parse(dateString);
            Date endDate= new Date();
            List<Advertisement> filteredAdvertisementByDateBefore=advertisementService.findAdvertisementByCreatedAtBefore(startDate, endDate);
            return  ResponseEntity.ok(filteredAdvertisementByDateBefore);

        } catch (ParseException e){
            return ResponseEntity.badRequest().build();

        }
    }

    }




