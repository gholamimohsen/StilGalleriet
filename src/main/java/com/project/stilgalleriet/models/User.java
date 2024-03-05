package com.project.stilgalleriet.models;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    /*@DBRef
    private Set<Role> roles = new HashSet<>();*/

    private String firstName;

    private String lastName;

    @NotBlank //Is not activated, need @Valid
    private String email;

    @NotBlank //Is not activated, need @Valid
    private String password;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    //private Enum role;

    @CreatedDate
    private Date createdAt;

    private boolean isActive = true;

    //Add DBRef
    private ArrayList<String> favorites = new ArrayList<>(); //Stores advertisement references(advertisementId)


    public User() {
    }


    public String getId() {
        return id;
    }

    /* Security risk to have setter for ID
    public void setId(String id) {
        this.id = id;
    }
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ArrayList<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<String> favorites) {
        this.favorites = favorites;
    }
}



