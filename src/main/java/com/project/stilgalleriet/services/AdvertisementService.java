package com.project.stilgalleriet.services;

import com.project.stilgalleriet.dto.AdvertisementDTO;
import com.project.stilgalleriet.models.Advertisement;
import com.project.stilgalleriet.models.User;
import com.project.stilgalleriet.repositories.AdvertisementRepository;
import com.project.stilgalleriet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdvertisementService {

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    UserRepository userRepository;

    //create an advertisement
   /* public Advertisement addAdvertisement(Advertisement advertisement){
        return advertisementRepository.save(advertisement);
    }*/

    // create new advertisement
    public Advertisement createAdvertisement(AdvertisementDTO advertisementDTO) {
        User user = userRepository.findById(advertisementDTO.getSellerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        Advertisement newAd = new Advertisement();
        newAd.setUser(user);
        newAd.setTitle(advertisementDTO.getTitle());
        // to add more fields first add the in the AdvertisementDT0
        // then add them here
        return advertisementRepository.save(newAd);
    }


    //get all advertisements
    public List<Advertisement> getAllAdvertisements(){
        return advertisementRepository.findAll();

    }

    //get an advertisement by id
    public Optional<Advertisement> getAdvertisementById(String id){
        return advertisementRepository.findById(id);
    }

    //delete an advertisement

    public void deleteAdvertisement(String id){
        advertisementRepository.deleteById(id);
    }

    //update an advertisement
  /*  public Advertisement updateAdvertisement(String id, Advertisement updatedAdvertisement) throws Exception {
        return advertisementRepository.findById(id)
                .map(existingAdvertisement->{
                    if (updatedAdvertisement.getTitle() !=null){
                        existingAdvertisement.setTitle(updatedAdvertisement.getTitle());
                    }

                    if (updatedAdvertisement.getDescription()!=null){
                        existingAdvertisement.setDescription(updatedAdvertisement.getDescription());
                    }
                     if (updatedAdvertisement.getCategory()!=null){
                         existingAdvertisement.setCategory(updatedAdvertisement.getCategory());
                     }

                    if (updatedAdvertisement.getColor()!=null){
                        existingAdvertisement.setColor(updatedAdvertisement.getColor());
                    }
                    if (updatedAdvertisement.getGender()!=null){
                        existingAdvertisement.setGender(updatedAdvertisement.getGender());
                    }
                    if (updatedAdvertisement.getImgUrl()!=null){
                        existingAdvertisement.setImgUrl(updatedAdvertisement.getImgUrl());
                    }
                    if (updatedAdvertisement.getPrice()!=0.00){
                        existingAdvertisement.setPrice(updatedAdvertisement.getPrice());

                    }
                   if (updatedAdvertisement.isActive()==false ){
                        existingAdvertisement.setActive(false);
                    }
                    return advertisementRepository.save(existingAdvertisement);

                })
                .orElseThrow(()-> new Exception("Advertisement with id: "+ id + " was not found to update!"));
    }*/
}





//for reference to user
   /* @Autowired
    UserRepository userRepository;*/

/*NEW CODES WITH DTO CLASSES
    //create an advertisement

    public Advertisement createAdvertisement(@Valid AdvertisementDTO advertisementDTO) {
        User user = userRepository.findById(advertisementDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id"));

        //the list with advertisements, so need a loop to find right id

        List<Advertisement> advertisements = new ArrayList<>();
        for (String advertisementId : advertisementDTO.getAdvertisementId()) {
            advertisements.add(advertisementRepository.findById(advertisementId))
                    .orElseThrow(() -> new IllegalArgumentException("Invalid advertisement id"));
        }
    }

    //get all advertisements

    public List<Advertisement> getAllAdvertisements(){
        return advertisementRepository.findAll();
    }


    // get an advertisement by id

    public Optional<Advertisement> getAdvertisementById(String id){
        return advertisementRepository.findById(id);
    }


    //delete an advertisement by id

    public void deleteAdvertisement(String id){
        advertisementRepository.deleteById(id);
    }

    ///update an advertisement

    public Advertisement updatedAdvertisement (String id, Advertisement updatedAdvertisement){
        return advertisementRepository.save(updatedAdvertisement);
    }
*/