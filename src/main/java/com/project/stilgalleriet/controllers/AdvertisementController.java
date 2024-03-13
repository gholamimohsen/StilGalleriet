package com.project.stilgalleriet.controllers;


import com.project.stilgalleriet.dto.AdvertisementDTO;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.services.AdvertisementService;
import com.project.stilgalleriet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
        Advertisement advertisement = advertisementService.createAdvertisement(advertisementDTO);
        return ResponseEntity.ok(advertisement);
    }

    @GetMapping("/all")
    public List<Advertisement> getAllAdvertisements(){
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable String id){
        Optional<Advertisement> advertisment= advertisementService.getAdvertisementById(id);
        return advertisment.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());

    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAdvertisement(@PathVariable String id){
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.ok("Advertisement with id " + id + " has been deleted ");
    }

    //POST  new advertisement
   /* @PostMapping("/add")
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

    }







    /*NEW CODES WITH DTO CLASSES
    //POST a new advertisement
    @PostMapping("/createAdvertisement")
    public ResponseEntity<Advertisement> creatAdvertisement(@Valid @RequestBody AdvertisementDTO advertisementDTO){
        Advertisement newAdvertisement= advertisementService.createAdvertisement(advertisementDTO);
        return new ResponseEntity<>(newAdvertisement, HttpStatus.CREATED);
    }

     //GET all advertisements

    @GetMapping("/allAdvertisements")
    public ResponseEntity< List< Advertisement>> getAllAdvertisments(){
       List <AdvertisementResponse> advertisements=advertisementService.getAllAdvertisements();
       return ResponseEntity.ok(advertisements);
    }

    //GET an advertisment by id
    @GetMapping("/{advertisementId}")
    public ResponseEntity<List<Advertisement>> getAdvertisementById(@PathVariable String advertisementId){
       List <AdvertisementResponse> advertisements=advertisementService.getAdvertisementById(advertisementId);

       return ResponseEntity.ok(advertisements);

        /*Optional<Advertisement> advertisement= advertisementService.getAdvertisementById(id);
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
    */
}



